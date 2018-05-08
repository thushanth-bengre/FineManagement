package com.me.transport.dao;

import java.util.ArrayList;
import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.transport.pojo.Fine;
import com.me.transport.pojo.FineStatus;
import com.me.transport.pojo.Incident;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Vehicle;

public class IncidentDao extends DAO{
	
	List<Incident> incidentList = new ArrayList<Incident>();
	
	public List<Incident> getVehicleHistory(String vim){
		Criteria c = getSession().createCriteria(Incident.class).createAlias("vehicle", "v");
		c.add(Restrictions.eq("v.vin", vim));
		List<Incident> list= c.list();
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
	}
	
	public void addIncident(Incident i, Vehicle v) {
		try {			
			begin();
			i.setVehicle(v);
			incidentList.add(i);
			v.setVehicleHistory(incidentList);
			getSession().save(i);		
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
	}
	
	public Incident getIncident(int id) {
		Criteria c = getSession().createCriteria(Incident.class);
		c.add(Restrictions.eq("incidentId", id));
		c.setMaxResults(1);
		return (Incident) c.uniqueResult();
	}
	

}
