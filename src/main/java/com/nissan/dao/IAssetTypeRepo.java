package com.nissan.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nissan.model.AssetType;
@Repository
public interface IAssetTypeRepo extends JpaRepository<AssetType, Integer> {

}

