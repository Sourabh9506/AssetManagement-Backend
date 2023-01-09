package com.nissan.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tblUserType")
public class UserType {
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userTypeNo;
	private String userTypeName;
	
	@JsonIgnore
    @OneToMany(mappedBy="userType",cascade=CascadeType.ALL) // one role many users, cascade - when parent is deleted, child is also deleted
    private List<UserRegistration> userRegistration;

	public UserType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserType(int userTypeNo, String userTypeName, List<UserRegistration> userRegistration) {
		super();
		this.userTypeNo = userTypeNo;
		this.userTypeName = userTypeName;
		this.userRegistration = userRegistration;
	}

	public int getUserTypeNo() {
		return userTypeNo;
	}

	public void setUserTypeNo(int userTypeNo) {
		this.userTypeNo = userTypeNo;
	}

	public String getUserTypeName() {
		return userTypeName;
	}

	public void setUserTypeName(String userTypeName) {
		this.userTypeName = userTypeName;
	}

	public List<UserRegistration> getUserRegistration() {
		return userRegistration;
	}

	public void setUserRegistration(List<UserRegistration> userRegistration) {
		this.userRegistration = userRegistration;
	}

	@Override
	public String toString() {
		return "UserType [userTypeNo=" + userTypeNo + ", userTypeName=" + userTypeName + ", userRegistration="
				+ userRegistration + "]";
	}
	
	
	
	
	

}
