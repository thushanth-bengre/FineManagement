package com.me.transport.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="vehicle")
public class Vehicle {	
	
	@Id
	@Column(name = "vin", updatable = false, nullable = false, unique= true)
	private String vin;
	private String model;
	private int yearManufactured;
	private String manufacturer;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lpNumber")	
	private LicensePlate licensePlate;
	
	@OneToMany(mappedBy="vehicle", fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private List<Incident> vehicleHistory = new ArrayList<Incident>();
	
	public Vehicle() {		
	}
	
	
	
	public List<Incident> getVehicleHistory() {
		return vehicleHistory;
	}



	public void setVehicleHistory(List<Incident> vehicleHistory) {
		this.vehicleHistory = vehicleHistory;
	}



	public LicensePlate getLicensePlate() {
		return licensePlate;
	}



	public void setLicensePlate(LicensePlate licensePlate) {
		this.licensePlate = licensePlate;
	}



	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYearManufactured() {
		return yearManufactured;
	}
	public void setYearManufactured(int yearManufactured) {
		this.yearManufactured = yearManufactured;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
}