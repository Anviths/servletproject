package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
@WebServlet(value = "/delete-staff")
public class DeleteStaff extends HttpServlet {

@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	User userManager = (User) req.getSession().getAttribute("userManager");
 	req.getSession().setAttribute("userManager", userManager);
 	
 	User userStaff=(User) req.getSession().getAttribute("userstaff");
 	req.getSession().setAttribute("userstaff",userStaff);
 	
 	new UserServiceImplementation().deleteService(userStaff);
	req.getRequestDispatcher("staffdisplay.jsp").forward(req, resp);
}
}
