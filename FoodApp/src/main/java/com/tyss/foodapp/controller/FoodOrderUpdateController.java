package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
@WebServlet(value = "/update-food-order")
public class FoodOrderUpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User userStaff=(User) req.getSession().getAttribute("userlogin");
		  req.getSession().setAttribute("userlogin",userStaff);
		
		String foodOrderId= req.getParameter("order_items");
		String operation= req.getParameter("menu_control");
		
		FoodOrder foodOrder =new FoodOrderServiceImplementation().findFoodOrderService(Integer.parseInt(foodOrderId));
		 req.getSession().setAttribute("foodorder",foodOrder);
		 
		 if(operation.equals("UpdateFoodProduct")) {
			 req.getRequestDispatcher("updatefoodorder.jsp").forward(req, resp);
		 }
		 else {
			 req.getRequestDispatcher("deletefoodorder").forward(req, resp);
		 }
	}
}
