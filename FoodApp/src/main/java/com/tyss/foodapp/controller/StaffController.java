package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.Menu;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.MenuServiceImplemntation;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
@WebServlet(value = "/staffcontroller")
public class StaffController extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	User userManager=(User) req.getSession().getAttribute("userlogin");
	  req.getSession().setAttribute("userlogin",userManager);
	  Menu menu=new MenuServiceImplemntation().getMenuServiceByUserId(userManager.getId());
	   
	String operation=req.getParameter("operation");
	String[] parameterValues = req.getParameterValues("user_id");
	for (String id : parameterValues) {
		
		User user= new UserServiceImplementation().getByIdService(Integer.parseInt(id));
		 req.getSession().setAttribute("userstaff",user);
		 
		 if(user!=null) {
			 if(operation.equals("Delete")) {
				 req.getRequestDispatcher("delete-staff").forward(req, resp);
			 }
			 else {
		 req.getRequestDispatcher("updatestaff.jsp").forward(req, resp);
			 }
		 }
	}
	
}
}
