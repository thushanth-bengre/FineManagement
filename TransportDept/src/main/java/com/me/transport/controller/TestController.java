/*package com.me.transport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.me.transport.dao.LicensePlateDao;
import com.me.transport.dao.UserRegistrationDao;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Person;
import com.me.transport.pojo.VDriver;

@Controller
public class TestController {
	
	@Autowired
	private UserRegistrationDao userRegistrationdao;
	
	@RequestMapping(value = "/addLicensePlate" , method = RequestMethod.GET)
	public String addLicensePlate() {
		LicensePlateDao lpdao = new LicensePlateDao();
		lpdao.addLicensePlate();
		return "home";
	}
	
	
	@RequestMapping(value = "/registervehicle" , method = RequestMethod.GET)
	public String retrive() {
		VDriver p = (VDriver) userRegistrationdao.getUser("thushu");
		System.out.println(p.getLicenseNo());
		for(LicensePlate lp : p.getLicensePlates()) {
			System.out.println(lp.getLpNumber());
			System.out.println(lp.getDriver().getLicenseNo());
			for(Fine f : lp.getFines()) {
				System.out.println(f.getAppeal().getCourt());
				System.out.println(f.getLicensePlate().getLpNumber());
			}
		}
		return "home";
	}
}
*/