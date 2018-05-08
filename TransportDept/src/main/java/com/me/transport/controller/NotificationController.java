package com.me.transport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.VDriver;

@Controller
public class NotificationController {
	
	@RequestMapping(value = "notifications.htm" , method = RequestMethod.GET)
	public String searchReg(Model model) {		
		return "notifications";
	}

}
