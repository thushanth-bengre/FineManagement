package com.me.transport.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.LoginDao;
import com.me.transport.pojo.Person;
import com.me.transport.pojo.Role;

@Controller
public class LoginController {
	
	@Autowired
	private LoginDao logindao;
	
	@RequestMapping(value = "/welcome" , method = RequestMethod.GET)
	public String userReg(Model model, Principal principal,HttpServletRequest request) {
		Person p = logindao.getUser(principal.getName());
		if(p == null) {
			model.addAttribute("loginError","User Authentication failed. Please try again!");
			return "loginFailed";
		}else{
			HttpSession session = request.getSession();
			session.setAttribute("person", p);
			if(p.getRole().equals(Role.USER)) {		
				return "redirect:/driverhome";
			}else if(p.getRole().equals(Role.TP)) {
				return "redirect:/policehome";
			}else {
				return "redirect:/dothome";
				}
			}
	}
	
	@RequestMapping(value = "/driverhome")
	public String driverHome() {
		return "driverhome";
	}
	@RequestMapping(value = "/policehome")
	public String policeHome() {
		return "policehome";
	} 
	@RequestMapping(value = "/dothome")
	public String dotHome() {
		return "dothome";
	} 
}
