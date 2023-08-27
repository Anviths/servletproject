package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.FoodOrder;

public interface FoodOrderDao {

	FoodOrder createFoodOrder(FoodOrder foodOrder);

	FoodOrder findFoodOrder(int id);

	FoodOrder upadteFoodOrder(FoodOrder foodOrder);

	boolean deleteFoodOrder(int id);
}
