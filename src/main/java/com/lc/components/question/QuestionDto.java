package com.lc.components.question;

import java.sql.Date;

public class QuestionDto {
	
	private Long id;
	
	private String question;
	private String basicAnswer;
	private String intermediateAnswer;
	private String advancedAnswer;
	
	private Date creationTime;
	private String creationBy;
	private boolean isShowInAllQuestion; 
	private boolean isShowInMyQuestion;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	public String getCreationBy() {
		return creationBy;
	}
	public void setCreationBy(String creationBy) {
		this.creationBy = creationBy;
	}
	public boolean isShowInAllQuestion() {
		return isShowInAllQuestion;
	}
	public void setShowInAllQuestion(boolean isShowInAllQuestion) {
		this.isShowInAllQuestion = isShowInAllQuestion;
	}
	public boolean isShowInMyQuestion() {
		return isShowInMyQuestion;
	}
	public void setShowInMyQuestion(boolean isShowInMyQuestion) {
		this.isShowInMyQuestion = isShowInMyQuestion;
	}

}
