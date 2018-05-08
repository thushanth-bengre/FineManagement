package com.me.transport.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.me.transport.dao.IncidentDao;
import com.me.transport.pojo.Incident;

@Controller
public class AjaxController {
	
	@Autowired
	private IncidentDao incidentdao;
	
	@RequestMapping(value = "ajaxservice.htm", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxService(HttpServletRequest request)
	{
		int incidentId = Integer.parseInt(request.getParameter("indidentId"));
		Incident i = incidentdao.getIncident(incidentId);		
		return i.getSummary();
	}

}
