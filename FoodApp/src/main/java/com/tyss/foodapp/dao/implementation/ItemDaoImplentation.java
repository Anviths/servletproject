package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.foodapp.dao.ItemDao;
import com.tyss.foodapp.databse.EntityController;
import com.tyss.foodapp.dto.Item;

public class ItemDaoImplentation implements ItemDao {

	public EntityManagerFactory entityManagerFactory=EntityController.entityManagerFactory;
	public EntityManager entityManager = entityManagerFactory.createEntityManager();
	public EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public Item createItem(Item item) {
		
		entityManager.persist(item);
		
		return item;
	}

	@Override
	public Item findItem(int id) {
		return entityManager.find(Item.class, id);
	}

	@Override
	public Item upadteItem(Item item) {
		entityTransaction.begin();
		entityManager.merge(item);
		entityTransaction.commit();
		return item;
	}

	@Override
	public boolean deleteItem(int id) {
		Item item = findItem(id);
		if (item != null) {
			entityTransaction.begin();
			entityManager.remove(item);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
