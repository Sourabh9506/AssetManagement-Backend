package com.nissan.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tblPurchase")
public class PurchaseOrderCreation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseId;
	
	
	
	@Column(unique = true,nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer purchaseOrderNumber;
	
	private Integer quantity;
	
	private Integer adId;
	
	@ManyToOne
	@JoinColumn(name="adId", insertable=false, updatable=false)
	private AssetDefinition assetDefination;
	
	private Integer atId;
	
	@ManyToOne
	@JoinColumn(name="atId",insertable=false,updatable=false)
	private PurchaseOrderCreation purchaseOrderCreation;
	
	private Integer vdId;
	
	@ManyToOne
	@JoinColumn(name="vdId",insertable=false,updatable=false)
	private VendorCreation vendorCreation;
	
	
	
	private String vendorName;
	
	private Date orderDate;
	
	private Date deliveryDate;
	
	private String status;

//	default constructor
	public PurchaseOrderCreation() {
		super();
		// TODO Auto-generated constructor stub
	}
	

public PurchaseOrderCreation(int purchaseId) {
		super();
		this.purchaseId = purchaseId;
	}


//	parameterised constructor
//public PurchaseOrderCreation(int purchaseId, int purchaseOrderNumber, int quantity, 		PurchaseOrderCreation purchaseOrderCreation,  String vendorName, Date orderDate,
//		Date deliveryDate, String status) {

public PurchaseOrderCreation( int purchaseOrderNumber, int quantity, 		PurchaseOrderCreation purchaseOrderCreation,  String vendorName, Date orderDate,
		Date deliveryDate, String status) {
	super();
//	this.purchaseId = purchaseId;
	this.purchaseOrderNumber = purchaseOrderNumber;
	this.quantity = quantity;
//	this.assetDefination = assetDefination;
	this.purchaseOrderCreation = purchaseOrderCreation;
//	this.vendorCreation = vendorCreation;
	this.vendorName = vendorName;
	this.orderDate = orderDate;
	this.deliveryDate = deliveryDate;
	this.status = status;
}

//getters and setters
public int getPurchaseId() {
	return purchaseId;
}

public void setPurchaseId(int purchaseId) {
	this.purchaseId = purchaseId;
}

public int getPurchaseOrderNumber() {
	return purchaseOrderNumber;
}

public void setPurchaseOrderNumber(int purchaseOrderNumber) {
	this.purchaseOrderNumber = purchaseOrderNumber;
}

public int getQuantity() {
	return quantity;
}

public void setQuantity(int quantity) {
	this.quantity = quantity;
}

//public AssetDefinition getAssetDefination() {
//	return assetDefination;
//}

//public void setAssetDefination(AssetDefinition assetDefination) {
//	this.assetDefination = assetDefination;
//}

public PurchaseOrderCreation getPurchaseOrderCreation() {
	return purchaseOrderCreation;
}

public void setPurchaseOrderCreation(PurchaseOrderCreation purchaseOrderCreation) {
	this.purchaseOrderCreation = purchaseOrderCreation;
}

//public VendorCreation getVendorCreation() {
//	return vendorCreation;
//}

//public void setVendorCreation(VendorCreation vendorCreation) {
//	this.vendorCreation = vendorCreation;
//}

public String getVendorName() {
	return vendorName;
}

public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}

public Date getOrderDate() {
	return orderDate;
}

public void setOrderDate(Date orderDate) {
	this.orderDate = orderDate;
}

public Date getDeliveryDate() {
	return deliveryDate;
}

public void setDeliveryDate(Date deliveryDate) {
	this.deliveryDate = deliveryDate;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

//toString
@Override
public String toString() {
	return "PurchaseOrderCreation [purchaseId=" + purchaseId + ", purchaseOrderNumber=" + purchaseOrderNumber
			+ ", quantity=" + quantity + ", assetDefination="  + ", purchaseOrderCreation="
			+ purchaseOrderCreation + ", vendorCreation="  + ", vendorName=" + vendorName
			+ ", orderDate=" + orderDate + ", deliveryDate=" + deliveryDate + ", status=" + status + "]";
}

}
