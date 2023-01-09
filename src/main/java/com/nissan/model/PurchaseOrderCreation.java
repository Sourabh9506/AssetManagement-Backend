package com.nissan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblPurchase")
public class PurchaseOrderCreation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int purchaseId;
	
	
	
	@Column(unique = true,nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int purchaseOrderNumber;
	
	
	

}
