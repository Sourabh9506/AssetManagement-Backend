package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.Login;

@Repository
public interface LoginDao extends JpaRepository<Login, Integer> {

	Login findByUsernameAndPassword(String userName, String password);
	
}
