package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetDefinition;
import com.nissan.model.AssetType;
import com.nissan.model.VendorCreation;
import com.nissan.repo.IVendorCreationRepo;



public interface IVendorCreationService {
	
	//get all vendors
		List<VendorCreation> getAllVendors();
		
		//add a vendor
		VendorCreation addVendor(VendorCreation ivendorcreation);
		
		//edit a vendor
		VendorCreation updateVendor(VendorCreation ivendorcreation);
		
		//delete a vendor
		void deleteVendor(int id);
		
		
		//search by phone
		VendorCreation searchByPhone(int phoneNumber);
		
//		//Show Asset
//		List<AssetType> getAllAssets();
		
		

}
