package com.me.transport.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;

import com.me.transport.pojo.Fine;
import com.me.transport.pojo.FineStatus;
import com.me.transport.pojo.LicensePlate;
import com.me.transport.pojo.Role;

public class FinesDao extends DAO{	
	
	
	
	public void addfine(Fine f,LicensePlate lp) {
		try {			
			begin();						
			f.setStatus(FineStatus.NEW);
			f.setLicensePlate(lp);
			lp.getFines().add(f);
			getSession().save(f);		
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
	}
	
	public Fine getFine(int fineId) {
		Criteria c = getSession().createCriteria(Fine.class);
		c.add(Restrictions.eq("fineId", fineId));
		c.setMaxResults(1);
		Fine f = (Fine) c.uniqueResult();
		return f;
	}
	
	public List<Fine> getFineBylpNum(String lpNumber){
		Criteria c = getSession().createCriteria(Fine.class).createAlias("licensePlate", "lp");
		c.add(Restrictions.eq("lp.lpNumber", lpNumber));
		List<Fine> list = c.list();
		if(list.isEmpty()) {
			return null;
		}else {
			return list;
		}
	}
	
	public void setStatus(int fineId) {
		begin();
		Criteria c = getSession().createCriteria(Fine.class);
		c.add(Restrictions.eq("fineId", fineId));
		c.setMaxResults(1);
		Fine f = (Fine) c.uniqueResult();
		f.setStatus(FineStatus.PAID);
		getSession().update(f);
		commit();
	}
}
