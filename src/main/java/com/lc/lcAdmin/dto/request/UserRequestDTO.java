package com.lc.lcAdmin.dto.request;

import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserRequestDTO {

	@NotNull
	@Size(min = 1, max = 20)
	private String userName;
	
	
	@NotNull
	@Size(min = 1, max = 120)
	private String email;

	private String oldPassword;

	private String newPassword;

	private String newRepeatedPassword;

	private String roleName;

	public UserRequestDTO(String userName, String email, String newPassword, String newRepeatedPassword,
			String roleName) {
		super();
		this.userName = userName;
		this.email = email;
		this.newPassword = newPassword;
		this.newRepeatedPassword = newRepeatedPassword;
		this.roleName = roleName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getNewRepeatedPassword() {
		return newRepeatedPassword;
	}

	public void setNewRepeatedPassword(String newRepeatedPassword) {
		this.newRepeatedPassword = newRepeatedPassword;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "UserRequestDTO [userName=" + userName + ", email=" + email + ", roleName=" + roleName + "]";
	}

	public boolean isPasswordChangeDetected() {
		return this.newPassword != null;
	}

}
