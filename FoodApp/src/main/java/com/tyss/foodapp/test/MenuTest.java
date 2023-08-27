package com.tyss.foodapp.test;

import java.util.Arrays;
import java.util.List;

import com.tyss.foodapp.dao.MenuDao;
import com.tyss.foodapp.dao.implementation.FoodProductDaoImplementation;
import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dao.implementation.UserImplementation;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.MenuService;
import com.tyss.foodapp.service.implementation.MenuServiceImplemntation;

public class MenuTest {

	public static void main(String[] args) {
//		MenuDao menuDao=new MenuDaoImplementation();
		
//		Menu menu=new Menu();
//		menu.setUser(new UserImplementation().findUser(7));
//		
//		FoodProduct foodProduct=new FoodProductDaoImplementation().findFoodProduct(1);
//		List<FoodProduct> foodProducts=Arrays.asList(foodProduct);
//		menu.setFoodProducts(foodProducts);
//		
//		menuDao.createMenu(menu);
		
//		Menu menu=menuDao.findMenu(1);
//		System.out.println(menu);
//		if(menu!=null) {
////			User user=menu.getUser();
////			System.out.println(user);
//			List<FoodProduct> foodProducts = menu.getFoodProducts();
//			for (FoodProduct foodProduct : foodProducts) {
//				
//				System.out.println(foodProduct);
//			}
		
		
//		if(menu!=null) {
//			menu.setUser(null);
//			menuDao.upadteMenu(menu);
//		}
		
		//delete food product 
//		menuDao.deleteMenu(1);
	MenuService menuService=new MenuServiceImplemntation();
	  Menu menu=  menuService.getMenuServiceByUserId(4);
	  System.out.println(menu.getId());
	}
}
