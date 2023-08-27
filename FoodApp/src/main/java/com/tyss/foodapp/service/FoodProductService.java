package com.tyss.foodapp.service;

import java.util.List;

import com.tyss.foodapp.dto.FoodProduct;

public interface FoodProductService {
	FoodProduct createFoodProduct(FoodProduct foodProduct);
	FoodProduct updateFoodProduct(FoodProduct foodProduct);
	boolean deleteFoodProduct(FoodProduct foodProduct);
	FoodProduct getFoodProductById(int id);
	FoodProduct getFoodProductByName(String name);
	List<FoodProduct> getFoodProductByBranchId(int branchId);
	List< FoodProduct> getFoodProductByMenuId(int menuId);
	List< FoodProduct> getFoodAllProducts();
	
	
}
