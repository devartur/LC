package com.lc.lcAdmin.service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lc.application.component.CurrentUser;
import com.lc.lcAdmin.dto.request.UserRequestDTO;
import com.lc.lcAdmin.dto.response.UserResponseDTO;
import com.lc.lcAdmin.repository.RoleRepository;
import com.lc.lcAdmin.repository.UserRepository;
import com.lc.application.component.MD5Encoder;
import com.lc.application.domain.Role;
import com.lc.application.domain.RoleEnum;
import com.lc.application.domain.User;
import com.lc.application.exception.ProcessException;

@Service("LCAdminUserServiceImpl")
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private CurrentUser currentUser;
	private MD5Encoder md5Encoder;
	
	
@Autowired
	public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, CurrentUser currentUser,
			MD5Encoder md5Encoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.currentUser = currentUser;
		this.md5Encoder = md5Encoder;
		
	}

	@Override
	public void saveUser(UserRequestDTO newUserRequestDTO) throws Exception {
		User newUser = new User();
		newUser.setUserName(newUserRequestDTO.getUserName());
		newUser.setEmail(newUserRequestDTO.getEmail());
		newUser.setPassword(md5Encoder.getMD5Hash(newUserRequestDTO.getNewPassword()));
		newUser.setActive(true);
		
		Role role = roleRepository.findByRoleName(RoleEnum.ROLE_USER.getValue());
		newUser.getRoles().add(role);
		
		userRepository.save(newUser);
	}

	@Override
	public void saveOrUpadteCurrentUser(UserRequestDTO currentUserRequestDTO) throws Exception {
		
		User user = userRepository.findById(currentUser.getId()).orElseThrow(userNotFound());

		if (currentUserRequestDTO.isPasswordChangeDetected()) {
			validateOldPassword(currentUserRequestDTO, user);
			user.setPassword(md5Encoder.getMD5Hash(currentUserRequestDTO.getNewPassword()));
		}
		user.setUserName(currentUserRequestDTO.getUserName());
		user.setEmail(currentUserRequestDTO.getEmail());
		
		userRepository.save(user);
	}

	@Override
	public UserResponseDTO getCurrentUser() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private Supplier<? extends RuntimeException> userNotFound() {
		return () -> new RuntimeException("User not found");
	}
	
	private void validateOldPassword(UserRequestDTO appaUserRequestDTO, User user)
			throws Exception {

		if (!user.getPassword().equals(md5Encoder.getMD5Hash(appaUserRequestDTO.getOldPassword()))) {
			throw new ProcessException("Old password is wrong");
		}
	}

}
