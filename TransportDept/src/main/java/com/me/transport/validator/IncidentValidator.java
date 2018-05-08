package com.me.transport.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.transport.pojo.Fine;
import com.me.transport.pojo.Incident;

@Component
public class IncidentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Incident.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "location", "location-FirstName","Location cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "date", "date-lastName","Date cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "summary", "summary-userName","Summary cannot be left Blank");
		
	}

}
