package com.tyss.foodapp.dao;

import com.tyss.foodapp.dto.FoodProduct;

public interface FoodProductDao {

	FoodProduct createFoodProduct(FoodProduct foodProduct);

	FoodProduct findFoodProduct(int id);

	FoodProduct upadteFoodProduct(FoodProduct foodProduct);

	boolean deleteFoodProduct(int id);
}
