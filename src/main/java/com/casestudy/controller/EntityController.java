package com.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.model.EntityItem;
import com.casestudy.service.EntityService;

@RestController
public class EntityController {
	
	@Autowired
	EntityService entityService;
	
	/**
	 * Get entity details
	 * @param id
	 * @return
	 */
	@GetMapping("/entities/{id}")
	public ResponseEntity<EntityItem> findEntityById(@PathVariable Long id){
		
		EntityItem entityItem = entityService.findEntityItemById(id);
		if(entityItem == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(entityItem);
	}
	
	/**
	 * get all entity item
	 * @return
	 */
	@GetMapping("/entities")
	public List<EntityItem> findAllEntities(){		
		return entityService.findAllEntities();
	}
	
	/**
	 * delete entity for given id
	 * @param id
	 * @return
	 */
	@DeleteMapping("/entities/{id}")
	public ResponseEntity<EntityItem> deleteEntityById(@PathVariable Long id){
		
		EntityItem entityItem = entityService.findEntityItemById(id);
		if(entityItem == null) {
			return ResponseEntity.notFound().build();
		}
		entityService.deleteEntityItem(entityItem);
		return ResponseEntity.ok().build();
	}

}
