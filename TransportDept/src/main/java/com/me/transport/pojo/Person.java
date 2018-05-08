package com.me.transport.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "person")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

	@Id
	@TableGenerator(name="PERSON_GEN", table = "ID_GENERATOR", pkColumnName="name", valueColumnName ="sequence",
	allocationSize =1)
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "PERSON_GEN")
	private int personId;

	private String firstName;
	private String lastName;

	@Column(name = "userName", unique = true)
	private String userName;
	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	public Person() {
	}

	public Person(Person user) {
		this.personId = user.getPersonId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.role = user.getRole();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
