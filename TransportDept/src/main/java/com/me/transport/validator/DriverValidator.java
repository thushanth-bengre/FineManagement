package com.me.transport.validator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.transport.dao.DAO;
import com.me.transport.pojo.Person;
import com.me.transport.pojo.VDriver;


@Component
public class DriverValidator extends DAO implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(VDriver.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		VDriver p = (VDriver) target;
		//checking is username is unique
		Criteria c = getSession().createCriteria(Person.class);
		c.add(Restrictions.eq("userName", p.getUserName()));
		c.setMaxResults(1);
		if(c.uniqueResult()!=null) {
			errors.rejectValue("userName", "username-Exists", "UserName is not available. Please select a different UserName");
		}
		//checking if LicenseNumber is unique
		Criteria c1 = getSession().createCriteria(VDriver.class);
		c1.add(Restrictions.eq("licenseNo", p.getLicenseNo()));
		c1.setMaxResults(1);
		if(c1.uniqueResult()!=null) {
			errors.rejectValue("licenseNo", "licenseNo-Exists", "License Number already exists in our System. Please enter the right License numer or login if you have already registered!");
		}		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "empty-FirstName","FirstName cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "empty-lastName","LastName cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "empty-userName","UserName cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password","Password cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "licenseNo", "licenseNo-password","License Number cannot be left Blank");
		
	}

}
