package com.lc.login.repository;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.ECDSASigner;
import com.nimbusds.jose.jwk.Curve;
import com.nimbusds.jose.jwk.ECKey;
import com.nimbusds.jose.jwk.gen.ECKeyGenerator;
import com.nimbusds.jwt.JWT;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

import java.security.interfaces.ECPrivateKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TokenStore {
    
    private final String tokenSignKey = "myTokenKey"; // zmienić żeby wczytywał się z propertisó a docelowo ze zmiennej środowiskowej

    // 2 Attributes which I’m going to get from Authentication object and will put them in the JWT which I’ll be using later on to construct the Authentication Object.
    private final String REG_ID = "clientRegistrationId";
    private final String NAMED_KEY = "namedAttributeKey";
    private final String AUTHORITIES = "authorities";
    private final String ATTRIBUTES = "attributes";

    // 3 The generateToken method will accept Authentication object and build JWT token from that.
    public String generateToken( Authentication authentication ) throws Exception {

        OAuth2AuthenticationToken token = ( OAuth2AuthenticationToken ) authentication;
        DefaultOAuth2User userDetails = ( DefaultOAuth2User ) token.getPrincipal();
    
        // 4 Collecting all the authorities name
        List<String> auths = userDetails.getAuthorities()
                .stream()
                .map( GrantedAuthority::getAuthority )
                .collect( Collectors.toList());
        // 5 Preparing JWT claims with values like Subject, Authorities, Attributes, NamedAttributeKey (required by DefaultOAuth2User), and token expire time
        JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
                .subject(  userDetails.getAttribute("id").toString())
                .expirationTime( getDate( 5, ChronoUnit.HOURS ) )
                .claim( NAMED_KEY, "name" )
                .claim( ATTRIBUTES, userDetails.getAttributes() )
                .claim( AUTHORITIES, auths )
                .claim( REG_ID, token.getAuthorizedClientRegistrationId() )
                .build();

        // 6 Prepare Sign key to Sign the JWT token.
        ECKey key = new ECKeyGenerator( Curve.P_256 ).keyID( tokenSignKey ).generate();
        JWSHeader h = new JWSHeader.Builder( JWSAlgorithm.ES256 )
                .type( JOSEObjectType.JWT )
                .keyID( key.getKeyID() )
                .build();
        SignedJWT jwt = new SignedJWT( h, claimsSet );
        // 7 Sign the token and return.
        jwt.sign( new ECDSASigner( ( ECPrivateKey ) key.toPrivateKey() ) );
        return jwt.serialize();
    }

    // 8  The getAuth method takes JWT token and prepares the Authentication object from the valid token.
    public Authentication getAuth( String jwt ) throws Exception {
        SignedJWT signedJWT = SignedJWT.parse( jwt );
        // 9 Validating the JWT token currently I’m validating the expireTime only, but you can add your custom validation logic.
        validateJwt( signedJWT );

        JWTClaimsSet claimsSet = signedJWT.getJWTClaimsSet();
        
        // 10  Get required objects from JWT claims which will be used to prepare Authentication token.
        String clientRegistrationId = (String ) claimsSet.getClaim( REG_ID );
        String namedAttributeKey = (String) claimsSet.getClaim( NAMED_KEY );
        Map<String, Object> attributes = (Map<String, Object>)claimsSet.getClaim( ATTRIBUTES );
        Collection<? extends GrantedAuthority > authorities =( (List<String> ) claimsSet.getClaim( AUTHORITIES ))
                .stream().map( SimpleGrantedAuthority::new ).collect( Collectors.toSet());

        // 11 Prepare and return the valid OAuth2AuthenticationToken.
        return new OAuth2AuthenticationToken(
                new DefaultOAuth2User( authorities, attributes, namedAttributeKey ),
                authorities,
                clientRegistrationId
        );
    }

    private static Date getDate( long amount, TemporalUnit unit ) {
        return Date.from(
                LocalDateTime.now()
                .plus( amount, unit )
                .atZone( ZoneId.systemDefault() )
                .toInstant()
        );
    }

    private void validateJwt( JWT jwt ) throws Exception {
        // 12 Validating the expirationTime with current time.
        if(jwt.getJWTClaimsSet().getExpirationTime().before( new Date() )){
            throw new RuntimeException("Token Expired!!");
        }

        // Add validation logic here..
    }
}