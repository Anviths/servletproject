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

@WebServlet(value = "/branchupdate")
public class BranchUpdate extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		req.getSession().setAttribute("user", user);
		BranchService branchService = new BranchServiceImplementation();
		String[] branchIds = req.getParameterValues("update_value");
		String operation = req.getParameter("update");
		for (String branchId : branchIds) {
			Branch branch = branchService.getBranchServiceById(Integer.parseInt(branchId));
			if (branch != null) {
				req.getSession().setAttribute("branch_data", branch);
				if (operation.equals("Delete")) {
					req.getRequestDispatcher("deletebranch.jsp").forward(req, resp);
				} else {
					req.getRequestDispatcher("updatebranch.jsp").forward(req, resp);
				}
			}
		}
	}
}
