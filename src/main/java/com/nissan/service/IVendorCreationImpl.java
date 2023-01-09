package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nissan.model.AssetType;

import com.nissan.model.VendorCreation;
import com.nissan.repo.IAssetDefinitionRepo;
import com.nissan.repo.IVendorCreationRepo;

@Service
public class IVendorCreationImpl implements IVendorCreationService {
	
	//DI injection
		@Autowired
		IVendorCreationRepo venRepo;
		
		@Autowired
		IAssetDefinitionRepo assetRepo;

	//get all vendors
	@Override
	public List<VendorCreation> getAllVendors() {
		return (List<VendorCreation>) venRepo.findAll();
	}

	//add a vendor
	@Transactional
	@Override
	public VendorCreation addVendor(VendorCreation ivendorcreation) {
		return venRepo.save(ivendorcreation);
	}

	//update a vendor
	@Transactional
	@Override
	public VendorCreation updateVendor(VendorCreation ivendorcreation) {
		 return venRepo.save(ivendorcreation);
	}
	
    //Delete a Vendor
	
		@Override
		public void deleteVendor(int id) {
			 venRepo.deleteById(id);
		}
	
	//Search by Vendor's Phone Number
	@Override
	public VendorCreation searchByPhone(int phoneNumber) {
		VendorCreation ivendorcreation = venRepo.searchByPhone(phoneNumber);
		
		if(phoneNumber == ivendorcreation.getPhoneNumber()) {
			return ivendorcreation;
		}
		return null;
	}
	

	

}
