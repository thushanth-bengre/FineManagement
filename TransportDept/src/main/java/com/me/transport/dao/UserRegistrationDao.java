package com.me.transport.dao;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.me.transport.pojo.DOT;
import com.me.transport.pojo.Person;
import com.me.transport.pojo.Role;
import com.me.transport.pojo.TrafficPolice;
import com.me.transport.pojo.VDriver;



public class UserRegistrationDao extends DAO{
	
	BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder(11);
	
	public void addUser(VDriver p) {
		try {			
			begin();
			p.setRole(Role.USER);
			p.setPassword(bcpe.encode(p.getPassword()));
			getSession().save(p);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		
	}
	
	public void addTp(TrafficPolice p) {
		try {			
			begin();
			p.setRole(Role.TP);
			p.setPassword(bcpe.encode(p.getPassword()));
			getSession().save(p);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		
	}
	
	public void addDot(DOT p) {
		try {			
			begin();
			p.setRole(Role.DOT);
			p.setPassword(bcpe.encode(p.getPassword()));
			getSession().save(p);
			commit();
		} catch (HibernateException e) {
			// TODO: handle exception
			rollback();
		}
		
	}
	
	public Person getUser(String username) {
		Criteria c= getSession().createCriteria(Person.class);
		c.add(Restrictions.eq("userName", username));
		Person p = (Person) c.uniqueResult();		
		return p;
		
	}
}
