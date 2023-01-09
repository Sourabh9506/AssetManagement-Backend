package com.nissan.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.model.AssetType;
import com.nissan.repo.IAssetTypeRepo;

@Service
public class IAssetTypeImpl implements IAssetTypeService {

	@Autowired
	IAssetTypeRepo assetTypeDAO;
	
	@Override
	public List<AssetType> getAllAssets() {
		// TODO Auto-generated method stub
		return assetTypeDAO.findAll();
	}

	@Override
	public AssetType searchAssetsById(Integer id) {
		AssetType searchAssetById=assetTypeDAO.findById(id).orElse(null);
		if (searchAssetById==null) {
			return null;
		}else {
			return searchAssetById;
		}
	}

	@Override
	public AssetType addAssets(AssetType assetType) {
		// TODO Auto-generated method stub
		return assetTypeDAO.save(assetType);
	}

	@Override
	public boolean deleteAssetById(Integer id) {
		AssetType findID=assetTypeDAO.findById(id).orElse(null);
		assetTypeDAO.deleteById(id);
		if (findID==null) {
			return false;
		}else {
			assetTypeDAO.deleteById(id);
			return true;
		}
	}

	@Override
	public AssetType updateAssetById(AssetType assetType) {
		// TODO Auto-generated method stub
		return assetTypeDAO.save(assetType);
	}

}
