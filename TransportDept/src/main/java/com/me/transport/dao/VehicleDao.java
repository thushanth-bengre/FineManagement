package com.me.transport.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Vehicle;


public class VehicleDao extends DAO{
	
	public void addVehicle(Vehicle v, LicensePlate lp) {
		try {			
			begin();
			v.setLicensePlate(lp);
			lp.setVehicle(v);
			getSession().save(v);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
	}
	
	public Vehicle getVehicle(String vin) {
		Criteria c = getSession().createCriteria(Vehicle.class);
		c.add(Restrictions.eq("vin", vin).ignoreCase());
		c.setMaxResults(1);
		Vehicle v = (Vehicle) c.uniqueResult();
		return v;
	}
}
