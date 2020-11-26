package com.lc.login.component.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthFailureHandler implements AuthenticationFailureHandler {
	
	private final Logger LOG = LoggerFactory.getLogger(CustomAuthFailureHandler.class);

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		LOG.info("onAuthenticationFailure - set status to HttpServletResponse.SC_UNAUTHORIZED");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}

}
