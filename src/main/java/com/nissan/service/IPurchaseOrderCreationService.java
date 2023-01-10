package com.nissan.service;

import com.nissan.common.APIResponse;
import com.nissan.model.PurchaseOrderCreation;

public interface IPurchaseOrderCreationService {
	APIResponse getAllPurchaseOrders();
	
	APIResponse findPurchaseOrderById(Integer id);
	
	APIResponse addPurchaseOrderDetails(PurchaseOrderCreation purchaseOrderCreation);
	
	APIResponse deletePurchaseOrderById(Integer id);
	
	APIResponse updatePurchaseOrderById(PurchaseOrderCreation purchaseOrderCreation,Integer id);
	

	
}
