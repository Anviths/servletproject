package com.tyss.foodapp.test;

import com.tyss.foodapp.dao.FoodProductDao;
import com.tyss.foodapp.dao.implementation.FoodProductDaoImplementation;
import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.service.FoodProductService;
import com.tyss.foodapp.service.implementation.FoodProductServiceImplementation;
import com.tyss.foodapp.util.Ailability;
import com.tyss.foodapp.util.FoodType;

public class FoodproductTest {

	public static void main(String[] args) {
		
//		FoodProductDao foodProductDao=new FoodProductDaoImplementation();
//		FoodProduct foodProduct=new FoodProduct();
//		foodProduct.setName("idly");
//		foodProduct.setType(FoodType.VEG);
//		foodProduct.setAbout("food");
//		foodProduct.setAvailabilty(Ailability.AVAILABILE);
//		foodProduct.setPrice(100);
//		foodProduct.setMenu(new MenuDaoImplementation().findMenu(1));
//		
//		
//		foodProductDao.createFoodProduct(foodProduct);
		
//		FoodProduct foodProduct=foodProductDao.findFoodProduct(1);
//		System.out.println(foodProduct.getName());
//		System.out.println(foodProduct.getPrice());
//		System.out.println(foodProduct.getMenu());
		
//		if(foodProduct!=null) {
//			foodProduct.setPrice(250);
//			foodProductDao.upadteFoodProduct(foodProduct);
//		}
	
//		foodProductDao.deleteFoodProduct(1);
		
		FoodProductService foodProductService=new FoodProductServiceImplementation();
		foodProductService.getFoodProductByMenuId(1);
	}
	
    
}
