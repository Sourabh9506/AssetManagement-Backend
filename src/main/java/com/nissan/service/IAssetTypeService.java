package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetType;


public interface IAssetTypeService {

	//list of all asset
		List<AssetType> getAllAssets();
		
		//Find By Asset Id
		AssetType searchAssetsById(Integer id);
		
		//Add new Asset Data
		AssetType addAssets(AssetType assetType);	
		
		//Delete by Id
		boolean deleteAssetById(Integer id);
		
		//Update by Id
		AssetType updateAssetById(AssetType assetType);
		
}
