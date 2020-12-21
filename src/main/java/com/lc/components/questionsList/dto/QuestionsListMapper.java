package com.lc.components.questionsList.dto;

import com.lc.application.domain.QuestionsList;

public class QuestionsListMapper {
	
	private QuestionsListMapper() {};
	
	public static QuestionsListDto toDto(QuestionsList questionsList ) {
		QuestionsListDto dto = new QuestionsListDto();
		
		dto.setId(questionsList.getId());
		dto.setName(questionsList.getName());
		dto.setDescription(questionsList.getDescription());
		
		return dto;
	}
	
	public static QuestionsList toEntity(QuestionsListDto questionsList) {
		QuestionsList entity = new QuestionsList();
		
		entity.setId(questionsList.getId());
		entity.setName(questionsList.getName());
		entity.setDescription(questionsList.getDescription());
		
		return entity;
	}
	

}
