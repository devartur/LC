package com.lc.lcAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lc.application.domain.User;

@Repository("LCAdminUserRepository")
public interface UserRepository extends JpaRepository<User, Long> {

	
}
