package com.me.transport.pojo;




import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="incident")
public class Incident {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int incidentId;
	
	private String location;
	
	@Column(columnDefinition = "TEXT")
	private String summary;	
	
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vin")
	private Vehicle vehicle;
	
	private String filePath;
	//private CommonsMultipartFile file;
	
	
	public Incident() {		
	}
	
	
	

	/*public CommonsMultipartFile getFile() {
		return file;
	}




	public void setFile(CommonsMultipartFile file) {
		this.file = file;
	}*/




	public Vehicle getVehicle() {
		return vehicle;
	}




	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}




	public int getIncidentId() {
		return incidentId;
	}


	public void setIncidentId(int incidentId) {
		this.incidentId = incidentId;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getSummary() {
		return summary;
	}


	public void setSummary(String summary) {
		this.summary = summary;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	
}
