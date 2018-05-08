package com.me.transport.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.me.transport.dao.FinesDao;
import com.me.transport.dao.LicensePlateDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.VDriver;
import com.me.transport.pojo.Vehicle;

@Controller
public class PaymentController {
	
	@Autowired
	private LicensePlateDao licenseplatedao;
	
	@Autowired
	private FinesDao finesdao;
	
	@RequestMapping(value = "fines.htm" , method = RequestMethod.GET)
	public String searchReg(Model model,HttpServletRequest request) {
		HttpSession session = request.getSession();
		VDriver driver = (VDriver) session.getAttribute("person");
		List<LicensePlate> plates = licenseplatedao.getLicensePlateByUser(driver.getUserName());
		model.addAttribute("plates",plates);
		return "driversearchLicPlatefines";
	}
	
	@RequestMapping(value = "/viewFines" , method = RequestMethod.POST)
	public String fineList(@RequestParam("LicensePlate") String lp ,Model model,HttpServletRequest request) {		
		HttpSession session = request.getSession();		
		LicensePlate licensePlate = licenseplatedao.getLicensePlate(lp);		
		model.addAttribute("licensePlate",licensePlate);		
		List<Fine> fineList = finesdao.getFineBylpNum(licensePlate.getLpNumber());
		if(fineList == null) {
			return "noResultfines";
		}else {
		model.addAttribute("fineList",fineList);
		return "finesList";
		}		
	}
	
	@RequestMapping(value = "payment.htm" , method = RequestMethod.GET)
	public String pay(@RequestParam("id") int fineId ,Model model,HttpServletRequest request) {		
		HttpSession session = request.getSession();		
		Fine fine = finesdao.getFine(fineId);		
		model.addAttribute("fine",fine);
		session.setAttribute("payfine", fine);
		return "paymentpage";
		}
	
	@RequestMapping(value = "/paymentdone" , method = RequestMethod.POST)
	public String paymetComplete(HttpServletRequest request) {		
		HttpSession session = request.getSession();		
		Fine fine = (Fine) session.getAttribute("payfine");
		finesdao.setStatus(fine.getFineId());
		return "paymentSuccess";
		}	
	}


