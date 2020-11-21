package com.lc.lcAdmin.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.lc.lcAdmin.dto.request.UserRequestDTO;


public class PasswordCreateValidator implements ConstraintValidator<PasswordCreateValid, UserRequestDTO> {

	@Override
	public void initialize(PasswordCreateValid passwordCreateValid) {
	}

	@Override
	public boolean isValid(UserRequestDTO appaUserRequestDTO, ConstraintValidatorContext ctx) {


		ctx.disableDefaultConstraintViolation();

		if (!appaUserRequestDTO.getNewPassword().equals(appaUserRequestDTO.getNewRepeatedPassword())) {
			ctx.buildConstraintViolationWithTemplate("Passwords don't match").addConstraintViolation();
			return false;
		} else if (!isValidSize(appaUserRequestDTO)) {
			ctx.buildConstraintViolationWithTemplate("Password has incorrect length").addConstraintViolation();
			return false;
		}

		return true;
	}

	private boolean isValidSize(UserRequestDTO appaUserRequestDTO) {

		return appaUserRequestDTO.getNewPassword().length() >= 6 && appaUserRequestDTO.getNewPassword().length() <= 20;
	}
}
