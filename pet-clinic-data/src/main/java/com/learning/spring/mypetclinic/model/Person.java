package com.learning.spring.mypetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

//	@mappedSuperClass means that Person entity will never be stored in the database
//	Only its sub classes will be added in the database

@MappedSuperclass
public class Person extends BaseEntity{
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="la st_name")
	private String lastName;
	
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