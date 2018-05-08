package com.me.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.transport.dao.UserRegistrationDao;
import com.me.transport.pojo.VDriver;
import com.me.transport.validator.DriverValidator;

@Controller
public class UserRegistrationController {
	
	@Autowired
	private DriverValidator personvalidator;
	
	@Autowired
	private UserRegistrationDao userRegistrationdao;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(personvalidator);
	}
	
	@RequestMapping(value = "/newUser" , method = RequestMethod.POST)
	public String userReg(@Validated @ModelAttribute("person") VDriver vdriver, BindingResult result,Model model) {
		System.out.println(vdriver.getFirstName());
		if(result.hasErrors()) {
			return "newUserRegistrationForm";
		}		
		userRegistrationdao.addUser(vdriver);	
		return "loginForm";
	}
}


