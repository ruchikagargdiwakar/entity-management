package com.casestudy.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.model.EntityItem;
import com.casestudy.repository.EntityRepository;

@Service
@Transactional
public class EntityService {
	
	@Autowired
	EntityRepository entityRepository;
	
	/**
	 * create new entity
	 * @param entityItem
	 */
	public void saveEntityItem(EntityItem entityItem) {
		entityRepository.saveEntityItem(entityItem);
	}
	
	/**
	 * retrieve all entities
	 * @return
	 */
	public List<EntityItem> findAllEntities(){
		return entityRepository.findAllEntities();
	}
	
	/**
	 * find entity item for given id
	 * @param id
	 * @return
	 */
	public EntityItem findEntityItemById(long id) {
		return entityRepository.findEntityItemById(id);
	}
	
	/**
	 * delete an entity item
	 * @param id
	 * @return
	 */
	public void deleteEntityItem(EntityItem entityItem) {
		entityRepository.deleteEntityItem(entityItem);
	}
	
	/**
	 * update an entity item
	 * @param entityItem
	 */
	public void updateEntityItem(EntityItem entityItem) {
		entityRepository.updateEntityItem(entityItem);
	}

}
