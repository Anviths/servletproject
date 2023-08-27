package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.UserService;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
import com.tyss.foodapp.util.Role;

@WebServlet(value = "/sign-up")
public class SignUp extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		String role = req.getParameter("user_role");

		UserService userService = new UserServiceImplementation();
		User user = new User();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setRole(Role.valueOf(role));
		userService.saveService(user);

		User userlogin = (User) req.getSession().getAttribute("userlogin");
		req.getSession().setAttribute("useradmin", userlogin);
		if (userlogin != null) {
			if (userlogin.getRole().equals(Role.BRANCHMANAGER)) {
				req.getRequestDispatcher("staffdisplay.jsp").forward(req, resp);;
			}
		}else {
				RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");

				dispatcher.forward(req, resp);
			}
		
	}
}
