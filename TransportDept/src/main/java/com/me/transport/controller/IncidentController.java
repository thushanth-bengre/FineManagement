package com.me.transport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.VehicleDao;
import com.me.transport.pojo.Incident;
import com.me.transport.pojo.Vehicle;

@Controller
public class IncidentController {
	
	@Autowired
	private VehicleDao vehicledao;
	
	@RequestMapping(value = "/addIncident" , method = RequestMethod.POST)
	public String addFine(@RequestParam("vin") String vin ,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Vehicle vehicle = vehicledao.getVehicle(vin);
		if(vehicle == null) {
			return "vehiclenotfound";
		}else{
		model.addAttribute("vehicle",vehicle);
		session.setAttribute("vehicle", vehicle);
		model.addAttribute("incident", new Incident());
		return "addIncident";
		}
	}
}
