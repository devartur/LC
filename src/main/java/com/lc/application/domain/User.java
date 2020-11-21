package com.lc.application.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.lc.components.question.Question;


@Entity
@Table(name = "users")
public class User extends AbstractEntity<Long> {
	
	private String userName;
	private String email;
	private String password;
	private boolean active;
	private String token;
	private Date tokenTime;
	
	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST }, fetch = FetchType.LAZY)
	@JoinTable(name = "users_roles", joinColumns = { @JoinColumn(name = "user_id") }, inverseJoinColumns = {
			@JoinColumn(name = "role_id") })
	protected List<Role> roles = new ArrayList<Role>();
	
	@ManyToMany(cascade = { CascadeType.MERGE })
	@JoinTable(name = "questions_users", joinColumns = { @JoinColumn(name = "users_id") }, inverseJoinColumns = {
			@JoinColumn(name = "question_id") })
	private Set<Question> userQuestions = new HashSet<Question>();
	
	
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Set<Question> getUserQuestions() {
		return userQuestions;
	}

	public void setUserQuestions(Set<Question> userQuestions) {
		this.userQuestions = userQuestions;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenTime() {
		return tokenTime;
	}

	public void setTokenTime(Date tokenTime) {
		this.tokenTime = tokenTime;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", email=" + email + ", active=" + active +  "userQuestions=" + userQuestions + "]";
	}

}