package com.lc.application.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class QuestionAddInfo extends AbstractEntity<Long> {
	
	
	
	@Column(length = 4000)
	private String userNote;
	
	@Column(name = "next_answer_date")
	private LocalDateTime nextAnswerDateTime;
	
	@Column(name = "first_answer_date")
	private LocalDateTime firstAnswerDateTime;
	
	@Column(name = "marked_as_know_date")
	private LocalDateTime markedAsKnowDateTime;
	
	@Column(name = "is_marked_as_know", nullable = false)
	private boolean isMarkedAsKnow;

	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

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



	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((firstAnswerDateTime == null) ? 0 : firstAnswerDateTime.hashCode());
		result = prime * result + (isMarkedAsKnow ? 1231 : 1237);
		result = prime * result + ((markedAsKnowDateTime == null) ? 0 : markedAsKnowDateTime.hashCode());
		result = prime * result + ((nextAnswerDateTime == null) ? 0 : nextAnswerDateTime.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((userNote == null) ? 0 : userNote.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionAddInfo other = (QuestionAddInfo) obj;
		if (firstAnswerDateTime == null) {
			if (other.firstAnswerDateTime != null)
				return false;
		} else if (!firstAnswerDateTime.equals(other.firstAnswerDateTime))
			return false;
		if (isMarkedAsKnow != other.isMarkedAsKnow)
			return false;
		if (markedAsKnowDateTime == null) {
			if (other.markedAsKnowDateTime != null)
				return false;
		} else if (!markedAsKnowDateTime.equals(other.markedAsKnowDateTime))
			return false;
		if (nextAnswerDateTime == null) {
			if (other.nextAnswerDateTime != null)
				return false;
		} else if (!nextAnswerDateTime.equals(other.nextAnswerDateTime))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (userNote == null) {
			if (other.userNote != null)
				return false;
		} else if (!userNote.equals(other.userNote))
			return false;
		return true;
	}

}
