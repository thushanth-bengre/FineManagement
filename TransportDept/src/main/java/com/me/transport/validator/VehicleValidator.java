package com.me.transport.validator;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.me.transport.dao.DAO;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Vehicle;

@Component
public class VehicleValidator extends DAO implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Vehicle.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Vehicle v = (Vehicle) target;
		Criteria c = getSession().createCriteria(Vehicle.class);
		c.add(Restrictions.eq("vin", v.getVin()));
		c.setMaxResults(1);
		if(c.uniqueResult()!=null) {
			errors.rejectValue("vin", "vin-Exists", "Vehicle already exists");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "vin", "empty-vin","VIN cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "model", "empty-model","Model Plate cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "yearManufactured", "empty-yearManufactured","Manufactured Year cannot be left Blank");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "manufacturer", "empty-manufacturer","Manufacturer cannot be left Blank");
	}

}
