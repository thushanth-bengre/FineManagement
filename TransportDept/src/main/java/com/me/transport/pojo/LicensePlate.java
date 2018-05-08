package com.me.transport.pojo;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "licenseplate")
public class LicensePlate {

	@Id
	@Column(name = "lpNumber", updatable = false, nullable = false, unique = true)
	private String lpNumber;

	@OneToOne(mappedBy ="licensePlate")
	private Vehicle vehicle;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "personId")
	private VDriver driver;

	@OneToMany(mappedBy = "licensePlate", fetch = FetchType.LAZY)
	private List<Fine> fines = new ArrayList<Fine>();

	public LicensePlate() {
	}

	public VDriver getDriver() {
		return driver;
	}

	public void setDriver(VDriver driver) {
		this.driver = driver;
	}

	public List<Fine> getFines() {
		return fines;
	}

	public void setFines(List<Fine> fines) {
		this.fines = fines;
	}

	public String getLpNumber() {
		return lpNumber;
	}

	public void setLpNumber(String lpNumber) {
		this.lpNumber = lpNumber;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

}
