package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import com.nissan.model.AssetDefinition;
//import com.nissan.model.AssetType;
import com.nissan.model.VendorCreation;
import com.nissan.service.IVendorCreationService;

@CrossOrigin
@RestController
@RequestMapping("api/")
public class VendorController {
	
	//DI Injection
	@Autowired
	IVendorCreationService venService;
	
	//get all Vendors
	@GetMapping("vendors")
	public List<VendorCreation> getEmployees() {
		return venService.getAllVendors();
	}
	
	   //add a Vendor
		@PostMapping("/vendors")
		public VendorCreation addVendor(@RequestBody VendorCreation ivendorcreation) {
			return venService.addVendor(ivendorcreation);
		}
		
		// update Vendor
		@PutMapping("/vendors")
		public VendorCreation updateVendor(@RequestBody VendorCreation ivendorcreation) {
			return venService.updateVendor(ivendorcreation);
			
		}
		
		// delete a vendor
		@PutMapping("/delete/{vdId}")
		public void  deleteVendor(@PathVariable int vdId) {
			 venService.deleteVendor(vdId);
		}
		
		// search Vendor by phoneNumber
		@GetMapping("/search/{phoneNumber}")
		public VendorCreation searchByPhone(@PathVariable int phoneNumber) {
			return venService.searchByPhone(phoneNumber);
		}
		
		
	
	

}
