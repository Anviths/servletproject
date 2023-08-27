package com.tyss.foodapp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.BranchService;
import com.tyss.foodapp.service.implementation.BranchServiceImplementation;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
@WebServlet(value = "/branch_update")
public class BranchUpdate2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		 req.getSession().setAttribute("user",user); 
		String branchName=req.getParameter("branch_name");
			String branchAddress=req.getParameter("branch_address");
			String branchEmail=req.getParameter("branch_email");
			String branchPhone=req.getParameter("branch_phone");
			String branchManagerEmail=req.getParameter("branch_manage_email");
			Branch branch= (Branch) req.getSession().getAttribute("branch_data");
			
			
			if(!branchName.isEmpty()) {
				branch.setName(branchName);
			}
			if(!branchAddress.isEmpty()) {
				branch.setAddress(branchAddress);
			}
			if(!branchEmail.isEmpty()) {
				branch.setEmail(branchEmail);
			}
			if (!branchPhone.isEmpty()) {
				branch.setPhoneNumber(Long.parseLong(branchPhone));
			}
			if(!branchManagerEmail.isEmpty()) {
				User userf= new UserServiceImplementation().getByEmail(branchManagerEmail);
				if(user!=null) {
					branch.setUser(user);
				}
			}
			
			BranchService branchService=new BranchServiceImplementation();
			branchService.updateBranchService(branch);
			
			req.getRequestDispatcher("findbranch.jsp").forward(req, resp);
	}
}
