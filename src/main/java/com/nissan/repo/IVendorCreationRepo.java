package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;


import com.nissan.model.VendorCreation;

@Repository
public interface IVendorCreationRepo extends JpaRepositoryImplementation<VendorCreation, Integer> {
	
	//custom methods
	
	//Custom Retrieve phoneNumber
    @Query("from VendorCreation where phoneNumber=?1 and isActive=true")
    public VendorCreation searchByPhone(int phoneNumber);

}
