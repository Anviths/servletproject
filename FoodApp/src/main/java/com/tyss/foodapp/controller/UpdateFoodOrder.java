package com.tyss.foodapp.controller;

import java.io.IOException;
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
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
import com.tyss.foodapp.service.implementation.FoodProductServiceImplementation;
import com.tyss.foodapp.util.Status;
@WebServlet(value = "/update-foodorder")
public class UpdateFoodOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User userStaff=(User) req.getSession().getAttribute("userlogin");
		  req.getSession().setAttribute("userlogin",userStaff);
		  FoodOrder foodOrder=(FoodOrder) req.getSession().getAttribute("foodorder");
		  req.getSession().setAttribute("foodorder",foodOrder); 
		
		 String name= req.getParameter("food_order_customer_name");
		   String number= req.getParameter("food_order_customer_phone");
		   String status= req.getParameter("status");
		   List<Item> items=foodOrder.getItems();
		   String[] selectedValues=req.getParameterValues("order_items");
		   if(selectedValues!=null) {
		   for (String productId : selectedValues) {
				FoodProduct foodProduct = new FoodProductServiceImplementation().getFoodProductById(Integer.parseInt(productId));
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
		   }
		   
		   if(!name.isEmpty()) {
			   foodOrder.setCustomerName(name);
		   }
		   if(!number.isEmpty()) {
			   foodOrder.setCustomerNumber(number);
		   }
		   if(!status.isEmpty()){
			   foodOrder.setStatus(Status.valueOf(status));
	}
		   FoodOrderService foodOrderService=new FoodOrderServiceImplementation();
			foodOrder.setTotalPrice(foodOrderService.calculateTotalPrice(foodOrder));
			foodOrderService.updateFoodOrderService(foodOrder);
			req.getRequestDispatcher("findfoodorder.jsp").forward(req, resp);
		    } 

}
