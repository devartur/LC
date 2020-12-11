package com.lc.components.allQuestions.dto;

import com.lc.application.domain.AllQuestions;

public class AllQuestionsMapper {
	
	private AllQuestionsMapper() {}

	public static AllQuestionsDto toDto(AllQuestions allQuestions) {
		AllQuestionsDto dto = new AllQuestionsDto();
		dto.setId(allQuestions.getId());
		dto.setFirstLevel(allQuestions.getFirstLevel());
		dto.setSecondLevel(allQuestions.getSecondLevel());
		dto.setThirdLevel(allQuestions.getThirdLevel());
		dto.setFourthLevel(allQuestions.getFourthLevel());
		dto.setFifthLevel(allQuestions.getFifthLevel());
		
		return dto;
	}

	public static AllQuestions toEntity(AllQuestionsDto allQuestions) {
		AllQuestions entity = new AllQuestions();
		entity.setId(allQuestions.getId());
		entity.setFirstLevel(allQuestions.getFirstLevel());
		entity.setSecondLevel(allQuestions.getSecondLevel());
		entity.setThirdLevel(allQuestions.getThirdLevel());
		entity.setFourthLevel(allQuestions.getFourthLevel());
		entity.setFifthLevel(allQuestions.getFifthLevel());
		return entity;
	}
}

