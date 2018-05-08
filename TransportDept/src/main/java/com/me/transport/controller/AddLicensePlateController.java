package com.me.transport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.LicensePlateDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.VDriver;
import com.me.transport.validator.LicensePlateValidator;

@Controller
public class AddLicensePlateController {
	@Autowired
	private LicensePlateValidator licensePlateValidator;
	
	@Autowired
	private LicensePlateDao licenseplatedao;
	
	@RequestMapping(value = "licenseplates.htm" , method = RequestMethod.GET)
	public String viewLP(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		VDriver driver = (VDriver) session.getAttribute("person");
		List<LicensePlate> licensePlates = licenseplatedao.getLicensePlateByUser(driver.getUserName());
		model.addAttribute("licensePlates", licensePlates);
		return "licenseplates";
	}
	
	@RequestMapping(value = "addLicensePlate.htm" , method = RequestMethod.GET)
	public String addLicensePlate(Model model,HttpServletRequest request) {
		model.addAttribute("licensePlate", new LicensePlate());
		return "addLicensePlate";
		}
	
	@RequestMapping(value = "/saveLicensePlate" , method = RequestMethod.POST)
	public String saveLicensePlate(@Validated @ModelAttribute("licensePlate") LicensePlate licensePlate, BindingResult result,Model model,HttpServletRequest request) {
		if(result.hasErrors()) {
			return "addLicensePlate";
		}
		HttpSession session = request.getSession();
		VDriver driver = (VDriver) session.getAttribute("person");
		licenseplatedao.addLicensePlate(licensePlate, driver);
		return "lpaddsuccess";
	}
	
	
	
	}
	

