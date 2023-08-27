package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.foodapp.dao.FoodOrderDao;
import com.tyss.foodapp.databse.EntityController;
import com.tyss.foodapp.dto.FoodOrder;

public class FoodOrderDaoImplementation implements FoodOrderDao {

	public EntityManagerFactory entityManagerFactory=EntityController.entityManagerFactory;
	public EntityManager entityManager = entityManagerFactory.createEntityManager();
	public EntityTransaction entityTransaction = entityManager.getTransaction();

	@Override
	public FoodOrder createFoodOrder(FoodOrder foodOrder) {
		entityTransaction.begin();
		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	@Override
	public FoodOrder findFoodOrder(int id) {
		return entityManager.find(FoodOrder.class, id);

	}

	@Override
	public FoodOrder upadteFoodOrder(FoodOrder foodOrder) {
		entityTransaction.begin();
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}

	@Override
	public boolean deleteFoodOrder(int id) {
		FoodOrder foodOrder = findFoodOrder(id);
		if (foodOrder != null) {
			entityTransaction.begin();
			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
