package com.lc.login.repository;

import java.security.Key;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.stereotype.Component;

import com.lc.login.component.CurrentUser.CurrentUser;
import com.lc.login.exception.ExpiredTokenException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

@Component
public class TokenStore {

	private Key TOKEN_SING_KEY = MacProvider.generateKey(SignatureAlgorithm.HS256);

	public static final long JWT_TOKEN_VALIDITY = 3 * 3600000;

	public Authentication getAuth(String jwtToken) throws Exception {
		
		if(isTokenExpired(jwtToken)) {
			throw new ExpiredTokenException( "Token is expired!");
		}
		
		Jws<Claims> claimsJws = Jwts.parser().setSigningKey(TOKEN_SING_KEY)
				.parseClaimsJws(jwtToken.replace("Bearer ", ""));

		String username = claimsJws.getBody().get("id").toString();
		String role = claimsJws.getBody().get("role").toString();

		Set<SimpleGrantedAuthority> simpleGrantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(role));

		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
				username, null, simpleGrantedAuthorities);
		return usernamePasswordAuthenticationToken;
	}

	public String generateToken(Authentication authentication) throws Exception {
		
		DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
		String userOpenId = principal.getAttribute("id").toString();

		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put("id", userOpenId);
		claims.put("role", "ROLE_USER");

		return Jwts.builder().setClaims(claims).setSubject("subject").setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY ))
				.signWith(SignatureAlgorithm.HS512, TOKEN_SING_KEY).compact();
	}


	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(TOKEN_SING_KEY).parseClaimsJws(token).getBody();
	}

	// check if the token has expired
	public Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}
}
