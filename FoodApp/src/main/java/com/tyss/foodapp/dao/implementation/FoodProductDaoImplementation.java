package com.tyss.foodapp.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.tyss.foodapp.dao.FoodProductDao;
import com.tyss.foodapp.databse.EntityController;
import com.tyss.foodapp.dto.FoodProduct;

public class FoodProductDaoImplementation implements FoodProductDao{
	public EntityManagerFactory entityManagerFactory=EntityController.entityManagerFactory;
	public EntityManager entityManager=entityManagerFactory.createEntityManager();
	public EntityTransaction entityTransaction=entityManager.getTransaction();
	
	@Override
	public FoodProduct createFoodProduct(FoodProduct foodProduct) {
//		entityTransaction.begin();
		entityManager.persist(foodProduct);
//		entityTransaction.commit();
		return foodProduct;
	}

	@Override
	public FoodProduct findFoodProduct(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(FoodProduct.class, id);
	}

	@Override
	public FoodProduct upadteFoodProduct(FoodProduct foodProduct) {
		
		entityTransaction.begin();
		entityManager.merge(foodProduct);
		entityTransaction.commit();
		return foodProduct;
	}

	@Override
	public boolean deleteFoodProduct(int id) {
		FoodProduct foodProduct =findFoodProduct(id);
		if(foodProduct!=null) {
			entityTransaction.begin();
			entityManager.remove(foodProduct);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

}
