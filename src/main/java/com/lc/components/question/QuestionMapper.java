package com.lc.components.question;

public class QuestionMapper {
	
	static QuestionDto toDto(Question question) {
		QuestionDto dto = new QuestionDto();
		
		
		dto.setId(question.getId());
		dto.setQuestion(question.getQuestion());
		dto.setBasicAnswer(question.getBasicAnswer());
		dto.setIntermediateAnswer(question.getIntermediateAnswer());
		dto.setAdvancedAnswer(question.getAdvancedAnswer());
		dto.setCreationTime(question.getCreationTime());
		dto.setCreationBy(question.getCreationBy());
		dto.setShowInAllQuestion(question.isShowInAllQuestion());
		return dto;
	}
	
	
	
	static Question toEntity(QuestionDto question) {
		Question entity = new Question();
		
		entity.setId(question.getId());
		entity.setQuestion(question.getQuestion());
		entity.setBasicAnswer(question.getBasicAnswer());
		entity.setIntermediateAnswer(question.getIntermediateAnswer());
		entity.setAdvancedAnswer(question.getAdvancedAnswer());
		entity.setCreationTime(question.getCreationTime());
		entity.setCreationBy(question.getCreationBy());
		entity.setShowInAllQuestion(question.isShowInAllQuestion());
		return entity;
	}

}
