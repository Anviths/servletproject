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
@WebServlet(value = "/delete-branch")
public class DeleteBranch extends HttpServlet {
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		 req.getSession().setAttribute("user",user);
	    Branch branch= (Branch) req.getSession().getAttribute("branch_value");
	    
	    String adminPassword=req.getParameter("admin_password");
	    if(user!=null) {
	    if(user.getPassword().equals(adminPassword)) {
	        
	    	BranchService branchService=new BranchServiceImplementation();
	    	branchService.deleteBranchService(branch);
	    }
	    }
	    req.getRequestDispatcher("findbranch.jsp").forward(req, resp);
	}
}
