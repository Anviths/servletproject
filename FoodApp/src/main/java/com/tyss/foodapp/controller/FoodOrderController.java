package com.tyss.foodapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.FoodOrderService;
import com.tyss.foodapp.service.FoodProductService;
import com.tyss.foodapp.service.ItemService;
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
import com.tyss.foodapp.service.implementation.FoodProductServiceImplementation;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.Status;
@WebServlet(value = "/food-order")
public class FoodOrderController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String name=req.getParameter("food_order_customer_name");
		String phone=req.getParameter("food_order_customer_phone");
		String status=req.getParameter("status");
		List<Item> items=new ArrayList<Item>();
		FoodProductService foodProductService=new FoodProductServiceImplementation();
		String[] selectedValues=req.getParameterValues("order_items");
		
		
		
		for (String productId : selectedValues) {
		FoodProduct foodProduct = foodProductService.getFoodProductById(Integer.parseInt(productId));
		Item item=new Item();
		item.setProductId(foodProduct.getId());
		item.setName(foodProduct.getName());
		String paramName="item_quantity_"+foodProduct.getId();
		String quantity=req.getParameter(paramName);
		if(quantity==null)
			quantity="1";
		item.setQuantity(Integer.parseInt(quantity));
		item.setPrice(foodProduct.getPrice());
		item.setType(foodProduct.getType());
			
			items.add(item);
		}
			
		
		 
		FoodOrder foodOrder=new FoodOrder();
		foodOrder.setCustomerName(name);
		foodOrder.setCustomerNumber(phone);
		foodOrder.setStatus(Status.valueOf(status));
		User user = (User) req.getSession().getAttribute("user");
		foodOrder.setUser(user);
		foodOrder.setItems(items);
		
		FoodOrderService foodOrderService=new FoodOrderServiceImplementation();
		foodOrder.setTotalPrice(foodOrderService.calculateTotalPrice(foodOrder));
		foodOrderService.createFoodOrderService(foodOrder);
		req.getSession().setAttribute("foodorder", foodOrder);
		req.getSession().setAttribute("items", items);
		req.getRequestDispatcher("bill.jsp").forward(req, resp);
	}
	
	
	
}
