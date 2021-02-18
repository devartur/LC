package com.lc.components.questionsList.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lc.components.questionsList.dto.request.QuestionsListRequestDto;
import com.lc.components.questionsList.dto.response.QuestionsListResponseDto;
import com.lc.components.questionsList.service.QuestionsListService;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class QuestionsListController {
	
	QuestionsListService questionsListService;
	
	public QuestionsListController(QuestionsListService questionsListService) {
		this.questionsListService = questionsListService;
	}
	
	 @GetMapping("questions-lists")
	public List<QuestionsListResponseDto> findQuestionsListByUserId(){
		 
		// List<QuestionsListResponseDto> findUserQuestionsList = questionsListService.findUserQuestionsList();
		 
		return questionsListService.findUserQuestionsList();
	}
	 
	 @PutMapping("questions-to-questions-lists")
	 @ResponseStatus(value = HttpStatus.OK)
	public void addQuestionsToQuestionsList(@RequestBody QuestionsListRequestDto questionsListDto,
	        BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
		    	//rzuć wyjątek
	        }
		 
		  questionsListService.addQuestionsToQuestionsList(questionsListDto);
		 
	 } 
	 
	 @PostMapping("questions-lists")
	 @ResponseStatus(value = HttpStatus.OK)
	public void addQuestionsList(@RequestBody QuestionsListRequestDto questionsListDto,
	        BindingResult bindingResult) {
		 if (bindingResult.hasErrors()) {
		    	//rzuć wyjątek
	        }
		 
		  questionsListService.addQuestionsList(questionsListDto);
		 
	 } 

}

