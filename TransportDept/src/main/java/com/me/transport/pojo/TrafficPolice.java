package com.me.transport.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "trafficpolice")
public class TrafficPolice extends Person{
	
	
	@Column(name="badgeId", unique=true, nullable=false)
	private String badgeId;
	
	

	public TrafficPolice() {		
	}

	public String getBadgeId() {
		return badgeId;
	}

	public void setBadgeId(String badgeId) {
		this.badgeId = badgeId;
	}
	
	
}
