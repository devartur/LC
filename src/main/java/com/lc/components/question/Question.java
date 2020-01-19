package com.lc.components.question;

import java.sql.Date;
import java.util.List;

import javax.persistence.*;

import com.lc.components.allQuestions.AllQuestions;

@Entity
public class Question {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String question;
	private String basicAnswer;
	private String intermediateAnswer;
	private String advancedAnswer;
	
	private Date creationTime;
	private String creationBy;
	
	// poniższe pola trzeba odseparować ta informacja musi być przypisana do pracownika pytania muszą być 
	// bezstanowe , nie moze być informacji użytkownika w pytaniach, ewentualnie mogą zostać jako zarządzanie pytaniami z mojej strony
	// ale taka informacja musi być w detalach
	private boolean isShowInAllQuestion; // czy pytanie będzie dalej wyświetlana w listach zadań do dodania
	private boolean isShowInMyQuestion; // czy pytanie będzie dalej wyświetlana w moich zadaniach
	
	@ManyToOne
	@JoinColumn(name = "allQuestions_id")
	private AllQuestions allQuestions;
	
	@OneToMany(mappedBy = "id")
	private List<DetailsQuestion> detailQuestion;

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((advancedAnswer == null) ? 0 : advancedAnswer.hashCode());
		result = prime * result + ((allQuestions == null) ? 0 : allQuestions.hashCode());
		result = prime * result + ((basicAnswer == null) ? 0 : basicAnswer.hashCode());
		result = prime * result + ((creationBy == null) ? 0 : creationBy.hashCode());
		result = prime * result + ((creationTime == null) ? 0 : creationTime.hashCode());
		result = prime * result + ((detailQuestion == null) ? 0 : detailQuestion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((intermediateAnswer == null) ? 0 : intermediateAnswer.hashCode());
		result = prime * result + (isShowInAllQuestion ? 1231 : 1237);
		result = prime * result + (isShowInMyQuestion ? 1231 : 1237);
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
		if (detailQuestion == null) {
			if (other.detailQuestion != null)
				return false;
		} else if (!detailQuestion.equals(other.detailQuestion))
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
		if (isShowInAllQuestion != other.isShowInAllQuestion)
			return false;
		if (isShowInMyQuestion != other.isShowInMyQuestion)
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		return true;
	}

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

	public AllQuestions getAllQuestions() {
		return allQuestions;
	}

	public void setAllQuestions(AllQuestions allQuestions) {
		this.allQuestions = allQuestions;
	}

	public List<DetailsQuestion> getDetailQuestion() {
		return detailQuestion;
	}

	public void setDetailQuestion(List<DetailsQuestion> detailQuestion) {
		this.detailQuestion = detailQuestion;
	}
	
	
	
	
	
	//mapowanie z AllQuestions po questionLevel
}
