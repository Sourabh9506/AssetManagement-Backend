package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tblUserRegistration")
public class UserRegistration {
	
	//fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int uId;
	
	@Column(nullable=false,unique=true)
	private String userName;
	
	@Column(nullable=false)
	private String password;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String address;
	private int PhoneNumber;
	
	@JoinColumn(name="userTypeNo")
	@ManyToOne
	private UserType userType;

	public UserRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegistration(int uId, String userName, String password, String firstName, String lastName, int age,
			String gender, String address, int phoneNumber, UserType userType) {
		super();
		this.uId = uId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		PhoneNumber = phoneNumber;
		this.userType = userType;
	}

	public int getuId() {
		return uId;
	}

	public void setuId(int uId) {
		this.uId = uId;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@Override
	public String toString() {
		return "UserRegistration [uId=" + uId + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", PhoneNumber=" + PhoneNumber + ", userType=" + userType + "]";
	}
	
	
}
