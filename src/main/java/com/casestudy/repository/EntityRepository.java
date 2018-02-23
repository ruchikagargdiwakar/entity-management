package com.casestudy.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.casestudy.model.EntityItem;

@Repository
public class EntityRepository {
	
	@Autowired
	EntityManager em;
	
	/**
	 * create new entity
	 * @param entityItem
	 */
	public void saveEntityItem(EntityItem entityItem) {
		em.persist(entityItem);
	}
	
	/**
	 * retrieve all entities
	 * @return
	 */
	public List<EntityItem> findAllEntities(){
		return em.createQuery("select ei from EntityItem ei",EntityItem.class).getResultList();
	}
	
	/**
	 * find entity item for given id
	 * @param id
	 * @return
	 */
	public EntityItem findEntityItemById(long id) {
		return em.find(EntityItem.class, id);
	}
	
	/**
	 * delete an entity item
	 * @param id
	 * @return
	 */
	public void deleteEntityItem(EntityItem entityItem) {
		em.remove(entityItem);
	}
	
	/**
	 * update an entity item
	 * @param entityItem
	 */
	public void updateEntityItem(EntityItem entityItem) {
		em.merge(entityItem);
	}

}
