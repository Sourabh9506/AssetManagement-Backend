package com.nissan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.AssetDefinition;
import com.nissan.model.AssetType;
import com.nissan.repo.IAssetDefinitionRepo;
import com.nissan.repo.IAssetTypeRepo;
import com.nissan.service.IAssetDefinitionService;
import com.nissan.service.IAssetTypeService;

@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/assets/types")
public class AssetsTypeController {
	@Autowired
	private IAssetTypeService assetTypeService;
	@Autowired
	private IAssetTypeRepo IAssetsTypeDAO;
	
	@GetMapping
	public ResponseEntity<?> getAllAssets(){
		List<AssetType> assetsList=assetTypeService.getAllAssets();
		
		if(assetsList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Database is empty!!!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(assetsList);
		}
	}
	@PostMapping
	public ResponseEntity<?> addAssets(@RequestBody AssetType Assets) {
		AssetType assests = assetTypeService.addAssets(Assets);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Assests added to the database successfully!!!");
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAssetById(@PathVariable Integer id) {
		AssetType assets=IAssetsTypeDAO.findById(id).orElse(null);
		assetTypeService.deleteAssetById(id);
		if (assets == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("AssetDefinition with " + id + " not found in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Assest Data has been successfully removed from the database!!!");
		}
	}
	@GetMapping("{id}")
	public ResponseEntity<?> searchAssetsById(@PathVariable Integer id) {
		AssetType findAssestsById = assetTypeService.searchAssetsById(id);

		if (findAssestsById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assests with id" + id + " is not available in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findAssestsById);
		}
	}
	@PutMapping("{id}")
	public ResponseEntity<?> updateAssetById(@PathVariable Integer id,@RequestBody AssetType assetType ) {
		AssetType assets=IAssetsTypeDAO.findById(id).orElse(null);
		
		if(assets==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assests with id" + id + " is not available in the database!!!");
		}else {
			assets.setAssetTypeName(assetType.getAssetTypeName());
			IAssetsTypeDAO.save(assets);
			return ResponseEntity.status(HttpStatus.OK).body("Assest Data has been successfully update the database!!!");
		}	
	}
}
