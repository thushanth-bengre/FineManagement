package com.me.transport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.me.transport.dao.LicensePlateDao;
import com.me.transport.dao.VehicleDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Vehicle;
import com.me.transport.validator.VehicleValidator;

@Controller
public class VehicleController {
	
	@Autowired
	private LicensePlateDao licenseplatedao;
	
	@Autowired
	private VehicleDao vehicledao;
	
	@Autowired
	private VehicleValidator vehiclevalidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(vehiclevalidator);
	}
	
	@RequestMapping(value = "/saveVehicle" , method = RequestMethod.POST)
	public String saveFine(@Validated @ModelAttribute("vehicle") Vehicle vehicle, BindingResult result,Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(result.hasErrors()) {
			return "addVehicle";
		}		
		LicensePlate lp = (LicensePlate) session.getAttribute("vehicleLp");	
		vehicledao.addVehicle(vehicle, lp);
		return "vehicleaddedsuccess";
	}
	
}
