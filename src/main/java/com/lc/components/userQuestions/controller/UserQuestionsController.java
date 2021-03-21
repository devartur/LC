package com.lc.components.userQuestions.controller;



import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
		return userQuestionsService.findUserQuestionsWithAddInfoByUserQuestionsList(questionsListId);
	}
	 
	 @PatchMapping("user-questions/{id}")
	 @ResponseStatus(value = HttpStatus.OK)
	 public void updateQuestionWithAddInfo(@RequestBody Map<String, Object> updates, @PathVariable("id") Long questionId)  {
	    
		 userQuestionsService.partialUpdateQuestionWithAddInfo(updates, questionId);
	 }

}

