package com.lc.application.domain;

public enum RoleEnum {

	ROLE_USER("USER");

	private final String value;

	RoleEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}