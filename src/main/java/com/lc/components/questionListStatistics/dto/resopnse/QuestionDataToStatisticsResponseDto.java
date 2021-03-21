package com.lc.components.questionListStatistics.dto.resopnse;

public class QuestionDataToStatisticsResponseDto {

	private Long questionId;

	private String question;
	private String isQuestionMarkedAsKnow;
	private String questionMarkedAsKnowDate;
	
	
	
	public QuestionDataToStatisticsResponseDto(Long questionId, String question, String isQuestionMarkedAsKnow,
			String questionMarkedAsKnowDate) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.isQuestionMarkedAsKnow = isQuestionMarkedAsKnow;
		this.questionMarkedAsKnowDate = questionMarkedAsKnowDate;
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
	public String getQuestionMarkedAsKnowDate() {
		return questionMarkedAsKnowDate;
	}
	public void setQuestionMarkedAsKnowDate(String questionMarkedAsKnowDate) {
		this.questionMarkedAsKnowDate = questionMarkedAsKnowDate;
	}
	public String getIsQuestionMarkedAsKnow() {
		return isQuestionMarkedAsKnow;
	}
	public void setIsQuestionMarkedAsKnow(String isQuestionMarkedAsKnow) {
		this.isQuestionMarkedAsKnow = isQuestionMarkedAsKnow;
	}

}
