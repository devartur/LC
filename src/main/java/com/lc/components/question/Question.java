package com.lc.components.question;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.lc.components.allQuestions.AllQuestions;
import com.lc.application.domain.User;

@Entity
public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column( columnDefinition = "NVARCHAR(MAX)")
	private String question;
	@Column( columnDefinition = "NVARCHAR(MAX)")
	private String basicAnswer;
	@Column( columnDefinition = "NVARCHAR(MAX)")
	private String intermediateAnswer;
	@Column( columnDefinition = "NVARCHAR(MAX)")
	private String advancedAnswer;
	private boolean isShowInAllQuestion; 
	
	private Date creationTime;
	private String creationBy;
	
	@ManyToOne
	@JoinColumn(name = "allQuestions_id")
	private AllQuestions allQuestions;
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "questions_users", joinColumns = { @JoinColumn(name = "questions_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
	private List<User> appaQuestionsUsers = new ArrayList<User>();

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

	public AllQuestions getAllQuestions() {
		return allQuestions;
	}

	public void setAllQuestions(AllQuestions allQuestions) {
		this.allQuestions = allQuestions;
	}
	
	public boolean isShowInAllQuestion() {
		return isShowInAllQuestion;
	}

	public void setShowInAllQuestion(boolean isShowInAllQuestion) {
		this.isShowInAllQuestion = isShowInAllQuestion;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advancedAnswer == null) ? 0 : advancedAnswer.hashCode());
		result = prime * result + ((allQuestions == null) ? 0 : allQuestions.hashCode());
		result = prime * result + ((basicAnswer == null) ? 0 : basicAnswer.hashCode());
		result = prime * result + ((creationBy == null) ? 0 : creationBy.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intermediateAnswer == null) ? 0 : intermediateAnswer.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Question other = (Question) obj;
		if (advancedAnswer == null) {
			if (other.advancedAnswer != null)
				return false;
		} else if (!advancedAnswer.equals(other.advancedAnswer))
			return false;
		if (allQuestions == null) {
			if (other.allQuestions != null)
				return false;
		} else if (!allQuestions.equals(other.allQuestions))
			return false;
		if (basicAnswer == null) {
			if (other.basicAnswer != null)
				return false;
		} else if (!basicAnswer.equals(other.basicAnswer))
			return false;
		if (creationBy == null) {
			if (other.creationBy != null)
				return false;
		} else if (!creationBy.equals(other.creationBy))
			return false;
		if (creationTime == null) {
			if (other.creationTime != null)
				return false;
		} else if (!creationTime.equals(other.creationTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (intermediateAnswer == null) {
			if (other.intermediateAnswer != null)
				return false;
		} else if (!intermediateAnswer.equals(other.intermediateAnswer))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}


	
}
