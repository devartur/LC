package com.lc.components.questionsList.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lc.application.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public User findByOpenId(String openId);

}
