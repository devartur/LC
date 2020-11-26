package com.lc.login.component.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class CustomAuthEntryPoint implements AuthenticationEntryPoint {

	private final Logger LOG = LoggerFactory.getLogger(CustomAuthEntryPoint.class);

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e)
			throws IOException, ServletException {

		LOG.info("commence - set status to HttpServletResponse.SC_UNAUTHORIZED");
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	}
}