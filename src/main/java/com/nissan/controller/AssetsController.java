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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nissan.model.AssetDefinition;
import com.nissan.repo.IAssetDefinitionRepo;
import com.nissan.service.IAssetDefinitionService;
@CrossOrigin(origins = "*") 
@RestController
@RequestMapping("/api/assets")
public class AssetsController {

	@Autowired
	private IAssetDefinitionService assetDefinitionService;
	@Autowired
	private IAssetDefinitionRepo IAssetsDefinitonDAO;
	
	@GetMapping
	public ResponseEntity<?> getAllAssets(){
		List<AssetDefinition> assetsList=assetDefinitionService.getAllAssets();
		
		if(assetsList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Database is empty!!!");
		}else {
			return ResponseEntity.status(HttpStatus.OK).body(assetsList);
		}
	}
	@PostMapping
	public ResponseEntity<?> addAssets(@RequestBody AssetDefinition Assets) {
		AssetDefinition assests = assetDefinitionService.addAssets(Assets);
		return ResponseEntity.status(HttpStatus.OK)
				.body("Assests added to the database successfully!!!");
	}
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteAssetById(@PathVariable Integer id) {
		AssetDefinition assets=IAssetsDefinitonDAO.findById(id).orElse(null);
		assetDefinitionService.deleteAssetById(id);
		if (assets == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("AssetDefinition with " + id + " not found in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Assest Data has been successfully removed from the database!!!");
		}
		
	}

	

	@GetMapping("{id}")
	public ResponseEntity<?> searchAssetsById(@PathVariable Integer id) {
		AssetDefinition findAssestsById = assetDefinitionService.searchAssetsById(id);

		if (findAssestsById == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assests with id" + id + " is not available in the database!!!");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(findAssestsById);
		}
	}

	@PutMapping("{id}")
	public ResponseEntity<?> updateAssetById(@PathVariable Integer id,@RequestBody AssetDefinition assetDefinition ) {
//		AssetDefinition assetsUpdate = assetDefinitionService.updateAssetById(assetDefinition);
		AssetDefinition assets=IAssetsDefinitonDAO.findById(id).orElse(null);
		
		if(assets==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Assests with id" + id + " is not available in the database!!!");
		}else {
			assets.setAssetDefinitionName(assetDefinition.getAssetDefinitionName());
			assets.setAssetDefinitionClass(assetDefinition.getAssetDefinitionClass());
			assets.setAssetType(assetDefinition.getAssetType());
			IAssetsDefinitonDAO.save(assets);
			return ResponseEntity.status(HttpStatus.OK).body("Assest Data has been successfully update the database!!!");
		}
		
		
	}
}
