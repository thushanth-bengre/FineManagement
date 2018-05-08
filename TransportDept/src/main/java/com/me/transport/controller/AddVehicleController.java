package com.me.transport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.LoggingClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.LicensePlateDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.VDriver;
import com.me.transport.pojo.Vehicle;

@Controller
public class AddVehicleController {
	
	@Autowired
	private LicensePlateDao licenseplatedao;
	
	@RequestMapping(value = "register.htm" , method = RequestMethod.GET)
	public String searchReg(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		VDriver driver = (VDriver) session.getAttribute("person");
		List<LicensePlate> plates = licenseplatedao.getLicensePlateByUser(driver.getUserName());
		model.addAttribute("plates",plates);
		return "driversearchLicPlate";
	}
	
	@RequestMapping(value = "/addVehicle" , method = RequestMethod.POST)
	public String addFine(@RequestParam("LicensePlate") String lp ,Model model,HttpServletRequest request) {
		System.out.println(lp);
		HttpSession session = request.getSession();		
		LicensePlate licensePlate = licenseplatedao.getLicensePlate(lp);		
		model.addAttribute("licensePlate",licensePlate);
		session.setAttribute("vehicleLp", licensePlate);
		model.addAttribute("vehicle", new Vehicle());
		return "addVehicle";
		}
	}

