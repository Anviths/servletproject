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

@WebServlet(value = "/deletefoodorder")
public class DeleteFoodOrder extends HttpServlet {
 @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 User userStaff=(User) req.getSession().getAttribute("userlogin");
	  req.getSession().setAttribute("userlogin",userStaff);
	  FoodOrder foodOrder=(FoodOrder) req.getSession().getAttribute("foodorder");
	  req.getSession().setAttribute("foodorder",foodOrder); 
	  
	  new FoodOrderServiceImplementation().deleteFoodOrderService(foodOrder);
	  req.getRequestDispatcher("findfoodorder.jsp").forward(req, resp);
		 
}
}
