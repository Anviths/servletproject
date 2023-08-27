package com.tyss.foodapp.service.implementation;

import java.util.List;

import javax.persistence.Query;

import com.tyss.foodapp.dao.implementation.FoodOrderDaoImplementation;
import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.FoodOrderService;

public class FoodOrderServiceImplementation implements FoodOrderService{

	FoodOrderDaoImplementation foodOrderDao =new FoodOrderDaoImplementation();
	
	@Override
	public FoodOrder createFoodOrderService(FoodOrder foodOrder) {
		return foodOrderDao.createFoodOrder(foodOrder);
	}

	@Override
	public FoodOrder updateFoodOrderService(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		return foodOrderDao.upadteFoodOrder(foodOrder);
	}

	@Override
	public boolean deleteFoodOrderService(FoodOrder foodOrder) {
		// TODO Auto-generated method stub
		return foodOrderDao.deleteFoodOrder(foodOrder.getId());
	}

	@Override
	public FoodOrder findFoodOrderService(int id) {
		return foodOrderDao.findFoodOrder(id);
	}

	@Override
	public double calculateTotalPrice(FoodOrder foodOrder) {
		List<Item> items=foodOrder.getItems();
		int totalPrice=0;
		for (Item item : items) {
			if(item!=null && item.getQuantity()>0)
			totalPrice+=item.getPrice()*item.getQuantity();
		}
		return totalPrice;
	}

	@Override
	public FoodOrder findFoodOrderByCustomerName(String name) {
		Query query=foodOrderDao.entityManager.createQuery("select f from FoodOrder f where customerName=?1");
		query.setParameter(1, name);
		try {
			return (FoodOrder)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<FoodOrder> getAllFoodOrders() {
		Query query=foodOrderDao.entityManager.createQuery("select f from FoodOrder f");
		try {
			return (List<FoodOrder>)query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public List<FoodOrder> getAllFoodOrdersByUserId(int id) {
		Query query=foodOrderDao.entityManager.createQuery("select f from FoodOrder f where user_id=?1");
		query.setParameter(1, id);
		try {
			return (List<FoodOrder>)query.getResultList();
		} catch (Exception e) {
			return null;
		}
	}
}
