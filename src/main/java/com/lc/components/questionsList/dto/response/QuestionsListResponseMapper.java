package com.lc.components.questionsList.dto.response;

import com.lc.application.domain.QuestionsList;

public class QuestionsListResponseMapper {
	
	private QuestionsListResponseMapper() {};

	public static QuestionsListResponseDto toDto(QuestionsList questionsList ) {
		QuestionsListResponseDto dto = new QuestionsListResponseDto();
		
		dto.setId(questionsList.getId());
		dto.setName(questionsList.getName());
		dto.setDescription(questionsList.getDescription());
		return dto;
	}
	
	public static QuestionsList toEntity(QuestionsListResponseDto questionsList) {
		QuestionsList entity = new QuestionsList();
		
		entity.setId(questionsList.getId());
		entity.setName(questionsList.getName());
		entity.setDescription(questionsList.getDescription());
		
		return entity;
	}
}
