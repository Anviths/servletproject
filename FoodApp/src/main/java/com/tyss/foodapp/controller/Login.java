package com.tyss.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.UserService;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
import com.tyss.foodapp.util.Role;
@WebServlet(value = "/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("user_email");
		String password=req.getParameter("user_password");
		
		
		UserService userService=new UserServiceImplementation();
		User user=userService.loginService(email, password);
		if(user!=null) {
			HttpSession httpSession=req.getSession();
			httpSession.setAttribute("user", user);
			
			if(user.getRole().equals(Role.ADMIN)) {
			RequestDispatcher dispatcher= req.getRequestDispatcher("admin.jsp");
			dispatcher.forward(req, resp);
			}
			else if(user.getRole().equals(Role.BRANCHMANAGER)) {
				RequestDispatcher dispatcher= req.getRequestDispatcher("branchmanger.jsp");
				dispatcher.forward(req, resp);
			}
			else if(user.getRole().equals(Role.STAFF)) {
				RequestDispatcher dispatcher= req.getRequestDispatcher("staff.jsp");
				dispatcher.forward(req, resp);
			}
			else  {
				RequestDispatcher dispatcher= req.getRequestDispatcher("customer.jsp");
				dispatcher.forward(req, resp);
			}
			
		}
		else {
			PrintWriter printWriter=resp.getWriter();
			
			printWriter.print("<!DOCTYPE html>");
			printWriter.print("<html>");
			printWriter.print("<head>");
			printWriter.print("<title>User Not Found</title>");
			printWriter.print("<style>");
			printWriter.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
//			printWriter.print(".login-container { max-width: 800px; margin: 0 auto; padding: 20px; }");
			printWriter.print(".error-message {  color: red; padding: 20px; margin-bottom: 20px; }");
			printWriter.print("h2 { font-size: 24px; margin-bottom: 10px; }");
			printWriter.print("p { font-size: 16px; line-height: 1.5; margin-bottom: 10px; }");
			printWriter.print("</style>");
			printWriter.print("</head>");
			printWriter.print("<body>");
			
			printWriter.print("<div class=\"login-container\">");

			RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
			

			printWriter.print("<div class=\"error-message\">");
			printWriter.print("<h2>User Not Found</h2>");
			printWriter.print("</div>");
			
			printWriter.print("</div>");
			printWriter.print("</body>");
			printWriter.print("</html>");
//			RequestDispatcher dispatcher= req.getRequestDispatcher("login.jsp");
//			dispatcher.include(req, resp);
		}
	}
}
