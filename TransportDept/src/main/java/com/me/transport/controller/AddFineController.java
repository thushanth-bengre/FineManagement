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

import com.me.transport.dao.FinesDao;
import com.me.transport.dao.LicensePlateDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.validator.FinesValidator;

@Controller
public class AddFineController {
	
	@Autowired
	private FinesDao finesdao;
	
	@Autowired
	private LicensePlateDao licenseplatedao;
	
	@Autowired
	private FinesValidator finesvalidator;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(finesvalidator);
	}	
	
	
	@RequestMapping(value = "searchLP.htm" , method = RequestMethod.GET)
	public String searchReg(Model model) {			
		return "tpsearchLicPlate";
	}
	
	@RequestMapping(value = "/savefine" , method = RequestMethod.POST)
	public String saveFine(@Validated @ModelAttribute("fine") Fine fine, BindingResult result,Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(result.hasErrors()) {
			return "addFine";
		}
		System.out.println("Reaching here");
		LicensePlate lp = (LicensePlate) session.getAttribute("lp");
		System.out.println("Reached here also");
		finesdao.addfine(fine, lp);
		return "fineaddedsuccess";
	}
	

}
