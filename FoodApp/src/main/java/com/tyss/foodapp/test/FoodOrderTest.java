package com.tyss.foodapp.test;

import java.util.Arrays;
import java.util.List;

import com.tyss.foodapp.dao.FoodOrderDao;
import com.tyss.foodapp.dao.ItemDao;
import com.tyss.foodapp.dao.implementation.FoodOrderDaoImplementation;
import com.tyss.foodapp.dao.implementation.ItemDaoImplentation;
import com.tyss.foodapp.dao.implementation.UserImplementation;
import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.FoodOrderService;
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.Status;

public class FoodOrderTest {

	public static void main(String[] args) {

		FoodOrderServiceImplementation fsi=new FoodOrderServiceImplementation();
		List<FoodOrder> allFoodOrdersByUserId = fsi.getAllFoodOrdersByUserId(6);
		for (FoodOrder foodOrder : allFoodOrdersByUserId) {
			System.out.println(foodOrder.getId());
		}
//		FoodOrder foodOrder=new FoodOrder();
//		foodOrder.setStatus(Status.PREPARING);
//		foodOrder.setCustomerName("manoj");
//		foodOrder.setCustomerNumber("18584");
//		
////		Item item=new ItemServiceImplementation().findItemService(1);
//		Item item2=new ItemServiceImplementation().findItemService(5);
//		Item item3=new ItemServiceImplementation().findItemService(4);
//		
//		List<Item> items=Arrays.asList(item2,item3);
//		foodOrder.setItems(items);
//		foodOrder.setTotalPrice(fsi.calculateTotalPrice(foodOrder));
//		
//		
//		foodOrder.setUser(new UserImplementation().findUser(2));
//        fsi.createFoodOrderService(foodOrder);		
////       FoodOrder  foodOrder=foodOrderDao.findFoodOrder(1);
////       System.out.println(foodOrder);
////       if(foodOrder!=null) {
////    	   foodOrder.setStatus(Status.DELIVERD);
////    	   foodOrderDao.upadteFoodOrder(foodOrder);
////       }
//       
////       if(foodOrder!=null) {
////    	   foodOrderDao.deleteFoodOrder(1);
////       }
//       
       
	}

}
