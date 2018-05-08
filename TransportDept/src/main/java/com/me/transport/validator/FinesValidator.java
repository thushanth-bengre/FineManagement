package com.me.transport.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.transport.pojo.Fine;

@Component
public class FinesValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Fine.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "amount", "amount-FirstName","Amount cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title-lastName","Title cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "summary", "summary-userName","Summary cannot be left Blank");		
		
	}

}
