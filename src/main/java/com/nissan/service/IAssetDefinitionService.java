package com.nissan.service;

import java.util.List;

//import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.dao.IAssetDefinitionRepo;
import com.nissan.model.AssetDefinition;

@Service
public class IAssetDefinitionService implements IAssetDefinitionImpl {

	@Autowired
	IAssetDefinitionRepo assetDefinitionDAO;
	
	@Override
	public List<AssetDefinition> getAllAssets() {
		// TODO Auto-generated method stub
		return assetDefinitionDAO.findAll();
	}

//	@Transactional	
	@Override
	public AssetDefinition addAssets(AssetDefinition assetDefinition) {
		// TODO Auto-generated method stub
		return assetDefinitionDAO.save(assetDefinition);
	}
	//delete
	@Override
	public boolean deleteAssetById(Integer id) {
		AssetDefinition findID=assetDefinitionDAO.findById(id).orElse(null);
		assetDefinitionDAO.deleteById(id);
		if (findID==null) {
			return false;
		}else {
			assetDefinitionDAO.deleteById(id);
			return true;
		}
		
	}

	@Override
	public AssetDefinition updateAssetById(AssetDefinition assetDefinition) {

		return assetDefinitionDAO.save(assetDefinition);
	}


	@Override
	public AssetDefinition searchAssetsById(Integer id) {
		AssetDefinition searchAssetById=assetDefinitionDAO.findById(id).orElse(null);
		if (searchAssetById==null) {
			return null;
		}else {
			return searchAssetById;
		}
	}

	

}
