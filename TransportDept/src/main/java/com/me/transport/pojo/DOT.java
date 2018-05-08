package com.me.transport.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "dot")
public class DOT extends Person {

	@Column(name = "licenseNo", unique = true)
	private String employeeId;

	public DOT() {

	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

}
