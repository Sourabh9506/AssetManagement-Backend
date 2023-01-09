package com.nissan.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "tblUserType")
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer ut_id;
	
	private String userType;

	public UserType(String userType) {
		this.userType = userType;
	}

	public Integer getUt_id() {
		return ut_id;
	}

	public void setUt_id(Integer ut_id) {
		this.ut_id = ut_id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserType [ut_id=" + ut_id + ", userType=" + userType + "]";
	}

	public UserType(Integer ut_id, String userType) {
		super();
		this.ut_id = ut_id;
		this.userType = userType;
	}

	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
