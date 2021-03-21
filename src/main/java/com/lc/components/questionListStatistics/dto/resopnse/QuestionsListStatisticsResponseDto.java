package com.lc.components.questionListStatistics.dto.resopnse;

public class QuestionsListStatisticsResponseDto {

	private Long questionsListId;

	private int questionsNumber;
	private int questionsMarkedAsKnowNumber;
	private int repetitionsNumber;
	private int repetitionsTodayNumber;
	
	
	
	public QuestionsListStatisticsResponseDto(Long questionsListId, int questionsNumber,
			int questionsMarkedAsKnowNumber, int repetitionsNumber, int repetitionsTodayNumber) {
		super();
		this.questionsListId = questionsListId;
		this.questionsNumber = questionsNumber;
		this.questionsMarkedAsKnowNumber = questionsMarkedAsKnowNumber;
		this.repetitionsNumber = repetitionsNumber;
		this.setRepetitionsTodayNumber(repetitionsTodayNumber);
	}
	public Long getQuestionsListId() {
		return questionsListId;
	}
	public void setQuestionsListId(Long questionsListId) {
		this.questionsListId = questionsListId;
	}
	public int getQuestionsNumber() {
		return questionsNumber;
	}
	public void setQuestionsNumber(int questionsNumber) {
		this.questionsNumber = questionsNumber;
	}
	public int getQuestionsMarkedAsKnowNumber() {
		return questionsMarkedAsKnowNumber;
	}
	public void setQuestionsMarkedAsKnowNumber(int questionsMarkedAsKnowNumber) {
		this.questionsMarkedAsKnowNumber = questionsMarkedAsKnowNumber;
	}
	public int getRepetitionsNumber() {
		return repetitionsNumber;
	}
	public void setRepetitionsNumber(int repetitionsNumber) {
		this.repetitionsNumber = repetitionsNumber;
	}
	public int getRepetitionsTodayNumber() {
		return repetitionsTodayNumber;
	}
	public void setRepetitionsTodayNumber(int repetitionsTodayNumber) {
		this.repetitionsTodayNumber = repetitionsTodayNumber;
	}
	
	
	
}