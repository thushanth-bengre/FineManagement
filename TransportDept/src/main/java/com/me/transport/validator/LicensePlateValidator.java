package com.me.transport.validator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.transport.dao.DAO;
import com.me.transport.pojo.DOT;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Person;

@Component
public class LicensePlateValidator extends DAO implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(LicensePlate.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		LicensePlate lp = (LicensePlate) target;
		Criteria c = getSession().createCriteria(LicensePlate.class);
		c.add(Restrictions.eq("lpNumber", lp.getLpNumber()));
		c.setMaxResults(1);
		if(c.uniqueResult()!=null) {
			errors.rejectValue("lpNumber", "lpNumber-Exists", "License Plate already exists");
		}
		if(lp.getLpNumber().length() >7) {
			errors.rejectValue("lpNumber", "lpNumber-Exists", "Invalid License Plate");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lpNumber", "empty-lpNumber","License Plate cannot be left Blank");
		
	}

}
