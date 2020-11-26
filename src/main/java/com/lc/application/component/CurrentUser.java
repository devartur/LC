package com.lc.application.component;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {

	private Long id;

	private String userName;

	public long appaItemFakeId = 0;

	public synchronized long reset() {

		appaItemFakeId = 0;
		return appaItemFakeId;
	}

	public synchronized long inc() {
		return ++appaItemFakeId;
	}

	public synchronized long dec() {
		return --appaItemFakeId;
	}	

	public synchronized void setFakeId(Long fakeId) {
		this.appaItemFakeId = fakeId;
	}		
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
