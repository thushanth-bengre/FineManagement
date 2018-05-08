package com.me.transport.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="notification")
public class Notification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int notificationId;
	
	
	@Column(columnDefinition = "TEXT")
	private String description;
	
	@Enumerated(EnumType.STRING)
	private NotificationStatus status;
	
	@ManyToOne
	@JoinColumn(name="personId")
	private VDriver driver;

	public Notification() {
		
	}
	
	

	public int getNotificationId() {
		return notificationId;
	}



	public void setNotificationId(int notificationId) {
		this.notificationId = notificationId;
	}



	public NotificationStatus getStatus() {
		return status;
	}



	public void setStatus(NotificationStatus status) {
		this.status = status;
	}



	public VDriver getDriver() {
		return driver;
	}



	public void setDriver(VDriver driver) {
		this.driver = driver;
	}



	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
