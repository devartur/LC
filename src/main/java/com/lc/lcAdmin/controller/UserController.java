package com.lc.lcAdmin.controller;

import javax.validation.Valid;
import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lc.lcAdmin.dto.request.UserRequestDTO;
import com.lc.lcAdmin.service.UserService;
import com.lc.lcAdmin.validator.PasswordCreateValid;
@RestController
@Validated
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Void> saveUser(
			@Valid @RequestBody @PasswordCreateValid UserRequestDTO newUserRequestDTO,BindingResult bindingResult) throws Exception{
		
		if(bindingResult.hasErrors()) {
			throw new ValidationException();
		}
		userService.saveUser(newUserRequestDTO);
		
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}

//http://localhost:8080/api/user/registration