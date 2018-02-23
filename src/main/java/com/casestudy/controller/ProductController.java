package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.Doctor;
import com.casestudy.model.Patient;
import com.casestudy.model.Product;
import com.casestudy.service.EntityService;

@RestController
public class ProductController {
	
	@Autowired
	EntityService entityService;
	
	/**
	 * create product entity
	 * @param product
	 */
	@PostMapping("/entities/product")
	public void saveProductEntity(@RequestBody Product product){		
		entityService.saveEntityItem(product);		
	}
	
	/**
	 * update product
	 * @param id
	 * @param product
	 * @return
	 */
	@PutMapping("/entities/product/{id}")
	public ResponseEntity<Product> updatePatientEntity(@PathVariable Long id, @RequestBody Product product){
		
		Product productDetail = (Product) entityService.findEntityItemById(id);
		if(productDetail == null) {
			return ResponseEntity.notFound().build();
		}
		productDetail.setName(product.getName());
		productDetail.setDescription(product.getDescription());
		productDetail.setCost(product.getCost());
		productDetail.setProductCategory(product.getProductCategory());
		entityService.updateEntityItem(productDetail);
		
		return ResponseEntity.ok(productDetail);
	}
}
