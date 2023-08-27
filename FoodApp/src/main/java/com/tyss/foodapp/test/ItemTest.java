package com.tyss.foodapp.test;

import com.tyss.foodapp.dao.ItemDao;
import com.tyss.foodapp.dao.implementation.ItemDaoImplentation;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.ItemService;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.FoodType;

public class ItemTest {

	public static void main(String[] args) {
		
//		ItemDao  itemDao=new ItemDaoImplentation();
		ItemService service=new ItemServiceImplementation();
		
		Item item=new Item();
		item.setName("kabab");
		item.setPrice(100);
		item.setProductId(272);
		item.setQuantity(2);
		item.setType(FoodType.NONVEG);
		
     service.createItemService(item);		
//		Item item=itemDao.findItem(1);
//		
//		System.out.println(item);
		
		
//		item.setQuantity(1);
//		itemDao.upadteItem(item);
		
//		itemDao.deleteItem(1);
	}
}
