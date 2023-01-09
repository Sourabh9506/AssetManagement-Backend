package com.nissan.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tblVendor")
public class VendorCreation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vdId;
	
	private String vdName;
	private String vdType;
	private int atId ;
	private LocalDate vdFrom;
	private LocalDate vdTo;
	private String vdAddr;
	private int phoneNumber;
	private LocalDate vdCreationDate;
	private boolean isActive;
	
	
	
	@JoinColumn(name="atId" ,insertable= false,  updatable = false)
	@ManyToOne
	
	private  AssetType assettype ;



	//default constructor
	public VendorCreation() {
		super();
		// TODO Auto-generated constructor stub
	}



	//Parameterized Constructor
	public VendorCreation(int vdId, String vdName, String vdType, int atId, LocalDate vdFrom, LocalDate vdTo,
			String vdAddr, int phoneNumber, LocalDate vdCreationDate, boolean isActive, AssetType assettype) {
		super();
		this.vdId = vdId;
		this.vdName = vdName;
		this.vdType = vdType;
		this.atId = atId;
		this.vdFrom = vdFrom;
		this.vdTo = vdTo;
		this.vdAddr = vdAddr;
		this.phoneNumber = phoneNumber;
		this.vdCreationDate = vdCreationDate;
		this.isActive = isActive;
		this.assettype = assettype;
	}


	//Getters and Setters

	public int getVdId() {
		return vdId;
	}



	public void setVdId(int vdId) {
		this.vdId = vdId;
	}



	public String getVdName() {
		return vdName;
	}



	public void setVdName(String vdName) {
		this.vdName = vdName;
	}



	public String getVdType() {
		return vdType;
	}



	public void setVdType(String vdType) {
		this.vdType = vdType;
	}



	public int getAtId() {
		return atId;
	}



	public void setAtId(int atId) {
		this.atId = atId;
	}



	public LocalDate getVdFrom() {
		return vdFrom;
	}



	public void setVdFrom(LocalDate vdFrom) {
		this.vdFrom = vdFrom;
	}



	public LocalDate getVdTo() {
		return vdTo;
	}



	public void setVdTo(LocalDate vdTo) {
		this.vdTo = vdTo;
	}



	public String getVdAddr() {
		return vdAddr;
	}



	public void setVdAddr(String vdAddr) {
		this.vdAddr = vdAddr;
	}



	public int getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public LocalDate getVdCreationDate() {
		return vdCreationDate;
	}



	public void setVdCreationDate(LocalDate vdCreationDate) {
		this.vdCreationDate = vdCreationDate;
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public AssetType getAssettype() {
		return assettype;
	}



	public void setAssettype(AssetType assettype) {
		this.assettype = assettype;
	}



	
	

}