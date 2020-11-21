package com.lc.lcAdmin.dto.response;

public class UserResponseDTO {
	
	private Long id;

	private String userName;

	private String email;

	private String password;

	private String roleName;

	public UserResponseDTO(String userName, String email, String password, String newRepeatedPassword,
			String roleName) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.roleName = roleName;
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


}
