package com.nissan.dto;

public class UserDTO {
	
	private String username;
	private String password;
	private Integer ut_id;


	private String firstName;

	private String lastName;

	private Integer age;

	private String gender;

	private String address;

	private Long phoneNumber;
	
	

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UserDTO(String username, String password, Integer ut_id, String firstName, String lastName,
			Integer age, String gender, String address, Long phoneNumber) {
		super();
		this.username = username;
		this.password = password;
		this.ut_id = ut_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPasswaord(String password) {
		this.password = password;
	}



	public Integer getUt_id() {
		return ut_id;
	}



	public void setUt_id(Integer ut_id) {
		this.ut_id = ut_id;
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



	public Integer getAge() {
		return age;
	}



	public void setAge(Integer age) {
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



	public Long getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	//getters and setters
	



	
	
	
}
