package com.lc.components.questionListStatistics.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lc.application.domain.QuestionsList;
import com.lc.components.questionListStatistics.dto.resopnse.QuestionDataToStatisticsResponseDto;
import com.lc.components.questionListStatistics.dto.resopnse.QuestionsListStatisticsResponseDto;
import com.lc.components.questionListStatistics.service.QuestionsListStatisticsService;
import com.lc.components.questionsList.service.QuestionsListService;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class QuestionListStatisticsController {
	
	QuestionsListStatisticsService questionsListStatisticsService;
	
	public QuestionListStatisticsController(QuestionsListStatisticsService questionsListStatisticsService) {
		this.questionsListStatisticsService = questionsListStatisticsService;
	}
	
	@GetMapping("questions-list-statistics")
	public  QuestionsListStatisticsResponseDto getQuestionsListStatistics(@RequestParam("questionsListId") Long questionsListId){
		return questionsListStatisticsService.getQuestionsListStatistics(questionsListId);
	}

	@GetMapping("question-data-to-statistics")
	public  List<QuestionDataToStatisticsResponseDto> getQuestionDataToStatistics(@RequestParam("questionsListId") Long questionsListId){
		return questionsListStatisticsService.getQuestionDataToStatistics(questionsListId);
	}
}
