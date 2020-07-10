package com.srysoft.redditDemo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.srysoft.redditDemo.model.User;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatch, User> {

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		return user.getPassword().equals(user.getConfirmPassword());
	}

}
