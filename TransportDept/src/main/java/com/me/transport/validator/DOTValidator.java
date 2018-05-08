package com.me.transport.validator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.transport.dao.DAO;
import com.me.transport.pojo.DOT;
import com.me.transport.pojo.Person;

@Component
public class DOTValidator extends DAO implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(DOT.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
				DOT p = (DOT) target;
				//checking is username is unique
				Criteria c = getSession().createCriteria(Person.class);
				c.add(Restrictions.eq("userName", p.getUserName()));
				c.setMaxResults(1);
				if(c.uniqueResult()!=null) {
					errors.rejectValue("userName", "username-Exists", "UserName is not available. Please select a different UserName");
				}
				//checking if LicenseNumber is unique
				Criteria c1 = getSession().createCriteria(DOT.class);
				c1.add(Restrictions.eq("employeeId", p.getEmployeeId()));
				c1.setMaxResults(1);
				if(c1.uniqueResult()!=null) {
					errors.rejectValue("employeeId", "employeeId-Exists", "Employee Id already exists in our System. Please enter the right Employee Id or login if you have already registered!");
				}			
				
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "empty-FirstName","FirstName cannot be left Blank");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "empty-lastName","LastName cannot be left Blank");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "empty-userName","UserName cannot be left Blank");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty-password","Password cannot be left Blank");
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "employeeId", "employeeId-password","Employee Id cannot be left Blank");
		
	}

}
