package com.tyss.foodapp.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.FoodProductService;
import com.tyss.foodapp.service.MenuService;
import com.tyss.foodapp.service.implementation.FoodProductServiceImplementation;
import com.tyss.foodapp.service.implementation.MenuServiceImplemntation;

@WebServlet(value = "/menu-controller")
public class MenuController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user=(User) req.getSession().getAttribute("userlogin");
		   req.getSession().setAttribute("userlogin", user);
		   
		   Menu menu=(Menu) req.getSession().getAttribute("menu");
		   req.getSession().setAttribute("menu",menu);
		
       String operation=req.getParameter("menu_control");
       String foodProductId=req.getParameter("items");
       
       FoodProductService foodProductService= new FoodProductServiceImplementation();
		  FoodProduct foodProduct= foodProductService.getFoodProductById(Integer.parseInt(foodProductId));
	   
	   req.getSession().setAttribute("foodproduct" ,foodProduct);
		
		if(operation.equals("DeleteFoodProduct")) {
			
			req.getRequestDispatcher("deletefoodproduct.jsp").forward(req, resp);
		}
		else {
			req.getRequestDispatcher("updatefoodproduct.jsp").forward(req, resp);
		}
	}
}
