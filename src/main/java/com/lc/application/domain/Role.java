package com.lc.application.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;




@Entity
@Table(name = "roles")
public class Role extends AbstractEntity<Long> {

	@Column(name = "role_name", length = 30)
	private String roleName;

	@Column(length = 255)
	private String description;

	@Column(name = "active", nullable = false)
	private boolean active;

	@ManyToMany(mappedBy = "roles")
	private List<User> users = new ArrayList<User>();
	
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {

		return new StringBuilder().append("Role: ").append("roleName=").append(roleName).append(", description=").append( description)
				.append(", active=").append( active).toString();
	}
}
