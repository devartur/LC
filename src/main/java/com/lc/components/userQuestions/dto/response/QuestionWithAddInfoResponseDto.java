package com.lc.components.userQuestions.dto.response;

import java.time.LocalDateTime;

public class QuestionWithAddInfoResponseDto {
	
	private Long questionId;
	private Long userId;
	
	private String question;
	private String basicAnswer;
	private String intermediateAnswer;
	private String advancedAnswer;
	
	private String userNote;
	private LocalDateTime nextAnswerDateTime;
	private LocalDateTime firstAnswerDateTime;
	private LocalDateTime markedAsKnowDateTime;
	private boolean isMarkedAsKnow;
	
	
	
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
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
	public LocalDateTime getNextAnswerDateTime() {
		return nextAnswerDateTime;
	}
	public void setNextAnswerDateTime(LocalDateTime nextAnswerDateTime) {
		this.nextAnswerDateTime = nextAnswerDateTime;
	}
	public LocalDateTime getFirstAnswerDateTime() {
		return firstAnswerDateTime;
	}
	public void setFirstAnswerDateTime(LocalDateTime firstAnswerDateTime) {
		this.firstAnswerDateTime = firstAnswerDateTime;
	}
	public LocalDateTime getMarkedAsKnowDateTime() {
		return markedAsKnowDateTime;
	}
	public void setMarkedAsKnowDateTime(LocalDateTime markedAsKnowDateTime) {
		this.markedAsKnowDateTime = markedAsKnowDateTime;
	}
	public boolean isMarkedAsKnow() {
		return isMarkedAsKnow;
	}
	public void setMarkedAsKnow(boolean isMarkedAsKnow) {
		this.isMarkedAsKnow = isMarkedAsKnow;
	}
	

}
