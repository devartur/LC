package com.lc.components.userQuestions.dto.response;

import java.time.LocalDateTime;

public class QuestionWithAddInfoResponseDto {
	
	private Long questionId;
	
	private String question;
	private String basicAnswer;
	private String intermediateAnswer;
	private String advancedAnswer;
	
	private String userNote;
	
	

	public QuestionWithAddInfoResponseDto(Long questionId, String question, String basicAnswer,
			String intermediateAnswer, String advancedAnswer, String userNote) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.basicAnswer = basicAnswer;
		this.intermediateAnswer = intermediateAnswer;
		this.advancedAnswer = advancedAnswer;
		this.userNote = userNote;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getBasicAnswer() {
		return basicAnswer;
	}
	public void setBasicAnswer(String basicAnswer) {
		this.basicAnswer = basicAnswer;
	}
	public String getIntermediateAnswer() {
		return intermediateAnswer;
	}
	public void setIntermediateAnswer(String intermediateAnswer) {
		this.intermediateAnswer = intermediateAnswer;
	}
	public String getAdvancedAnswer() {
		return advancedAnswer;
	}
	public void setAdvancedAnswer(String advancedAnswer) {
		this.advancedAnswer = advancedAnswer;
	}
	public String getUserNote() {
		return userNote;
	}
	public void setUserNote(String userNote) {
		this.userNote = userNote;
	}

}
