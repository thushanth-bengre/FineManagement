package com.me.transport;

import java.sql.SQLException;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.transport.pojo.DOT;
import com.me.transport.pojo.TrafficPolice;
import com.me.transport.pojo.VDriver;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {	
	
	//Home page mapping
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		return "home";
	}
	
	//Registration user Redirect mapping
	@RequestMapping(value="registrationUser.htm", method = RequestMethod.GET)
	public String registerUser(Model model) throws SQLException {
		model.addAttribute("person",new VDriver());
		return "newUserRegistrationForm";
	}
	
	//Registration dot Redirect mapping
		@RequestMapping(value="registrationdot.htm", method = RequestMethod.GET)
		public String registerDOT(Model model) throws SQLException {
			model.addAttribute("person",new DOT());
			return "newdotRegistrationForm";
		}
		
		
	//Registration tp Redirect mapping
			@RequestMapping(value="registrationtp.htm", method = RequestMethod.GET)
			public String registerTP(Model model) throws SQLException {
				model.addAttribute("person",new TrafficPolice());
				return "newtpRegistrationForm";
			}
			
	//Login mapping
	@RequestMapping(value="login.htm", method = RequestMethod.GET)
	public String login(Model model) throws SQLException {		
		return "loginForm";
	}
		
	
}
