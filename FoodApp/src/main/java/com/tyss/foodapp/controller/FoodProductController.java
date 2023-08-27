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
import javax.servlet.http.HttpSession;

import com.tyss.foodapp.dto.FoodProduct;
import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.FoodProductService;
import com.tyss.foodapp.service.implementation.FoodProductServiceImplementation;
import com.tyss.foodapp.service.implementation.MenuServiceImplemntation;
import com.tyss.foodapp.util.Ailability;
import com.tyss.foodapp.util.FoodType;
@WebServlet(value = "/foodproduct")
public class FoodProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FoodProductService foodProductService=new FoodProductServiceImplementation();
		
		HttpSession httpSession= req.getSession();
		
		User user=(User)httpSession.getAttribute("userlogin");
		req.getSession().setAttribute("userManager", user);
		Menu menu=(Menu) req.getSession().getAttribute("menu");
		   req.getSession().setAttribute("menu", menu);
		  
		FoodProduct foodProduct=new FoodProduct();
		String foodName=req.getParameter("food_product_name");
		String foodtype=req.getParameter("food_product_type");
		String foodAbout=req.getParameter("food_product_about");
		String foodAvailable=req.getParameter("food_product_available");
		double foodPrice=Double.parseDouble(req.getParameter("food_product_price"));
		foodProduct.setName(foodName);
		foodProduct.setAbout(foodAbout);
		foodProduct.setAvailabilty(Ailability.valueOf(foodAvailable));
		foodProduct.setType(FoodType.valueOf(foodtype));
		foodProduct.setPrice(foodPrice);
		foodProduct.setMenu(menu);
		//menu
		List<FoodProduct> foodProducts=new ArrayList<FoodProduct>();
		if(menu==null) {
			menu=new Menu();
		foodProducts.add(foodProduct);
		menu.setFoodProducts(foodProducts);
		menu.setUser(user);
		new MenuServiceImplemntation().createMenuService(menu);
		}
		else {
			
			foodProducts.add(foodProduct);
			menu.setFoodProducts(foodProducts);
			new MenuServiceImplemntation().updateMenuService(menu);
		}
		
		req.getRequestDispatcher("menu.jsp").forward(req, resp);
	}
}
