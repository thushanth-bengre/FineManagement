package com.me.transport.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.IncidentDao;
import com.me.transport.pojo.Incident;

@Controller
public class VehicleHistoryController {
	
	@Autowired
	private IncidentDao incidentdao;
	
	@RequestMapping(value = "/vehiclehistory" , method = RequestMethod.POST)
	public String getHistory(@RequestParam("vin") String vin ,Model model) {
		System.out.println(vin);
		List<Incident> history = incidentdao.getVehicleHistory(vin);
		if(history == null) {
			return "noResult";
		}else {
		model.addAttribute("history",history);
		return "vehicleHistory";
		}
	}
}
