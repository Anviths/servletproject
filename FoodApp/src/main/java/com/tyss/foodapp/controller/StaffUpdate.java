package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
@WebServlet(value = "/staff-update")
public class StaffUpdate extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("user_name");
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		
		User userManager = (User) req.getSession().getAttribute("userlogin");
	 	req.getSession().setAttribute("userlogin", userManager);
	 	
	 	User userStaff=(User) req.getSession().getAttribute("userstaff");
	 	req.getSession().setAttribute("userstaff",userStaff);
	 	
		if(!name.isEmpty()) {
			userStaff.setName(name);
		}
		if(!email.isEmpty()) {
			userStaff.setEmail(email);;
		}
		if(!password.isEmpty()) {
			userStaff.setEmail(email);;
		}
		
		new UserServiceImplementation().updateService(userStaff);
		req.getRequestDispatcher("staffdisplay.jsp").forward(req, resp);
	}
}
