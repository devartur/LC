package com.lc.login.component.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.application.domain.User;
import com.lc.login.repository.InMemoryRequestRepository;
import com.lc.login.repository.TokenStore;
import com.lc.login.repository.UserRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final ObjectMapper mapper;
    private final TokenStore tokenStore;
    private final TokenFilter tokenFilter;
    private final UserRepository userRepository;

    public SecurityConfig( ObjectMapper mapper, TokenStore tokenStore,
                           TokenFilter tokenFilter, UserRepository userRepository ) {
		this.mapper = mapper;
        this.tokenStore = tokenStore;
        this.tokenFilter = tokenFilter;
        this.userRepository = userRepository;
    }

    @Override
    protected void configure( HttpSecurity http ) throws Exception {
        http.csrf().ignoringAntMatchers("/h2-console/**","/logout**").and().cors()
        	  .and().headers().frameOptions().disable()  //wyłączony dla bazy h2 produkcjnie włączyć 
        	  .and()
        			.authorizeRequests().antMatchers( "/oauth2/**", "/login**").permitAll()
              .and()
                .authorizeRequests()
                .antMatchers("/h2-console/**").permitAll()
                .anyRequest().authenticated()
              .and()
                .oauth2Login()
                .authorizationEndpoint()
                .authorizationRequestRepository( new InMemoryRequestRepository() )
              .and()
                .successHandler( this::successHandler )
              .and()
                .exceptionHandling()
                .authenticationEntryPoint( this::authenticationEntryPoint )
              .and()
              	.logout(cust -> cust.addLogoutHandler( this::logout ).logoutSuccessHandler( this::onLogoutSuccess ));
        http.addFilterBefore( tokenFilter, UsernamePasswordAuthenticationFilter.class );
    }

    private void logout(HttpServletRequest request, HttpServletResponse response,
                Authentication authentication) {
        // You can process token here
    	
String authToken = request.getHeader("Authorization");
		
		/*
		 * if(authToken != null) { String token = authToken.split(" ")[1];// poprawić na
		 * lepsze rozwiązanie tokenStore.removeToken(token); }
		 */
    }

    void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
                         Authentication authentication) throws IOException, ServletException {
        response.setStatus( HttpServletResponse.SC_OK );
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedMethods( Collections.singletonList( "*" ) );
        config.setAllowedOrigins( Collections.singletonList( "*" ) );
        config.setAllowedHeaders( Collections.singletonList( "*" ) );

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration( "/**", config );
        return source;
    }


    private void successHandler( HttpServletRequest request,
                                 HttpServletResponse response, Authentication authentication ) throws IOException {
        String token = null;
		try {
			token = tokenStore.generateToken( authentication );
		} catch (Exception e) {
			e.printStackTrace();
		}
        
       
        DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
		String userOpenId = principal.getAttribute("id").toString();
		User currentUser = userRepository.findByOpenId(userOpenId);
		
		if(currentUser == null) {
			User newUser = new User();
			newUser.setActive(true);
			newUser.setOpenId(userOpenId);
			newUser.setToken(token);
			userRepository.save(newUser);
		}
		
        response.getWriter().write(
                mapper.writeValueAsString( Collections.singletonMap( "accessToken", token ) )
        );
    }

    private void authenticationEntryPoint( HttpServletRequest request, HttpServletResponse response,
                                           AuthenticationException authException ) throws IOException {
        response.setStatus( HttpServletResponse.SC_UNAUTHORIZED );
        response.getWriter().write( mapper.writeValueAsString( Collections.singletonMap( "error", "Unauthenticated" ) ) );
    }
}
