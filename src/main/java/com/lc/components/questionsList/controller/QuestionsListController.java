package com.lc.components.questionsList.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.components.questionsList.dto.QuestionsListDto;
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
	List<QuestionsListDto> findQuestionsListByUserId(){
		 
		 List<QuestionsListDto> findUserQuestionsList = questionsListService.findUserQuestionsList();
		 
		return questionsListService.findUserQuestionsList();
	}

}
