package com.tyss.foodapp.test;

import java.util.Arrays;
import java.util.List;

import com.tyss.foodapp.dao.UserDao;
import com.tyss.foodapp.dao.implementation.FoodOrderDaoImplementation;
import com.tyss.foodapp.dao.implementation.MenuDaoImplementation;
import com.tyss.foodapp.dao.implementation.UserImplementation;
import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
import com.tyss.foodapp.util.Role;

public class Test {

	public static void main(String[] args) {
		UserDao userDao=new UserImplementation();
//		User user=new User();
//		user.setName("anil");
//		user.setEmail("anil@gmail.com");
//		user.setPassword("12345");
//		user.setRole(Role.CUSTOMER);
//		List<FoodOrder> foodOrders=Arrays.asList(new FoodOrderDaoImplementation().findFoodOrder(1));
//		user.setFoodOrders(foodOrders);
//		userDao.createUser(user);
		
//		User userfind=userDao.findUser(2);
//		if(user!=null)
//			System.out.println(userFind);
		
//		if(userfind!=null) {
//			userfind.setMenu(null);
//        userDao.upadteUser(userfind);
//		}
//		userDao.deleteUser(3);
		
		UserServiceImplementation s=new UserServiceImplementation();
		User u=s.getByEmail("anil@gmail.com");
		System.out.println(u);
	}

}
