package com.me.transport.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.transport.pojo.Appeal;
import com.me.transport.pojo.AppealStatus;
import com.me.transport.pojo.Fine;
import com.me.transport.pojo.FineStatus;
import com.me.transport.pojo.Incident;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Person;
import com.me.transport.pojo.Role;
import com.me.transport.pojo.VDriver;
import com.me.transport.pojo.Vehicle;

public class LicensePlateDao extends DAO{
	
	/*public void addLicensePlate() {
		try {			
			begin();
			Date d = new Date();
			LicensePlate lp = new LicensePlate();
			UserRegistrationDao ur = new UserRegistrationDao();			
			Fine f = new Fine();
			Appeal a = new Appeal();
			
			Vehicle v = new Vehicle();
			v.setManufacturer("BMW");
			v.setModel("I3");
			v.setVin("12345");
			v.setYearManufactured(2018);
			
			Incident i = new Incident();
			i.setFilePath("jkvdkw");
			i.setLocation("Boston");
			i.setSummary("This was an acciddent");			
			i.setDate(d);			
			List<Incident> history = new ArrayList<Incident>();
			history.add(i);
			v.setVehicleHistory(history);			
			a.setCourt("abc");
			a.setFilePath("xyz");						
			a.setHearingDate(d);
			a.setStatus(AppealStatus.New);
			a.setSummary("xyzzzz");			
			f.setAmount(200.0);
			f.setFilePath("kjsdf");
			f.setStatus(FineStatus.NEW);
			f.setSummary("xsbjkds");
			f.setAppeal(a);
			a.setFine(f);
			lp.setLpNumber("kjdfks");			
			List<Fine> list = new ArrayList<Fine>();
			list.add(f);
			lp.setFines(list);
			lp.setDriver((VDriver)ur.getUser("thushu"));
			f.setLicensePlate(lp);
			List<LicensePlate> lps = new ArrayList<LicensePlate>();
			lps.add(lp);
			v.setLicensePlate(lp);
			lp.setVehicle(v);
			i.setVehicle(v);
			VDriver vd = (VDriver)ur.getUser("thushu");
			vd.setLicensePlates(lps);
			getSession().save(lp);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		
	}*/
	
	public void addLicensePlate(LicensePlate lp, VDriver driver) {
		try {			
			begin();
			lp.setDriver(driver);			
			getSession().save(lp);		
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
	}
	
	public LicensePlate getLicensePlate(String lpNumber) {
		Criteria c = getSession().createCriteria(LicensePlate.class);
		c.add(Restrictions.eq("lpNumber", lpNumber).ignoreCase());
		c.setMaxResults(1);
		LicensePlate lp = (LicensePlate) c.uniqueResult();
		return lp;
	}
	
	public List<LicensePlate> getLicensePlateByUser(String username){
		Criteria c = getSession().createCriteria(LicensePlate.class).createAlias("driver", "d");
		c.add(Restrictions.eq("d.userName", username));
		List<LicensePlate> list= c.list();
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
	}
}
