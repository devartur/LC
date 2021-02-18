package com.lc.components.userQuestions.dto.response;

import com.lc.application.domain.Question;
import com.lc.application.domain.QuestionAddInfo;

public class QuestionWithAddInfoResponseDtoMapper {
	
	private QuestionWithAddInfoResponseDtoMapper() {};
	
	public static QuestionWithAddInfoResponseDto toDto(Question question) {
		
		QuestionWithAddInfoResponseDto dto = new QuestionWithAddInfoResponseDto();
		
		dto.setQuestionId(question.getId());
		dto.setQuestion(question.getQuestion());
		dto.setBasicAnswer(question.getBasicAnswer());
		dto.setIntermediateAnswer(question.getIntermediateAnswer());
		dto.setAdvancedAnswer(question.getAdvancedAnswer());
		
		
		if(!question.getQuestionAddInfos().isEmpty()) {
		QuestionAddInfo questionAddInfo = question.getQuestionAddInfos().get(0);
		dto.setUserNote(questionAddInfo.getUserNote());
		dto.setNextAnswerDateTime(questionAddInfo.getNextAnswerDateTime());
		dto.setFirstAnswerDateTime(questionAddInfo.getFirstAnswerDateTime());
		dto.setMarkedAsKnowDateTime(questionAddInfo.getMarkedAsKnowDateTime());
		dto.setMarkedAsKnow(questionAddInfo.isMarkedAsKnow());
		}
		return dto;
	}
	
}