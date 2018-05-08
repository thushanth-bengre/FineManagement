package com.me.transport.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "registrationrequest")
public class RegistrationRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int requestId;

	@Enumerated(EnumType.STRING)
	private RegistrationStatus Status;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "vin")
	private Vehicle vehicle;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "lpNumber")
	private LicensePlate lp;

	@ManyToOne
	@JoinColumn(name = "personId")
	private VDriver driver;

	public RegistrationRequest() {

	}

	public VDriver getDriver() {
		return driver;
	}

	public void setDriver(VDriver driver) {
		this.driver = driver;
	}

	public RegistrationStatus getStatus() {
		return Status;
	}

	public void setStatus(RegistrationStatus status) {
		Status = status;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public LicensePlate getLp() {
		return lp;
	}

	public void setLp(LicensePlate lp) {
		this.lp = lp;
	}

}
