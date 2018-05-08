package com.me.transport.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.me.transport.pojo.Person;

@Repository
public class LoginDao extends DAO{

	public Person validateUser(String username, String password) {
		Criteria c = getSession().createCriteria(Person.class);
		c.add(Restrictions.eq("userName", username));
		c.add(Restrictions.eq("password", password));
		Person p = (Person) c.uniqueResult();
		if(p == null) {
		return null;
		}else {
			return p;
		}
	}
	
	public Person getUser(String username) {
		System.out.println(username);
		Criteria c = getSession().createCriteria(Person.class);
		c.add(Restrictions.eq("userName", username));
		Person p = (Person) c.uniqueResult();
		System.out.println(p.getFirstName());
		return p;
	}
}
