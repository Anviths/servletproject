package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.FoodOrder;

public interface FoodOrderService {

	FoodOrder createFoodOrderService(FoodOrder foodOrder);
	FoodOrder updateFoodOrderService(FoodOrder foodOrder);
	boolean deleteFoodOrderService(FoodOrder foodOrder);
	FoodOrder findFoodOrderService(int id);
	double calculateTotalPrice(FoodOrder foodOrder);
	FoodOrder findFoodOrderByCustomerName(String name);
	List<FoodOrder> getAllFoodOrders();
	List<FoodOrder> getAllFoodOrdersByUserId(int id);
}
