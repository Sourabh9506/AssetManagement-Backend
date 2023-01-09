package com.nissan.service;

import java.util.List;

import com.nissan.model.AssetDefinition;

public interface IAssetDefinitionImpl {

	//list of all asset
	List<AssetDefinition> getAllAssets();
	
	//Find By Asset Id
	AssetDefinition searchAssetsById(Integer id);
	
	//Add new Asset Data
	AssetDefinition addAssets(AssetDefinition assetDefinition);
	
	
	//Delete by Id
	boolean deleteAssetById(Integer id);
	
	//Update by Id
	AssetDefinition updateAssetById(AssetDefinition assetDefinition);
	
}
