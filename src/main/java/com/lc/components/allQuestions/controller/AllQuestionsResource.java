package com.lc.components.allQuestions.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.components.allQuestions.dto.AllQuestionsDto;
import com.lc.components.allQuestions.service.AllQuestionsService;

@RestController
@RequestMapping("/api/all-questions-menu")
@CrossOrigin
public class AllQuestionsResource {

	
	private AllQuestionsService allQuestionsService;

    public AllQuestionsResource(AllQuestionsService allQuestionsService) {
        this.allQuestionsService = allQuestionsService;
    }
    
    
    @GetMapping("")
    List<AllQuestionsDto> findAll() {
    	 
        return allQuestionsService.findAll();
    }

}
