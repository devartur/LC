package com.lc.components.userQuestions.controller;



import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.components.allQuestions.dto.QuestionDto;
import com.lc.components.userQuestions.dto.response.QuestionWithAddInfoResponseDto;
import com.lc.components.userQuestions.service.UserQuestionsService;



@RestController
@RequestMapping("/api/")
@CrossOrigin
public class UserQuestionsController {
	
	UserQuestionsService userQuestionsService;
	
	public UserQuestionsController(UserQuestionsService userQuestionsService) {
		this.userQuestionsService = userQuestionsService;
	}
	
	 @GetMapping("user-questions-in-questions-lists")
	public List<QuestionWithAddInfoResponseDto> findUserQuestionsWithAddInfoByUserQuestionsList(@RequestParam("questionsListId") Long questionsListId){
		 List<QuestionWithAddInfoResponseDto> gg = userQuestionsService.findUserQuestionsWithAddInfoByUserQuestionsList(questionsListId);
		return userQuestionsService.findUserQuestionsWithAddInfoByUserQuestionsList(questionsListId);
	}
	 
	

}

