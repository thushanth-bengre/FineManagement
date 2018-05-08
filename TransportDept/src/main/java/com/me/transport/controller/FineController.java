package com.me.transport.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.LicensePlateDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;

@Controller
public class FineController {
	
	@Autowired
	private LicensePlateDao licenseplatedao;
	
	@RequestMapping(value = "/addfines" , method = RequestMethod.POST)
	public String addFine(@RequestParam("lp") String lp ,Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();		
		LicensePlate licensePlate = licenseplatedao.getLicensePlate(lp);
		if(licensePlate == null) {
			return "licenseplatenotfound";
		}else {
		model.addAttribute("licensePlate",licensePlate);
		session.setAttribute("lp", licensePlate);
		model.addAttribute("fine", new Fine());
		return "addFine";
		}
	}

}
