package com.lc.components.allQuestions;

import java.util.List;

import javax.persistence.OneToMany;

import com.lc.components.question.Question;

public class AllQuestionsDto {

	
	
	private Long id;
	private String firstLevel;
	private String secondLevel;
	private String thirdLevel;
	private String fourthLevel;
	private String fifthLevel;
	private String sixthLevel;
	private String questions;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstLevel() {
		return firstLevel;
	}
	public void setFirstLevel(String firstLevel) {
		this.firstLevel = firstLevel;
	}
	public String getSecondLevel() {
		return secondLevel;
	}
	public void setSecondLevel(String secondLevel) {
		this.secondLevel = secondLevel;
	}
	public String getThirdLevel() {
		return thirdLevel;
	}
	public void setThirdLevel(String thirdLevel) {
		this.thirdLevel = thirdLevel;
	}
	public String getFourthLevel() {
		return fourthLevel;
	}
	public void setFourthLevel(String fourthLevel) {
		this.fourthLevel = fourthLevel;
	}
	public String getFifthLevel() {
		return fifthLevel;
	}
	public void setFifthLevel(String fifthLevel) {
		this.fifthLevel = fifthLevel;
	}
	public String getSixthLevel() {
		return sixthLevel;
	}
	public void setSixthLevel(String sixthLevel) {
		this.sixthLevel = sixthLevel;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	
}
