package com.me.transport.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "driver")
public class VDriver extends Person{
	
	@Column(name="licenseNo", unique=true, nullable =false)
	private String licenseNo;
	
	@OneToMany(mappedBy="driver", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Notification> notifications = new ArrayList<Notification>();
	
	
	@OneToMany(mappedBy="driver", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<LicensePlate> licensePlates = new ArrayList<LicensePlate>();
	
	@OneToMany(mappedBy="driver", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<RegistrationRequest> requests = new ArrayList<RegistrationRequest>();
	
	public List<LicensePlate> getLicensePlates() {
		return licensePlates;
	}
	


	public List<Notification> getNotifications() {
		return notifications;
	}



	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}



	public List<RegistrationRequest> getRequests() {
		return requests;
	}



	public void setRequests(List<RegistrationRequest> requests) {
		this.requests = requests;
	}



	public void setLicensePlates(List<LicensePlate> licensePlates) {
		this.licensePlates = licensePlates;
	}
	
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
}
