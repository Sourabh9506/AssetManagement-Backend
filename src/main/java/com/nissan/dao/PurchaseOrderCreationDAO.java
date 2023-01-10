package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.PurchaseOrderCreation;

@Repository
public interface PurchaseOrderCreationDAO extends JpaRepository<PurchaseOrderCreation, Integer>{
	

}
