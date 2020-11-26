package com.lc.login.component.security;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lc.application.component.CurrentUser;
import com.lc.application.domain.User;
import com.lc.login.dto.response.SecurityResponseDTO;
import com.lc.login.repository.UserRepository;
import com.lc.login.component.tool.AuthoritiesConverter;


@Component
public class CustomAuthSuccessHandler implements AuthenticationSuccessHandler {

	private static final Logger LOG = LoggerFactory.getLogger(CustomAuthSuccessHandler.class);

	private AuthoritiesConverter authoritiesConverter;

	private ObjectMapper objectMapper;

	private UserRepository userRepository;

	private CurrentUser currentUser;
	

	@Autowired
	public CustomAuthSuccessHandler(AuthoritiesConverter authoritiesConverter, ObjectMapper objectMapper,
			UserRepository userRepository, CurrentUser currentUser) {
		this.authoritiesConverter = authoritiesConverter;
		this.objectMapper = objectMapper;
		this.currentUser = currentUser;
		this.userRepository = userRepository;
	}

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		LOG.info("onAuthenticationSuccess - set status to HttpServletResponse.SC_OK");

		String responseBody = createResponse(authentication);

		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter responseWriter = response.getWriter();
		responseWriter.print(responseBody);
		responseWriter.flush();
	}

	private String createResponse(Authentication authentication) throws JsonProcessingException {

		Object principal = authentication.getPrincipal();
		if (principal instanceof UserDetails) {

			User user = userRepository.findByEmail(((UserDetails) authentication.getPrincipal()).getUsername());
			currentUser.setId(user.getId());
			

			UserDetails userDetails = (UserDetails) principal;
			Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
			List<String> roles = authoritiesConverter.convert(authorities);

			SecurityResponseDTO securityDto = new SecurityResponseDTO();
			securityDto.setRoles(roles);
			securityDto.setEmail(userDetails.getUsername());

			String response = objectMapper.writeValueAsString(securityDto);
			LOG.info("createResponse: " + response);

			return response;
		}

		throw new IllegalArgumentException("Principal invalid");
	}
}
