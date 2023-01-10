package com.nissan.service;

import static com.nissan.util.PurchaseOrderValidation.validatePurchaseDetails;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.nissan.common.APIResponse;
import com.nissan.dao.PurchaseOrderCreationDAO;
import com.nissan.exception.PurchaseOrderCustomException;
import com.nissan.model.PurchaseOrderCreation;

@Service
public class PurchaseOrderCreationServiceImpl implements IPurchaseOrderCreationService{
	@Autowired
	private PurchaseOrderCreationDAO purchaseOrderCreationDAO;

	@Override
	public APIResponse getAllPurchaseOrders() {
		APIResponse apiResponse=new APIResponse();
		List<PurchaseOrderCreation> purchaseOrderList=purchaseOrderCreationDAO.findAll();
		
		if(purchaseOrderList.isEmpty()) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData(purchaseOrderList);
		}else {
			apiResponse.setData(purchaseOrderList);
		}
		
		return apiResponse;
	}

	@Override
	public APIResponse findPurchaseOrderById(Integer id) {
		APIResponse apiResponse=new APIResponse();
		PurchaseOrderCreation purchaseOrderCreation=purchaseOrderCreationDAO.findById(id).orElse(null);
		
		if(purchaseOrderCreation==null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setError("User not found!!");
		}else {
			Map<String,Object> data=new HashMap<>();
			data.put("Id",purchaseOrderCreation.getPurchaseId());
			data.put("Name",purchaseOrderCreation.getVendorName());
			apiResponse.setData(data);
		}

		return apiResponse;
	}

	@Override
	public APIResponse addPurchaseOrderDetails(PurchaseOrderCreation purchaseOrderCreation) {
		
		APIResponse apiResponse=new APIResponse();
		try {
			validatePurchaseDetails(purchaseOrderCreation);
		}
			catch(PurchaseOrderCustomException e) {
			System.out.println("Put valid details");
		}
		PurchaseOrderCreation newOrder=new PurchaseOrderCreation(purchaseOrderCreation.getPurchaseId());
		apiResponse.setData("Purchase Order details saved successfully!!!");
		return apiResponse;
	}

	@Override
	public APIResponse deletePurchaseOrderById(Integer id) {
	
		APIResponse apiResponse=new APIResponse();
		
		PurchaseOrderCreation deleteOrder=purchaseOrderCreationDAO.findById(id).orElse(null);

		if(deleteOrder==null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("User not found");
		}
		return null;
	}

	@Override
	public APIResponse updatePurchaseOrderById(PurchaseOrderCreation purchaseOrderCreation, Integer id) {
		
		APIResponse apiResponse=new APIResponse();
		
		PurchaseOrderCreation updateOrder=purchaseOrderCreationDAO.findById(id).orElse(null);
		
		if(updateOrder==null) {
			apiResponse.setStatus(HttpStatus.NOT_FOUND.value());
			apiResponse.setData("User NOT Found");
		}else {
			if(purchaseOrderCreation.getPurchaseId() > 0) {
				updateOrder.setPurchaseId(purchaseOrderCreation.getPurchaseId());;
			}
			if(purchaseOrderCreation.getVendorName()!=null && !purchaseOrderCreation.getVendorName().isEmpty()) {
				updateOrder.setVendorName(purchaseOrderCreation.getVendorName());
			}
			purchaseOrderCreationDAO.save(updateOrder);
			apiResponse.setData("User with id "+updateOrder.getPurchaseId()+"and name"+purchaseOrderCreation.getVendorName());
		}
		return apiResponse;
	}
	
	

}
