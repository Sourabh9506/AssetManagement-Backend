package com.nissan.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="tblAssetDefinition")
public class AssetDefinition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetDefinitionId;
	
	@Column(nullable=false)
	private String assetDefinitionName;
	
	private int assetTypeId;
	
	@JoinColumn(name="assetTypeId",insertable=false,updatable=false)      //User.roleId=Role.roleId
	@ManyToOne  
	private AssetType assetType;
	
	
	private String assetDefinitionClass;

	@OneToMany(mappedBy = "assettype",cascade = CascadeType.ALL)
	private List<VendorCreation> vendors;
	

	public AssetDefinition() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getAssetDefinitionId() {
		return assetDefinitionId;
	}


	public void setAssetDefinitionId(int assetDefinitionId) {
		this.assetDefinitionId = assetDefinitionId;
	}


	public String getAssetDefinitionName() {
		return assetDefinitionName;
	}


	public void setAssetDefinitionName(String assetDefinitionName) {
		this.assetDefinitionName = assetDefinitionName;
	}


	public int getAssetTypeId() {
		return assetTypeId;
	}


	public void setAssetTypeId(int assetTypeId) {
		this.assetTypeId = assetTypeId;
	}


	public AssetType getAssetType() {
		return assetType;
	}


	public void setAssetType(AssetType assetType) {
		this.assetType = assetType;
	}


	public String getAssetDefinitionClass() {
		return assetDefinitionClass;
	}


	public void setAssetDefinitionClass(String assetDefinitionClass) {
		this.assetDefinitionClass = assetDefinitionClass;
	}


	public List<VendorCreation> getVendors() {
		return vendors;
	}


	public void setVendors(List<VendorCreation> vendors) {
		this.vendors = vendors;
	}


	@Override
	public String toString() {
		return "AssetDefinition [assetDefinitionId=" + assetDefinitionId + ", assetDefinitionName="
				+ assetDefinitionName + ", assetTypeId=" + assetTypeId + ", assetType=" + assetType
				+ ", assetDefinitionClass=" + assetDefinitionClass + ", vendors=" + vendors + "]";
	}


	public AssetDefinition(int assetDefinitionId, String assetDefinitionName, int assetTypeId, AssetType assetType,
			String assetDefinitionClass, List<VendorCreation> vendors) {
		super();
		this.assetDefinitionId = assetDefinitionId;
		this.assetDefinitionName = assetDefinitionName;
		this.assetTypeId = assetTypeId;
		this.assetType = assetType;
		this.assetDefinitionClass = assetDefinitionClass;
		this.vendors = vendors;
	}


	
}

