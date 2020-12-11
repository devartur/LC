package com.lc.login.component.security.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.lc.login.repository.TokenStore;

@Component
public class TokenFilter extends OncePerRequestFilter {
	
	private final TokenStore tokenStore;
	
	

	public TokenFilter(TokenStore tokenStore) {
		this.tokenStore = tokenStore;
	}



	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String authToken = request.getHeader("Authorization");
		
		if(authToken != null) {
			String token = authToken.split(" ")[1];// poprawić na lepsze rozwiązanie
			Authentication authentication = null;
			try {
				authentication = tokenStore.getAuth(token);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(authentication != null) {
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}
		filterChain.doFilter(request, response);
		
	}

}
