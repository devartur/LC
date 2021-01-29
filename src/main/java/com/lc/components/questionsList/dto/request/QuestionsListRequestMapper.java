package com.lc.components.questionsList.dto.request;

import com.lc.application.domain.QuestionsList;

public class QuestionsListRequestMapper {
	
	private QuestionsListRequestMapper() {};
	
	public static QuestionsListRequestDto toDto(QuestionsList questionsList ) {
		QuestionsListRequestDto dto = new QuestionsListRequestDto();
		
		dto.setId(questionsList.getId());
		dto.setName(questionsList.getName());
		dto.setDescription(questionsList.getDescription());
		dto.setQuestions(questionsList.getQuestions());
		return dto;
	}
	
	public static QuestionsList toEntity(QuestionsListRequestDto questionsList) {
		QuestionsList entity = new QuestionsList();
		
		entity.setId(questionsList.getId());
		entity.setName(questionsList.getName());
		entity.setDescription(questionsList.getDescription());
		entity.setQuestions(questionsList.getQuestions());
		
		return entity;
	}
	

}
