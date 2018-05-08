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
import com.me.transport.pojo.DOT;
import com.me.transport.validator.DOTValidator;

@Controller
public class DOTRegistrationController {
	
	@Autowired
	private DOTValidator personvalidator;
	
	@Autowired
	private UserRegistrationDao userRegistrationdao;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(personvalidator);
	}
	
	@RequestMapping(value = "/newDOT" , method = RequestMethod.POST)
	public String userReg(@Validated @ModelAttribute("person") DOT dot, BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "newdotRegistrationForm";
		}		
		userRegistrationdao.addDot(dot);
		return "loginForm";
	}
}
