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
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.IncidentDao;
import com.me.transport.dao.VehicleDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.Incident;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Vehicle;
import com.me.transport.validator.IncidentValidator;

@Controller
public class AddIncidentController {
	
	@Autowired
	private VehicleDao vehicledao;
	
	@Autowired
	private IncidentDao incidentdao;
	
	@Autowired
	private IncidentValidator incidentValidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(incidentValidator);
	}
	
	@RequestMapping(value = "searchVehicle.htm" , method = RequestMethod.GET)
	public String searchReg(Model model) {			
		return "tpsearchVehicle";
	}
	
	
	
	@RequestMapping(value = "/saveincident" , method = RequestMethod.POST)
	public String saveFine(@Validated @ModelAttribute("incident") Incident incident, BindingResult result,Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(result.hasErrors()) {
			return "addIncident";
		}
		
		Vehicle v = (Vehicle) session.getAttribute("vehicle");
		incidentdao.addIncident(incident, v);
		return "incidetaddedsuccess";
	}
}
