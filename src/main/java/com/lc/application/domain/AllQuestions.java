package com.lc.application.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class AllQuestions {

	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotNull
 	private String firstLevel;
	@NotNull
    private String secondLevel;
	@NotNull
    private String thirdLevel;
    private String fourthLevel;
    private String fifthLevel; 
    private String sixthLevel;
    
    @OneToMany(mappedBy = "allQuestions")
    private List<Question> questions = new ArrayList<>(); 
    
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
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fifthLevel == null) ? 0 : fifthLevel.hashCode());
		result = prime * result + ((firstLevel == null) ? 0 : firstLevel.hashCode());
		result = prime * result + ((fourthLevel == null) ? 0 : fourthLevel.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((questions == null) ? 0 : questions.hashCode());
		result = prime * result + ((secondLevel == null) ? 0 : secondLevel.hashCode());
		result = prime * result + ((sixthLevel == null) ? 0 : sixthLevel.hashCode());
		result = prime * result + ((thirdLevel == null) ? 0 : thirdLevel.hashCode());
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
		AllQuestions other = (AllQuestions) obj;
		if (fifthLevel == null) {
			if (other.fifthLevel != null)
				return false;
		} else if (!fifthLevel.equals(other.fifthLevel))
			return false;
		if (firstLevel == null) {
			if (other.firstLevel != null)
				return false;
		} else if (!firstLevel.equals(other.firstLevel))
			return false;
		if (fourthLevel == null) {
			if (other.fourthLevel != null)
				return false;
		} else if (!fourthLevel.equals(other.fourthLevel))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (questions == null) {
			if (other.questions != null)
				return false;
		} else if (!questions.equals(other.questions))
			return false;
		if (secondLevel == null) {
			if (other.secondLevel != null)
				return false;
		} else if (!secondLevel.equals(other.secondLevel))
			return false;
		if (sixthLevel == null) {
			if (other.sixthLevel != null)
				return false;
		} else if (!sixthLevel.equals(other.sixthLevel))
			return false;
		if (thirdLevel == null) {
			if (other.thirdLevel != null)
				return false;
		} else if (!thirdLevel.equals(other.thirdLevel))
			return false;
		return true;
	}  
}
