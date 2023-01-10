package com.nissan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.common.APIResponse;
import com.nissan.model.PurchaseOrderCreation;
import com.nissan.service.IPurchaseOrderCreationService;

@CrossOrigin
@RestController
@RequestMapping("/api/purchaseOrder")
public class PurchaseOrderController {
	
	@Autowired
	private IPurchaseOrderCreationService purchaseOrderService;
	
	private APIResponse apiResponse;
	
	@GetMapping
	public ResponseEntity<APIResponse> getAllPurchaseOrders(){
		apiResponse=purchaseOrderService.getAllPurchaseOrders();
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<APIResponse> findPurchaseOrderById(@PathVariable Integer id){
		apiResponse=purchaseOrderService.findPurchaseOrderById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	
	@PostMapping("{id}")
	public ResponseEntity<APIResponse> addPurchaseOrderDetails(@RequestBody PurchaseOrderCreation purchaseOrderCreation){
		apiResponse = purchaseOrderService.addPurchaseOrderDetails(purchaseOrderCreation);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<APIResponse> deletePurchaseOrderById(@PathVariable Integer id){
		apiResponse=purchaseOrderService.deletePurchaseOrderById(id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}
	@PutMapping("{id}")
	public ResponseEntity<APIResponse> updatePurchaseOrderById(@RequestBody PurchaseOrderCreation purchaseOrderCreation,@PathVariable Integer id){
		apiResponse=purchaseOrderService.updatePurchaseOrderById(purchaseOrderCreation,id);
		return ResponseEntity.status(apiResponse.getStatus()).body(apiResponse);
	}

}
