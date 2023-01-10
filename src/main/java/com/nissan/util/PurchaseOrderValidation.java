package com.nissan.util;

import com.nissan.exception.PurchaseOrderCustomException;
import com.nissan.model.PurchaseOrderCreation;

public class PurchaseOrderValidation {
	
		
		public static void validatePurchaseDetails(PurchaseOrderCreation purchaseOrderCreation) throws PurchaseOrderCustomException{
			validateQuantity(purchaseOrderCreation .getQuantity());
		}
		
//		method to validate quantity
		public static void validateQuantity(Integer quantity) throws PurchaseOrderCustomException{
			if(quantity<=0 && quantity>1000) {
				throw new PurchaseOrderCustomException("Put a valid quantity");	
		}
	}
	

}
