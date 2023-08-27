package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.FoodProductServiceImplementation;
import com.tyss.foodapp.util.Ailability;
import com.tyss.foodapp.util.FoodType;

@WebServlet(value = "/update-foodproduct")
public class FoodProductUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user=(User)req.getSession().getAttribute("userlogin");
		req.getSession().setAttribute("userlogin", user);
		Menu menu=(Menu) req.getSession().getAttribute("menu");
		   req.getSession().setAttribute("menu", menu);
		   FoodProduct foodProduct=(FoodProduct) req.getSession().getAttribute("foodproduct");
		   req.getSession().setAttribute("items" ,foodProduct);
		   
		   String foodName=req.getParameter("food_product_name");
			String foodtype=req.getParameter("food_product_type");
			String foodAbout=req.getParameter("food_product_about");
			String foodAvailable=req.getParameter("food_product_available");
			String foodPrice=req.getParameter("food_product_price");
			
			
		   
				  if(!foodName.isEmpty()) {
					  foodProduct.setName(foodName);
				  }
				  if(!foodtype.isEmpty()) {
					  foodProduct.setType(FoodType.valueOf(foodtype));
				  }
				  if(!foodAvailable.isEmpty()) {
					  foodProduct.setAvailabilty(Ailability.valueOf(foodAvailable));
				  }
				  if(!foodAbout.isEmpty()) {
					  foodProduct.setAbout(foodAbout);
				  }
				  if(!foodPrice.isEmpty()) {
					  foodProduct.setPrice(Double.parseDouble(foodPrice) );
				  }
				 new FoodProductServiceImplementation().updateFoodProduct(foodProduct);
			   
		   
		   req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}

}
