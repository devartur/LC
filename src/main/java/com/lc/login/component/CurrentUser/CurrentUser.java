package com.lc.login.component.CurrentUser;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;

public class CurrentUser {
	
	public static String getCurrentUserOpenId() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		DefaultOAuth2User principal = (DefaultOAuth2User) authentication.getPrincipal();
		String userOpenId = principal.getAttribute("id").toString();

		return userOpenId;
	}

}
