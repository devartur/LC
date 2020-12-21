package com.lc.login.component.CurrentUser;

import java.util.Collection;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class CurrentUser {
	
	public static String getCurrentUserOpenId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String userOpenId = (String) authentication.getPrincipal();
		//	DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
		//	String userOpenId = principal.getAttribute("id").toString();

		return userOpenId;
	}

}
