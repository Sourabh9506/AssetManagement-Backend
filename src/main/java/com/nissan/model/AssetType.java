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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="tblAssetType")
public class AssetType {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int assetTypeId;
	
	@Column(nullable=false,unique=true)
	private String assetTypeName;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="assetType",cascade=CascadeType.ALL)
	private List<AssetDefinition> assets;


	public AssetType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AssetType(int assetTypeId, String assetTypeName, List<AssetDefinition> assets) {
		super();
		this.assetTypeId = assetTypeId;
		this.assetTypeName = assetTypeName;
		this.assets = assets;
	}


	@Override
	public String toString() {
		return "AssetType [assetTypeId=" + assetTypeId + ", assetTypeName=" + assetTypeName + ", assets=" + assets
				+ "]";
	}


	public int getAssetTypeId() {
		return assetTypeId;
	}


	public void setAssetTypeId(int assetTypeId) {
		this.assetTypeId = assetTypeId;
	}


	public String getAssetTypeName() {
		return assetTypeName;
	}


	public void setAssetTypeName(String assetTypeName) {
		this.assetTypeName = assetTypeName;
	}


	public List<AssetDefinition> getAssets() {
		return assets;
	}


	public void setAssets(List<AssetDefinition> assets) {
		this.assets = assets;
	}


	
	
}
