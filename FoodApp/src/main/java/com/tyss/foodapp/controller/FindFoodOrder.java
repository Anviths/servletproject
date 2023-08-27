package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.FoodOrder;
import com.tyss.foodapp.service.FoodOrderService;
import com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation;
@WebServlet(value = "/find-order")
public class FindFoodOrder extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 FoodOrderService foodOrderService=new FoodOrderServiceImplementation();
		    Integer order_id= Integer.parseInt(req.getParameter("order_id"));
		    FoodOrder foodOrder= foodOrderService.findFoodOrderService(order_id);
		    if(foodOrder!=null){
		    	req.setAttribute("foodorder", foodOrder);
		    	req.getRequestDispatcher("displayfoodorder.jsp").forward(req, resp);
		    }
		    else {
		    	req.getRequestDispatcher("findfoodOrder.jsp").include(req, resp);
		    }
	}
}
