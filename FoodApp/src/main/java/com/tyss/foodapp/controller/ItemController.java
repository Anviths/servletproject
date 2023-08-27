package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.Item;
import com.tyss.foodapp.service.ItemService;
import com.tyss.foodapp.service.implementation.ItemServiceImplementation;
import com.tyss.foodapp.util.FoodType;
@WebServlet(value = "/item")
public class ItemController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		Integer productId=Integer.parseInt(req.getParameter("item_id"));
		Integer quantity=Integer.parseInt(req.getParameter("item_quantity"));
		String name=req.getParameter("item_name");
		String price=req.getParameter("item_price");
		String type=req.getParameter("item_type");
		
		Item item=new  Item();
		item.setProductId(productId);
		item.setName(name);
		item.setQuantity(quantity);
		item.setPrice(Double.parseDouble(price));
		item.setType(FoodType.valueOf(type));
//		ItemService itemService =new ItemServiceImplementation();
//		itemService.createItemService(item);
		
//		req.setAttribute("item_name", name);
//		req.setAttribute("item_id", productId);
//		req.setAttribute("item_quantity", quantity);
//		req.setAttribute("item_price", price);
//		req.setAttribute("item_type", type);
//		req.setAttribute("item", item);
//		req.getRequestDispatcher("foodorder.jsp").forward(req, resp);
	}
}
