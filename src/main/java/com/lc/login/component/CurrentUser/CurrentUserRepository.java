package com.lc.login.component.CurrentUser;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lc.application.domain.User;

public interface CurrentUserRepository extends JpaRepository<User, Long> {
	
	public User findByOpenId(String openId);

}
