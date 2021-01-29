package com.lc.application.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
public class QuestionsList extends AbstractEntity<Long> {
	
	@Column(length = 255)
	private String name;

	@Column(length = 4000)
	private String description;
	
	@ManyToMany
	@JoinTable(name = "questionsList_users", joinColumns = { @JoinColumn(name = "questionsList_id") }, inverseJoinColumns = {
			@JoinColumn(name = "users_id") })
	private List<User> users = new ArrayList<User>();
	
	@ManyToMany
	@JoinTable(name = "questionsList_questions", joinColumns = { @JoinColumn(name = "questionsList_id") }, inverseJoinColumns = {
			@JoinColumn(name = "questions_id") })
	private List<Question> questions = new ArrayList<Question>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	

}
