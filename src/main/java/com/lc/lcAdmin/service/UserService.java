package com.lc.lcAdmin.service;

import com.lc.lcAdmin.dto.request.UserRequestDTO;
import com.lc.lcAdmin.dto.response.UserResponseDTO;

public interface UserService {
	
	void saveUser(UserRequestDTO newUserRequestDTO) throws Exception; 
	
	void saveOrUpadteCurrentUser(UserRequestDTO currentUserRequestDTO) throws Exception;
	
	UserResponseDTO getCurrentUser();

}
