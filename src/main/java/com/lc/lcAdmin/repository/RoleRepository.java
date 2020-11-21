package com.lc.lcAdmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lc.application.domain.Role;

@Repository("LcAdminRoleRepository")
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByRoleName(String roleName);
}
