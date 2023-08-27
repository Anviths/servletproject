package com.tyss.foodapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tyss.foodapp.dto.Branch;
import com.tyss.foodapp.dto.User;
import com.tyss.foodapp.service.BranchService;
import com.tyss.foodapp.service.implementation.BranchServiceImplementation;
import com.tyss.foodapp.service.implementation.UserServiceImplementation;
import com.tyss.foodapp.util.Role;

@WebServlet(value = "/branch")
public class BranchController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User useradmin = (User) req.getSession().getAttribute("useradmin");
		req.getSession().setAttribute("useradmin", useradmin);

		String branchName = req.getParameter("branch_name");
		String branchAddress = req.getParameter("branch_address");
		String branchEmail = req.getParameter("branch_email");
		String branchPhone = req.getParameter("branch_phone");
		String branchManagerEmail = req.getParameter("branch_manage_email");

		Branch branch = new Branch();
		branch.setName(branchName);
		branch.setEmail(branchEmail);
		branch.setAddress(branchAddress);
		branch.setPhoneNumber(Long.parseLong(branchPhone));

		req.getSession().setAttribute("branch", branch);

		User user = new UserServiceImplementation().getByEmail(branchManagerEmail);

		if (user != null) {
			if (user.getRole().equals(Role.BRANCHMANAGER)) {
				List<Branch> userBranches = user.getBranches();
				userBranches.add(branch);
				user.setBranches(userBranches);
				branch.setUser(user);
				BranchService branchService = new BranchServiceImplementation();
				branchService.createBranchService(branch);
				req.getRequestDispatcher("admin.jsp").forward(req, resp);
			}
		 else {
			PrintWriter printWriter = resp.getWriter();

			printWriter.print("<!DOCTYPE html>");
			printWriter.print("<html>");
			printWriter.print("<head>");
			printWriter.print("<title>User Not Found</title>");
			printWriter.print("<style>");
			printWriter.print(
					"body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
//			printWriter.print(".login-container { max-width: 800px; margin: 0 auto; padding: 20px; }");
			printWriter.print(".error-message {  color: red; padding: 20px; margin-bottom: 20px; }");
			printWriter.print("h2 { font-size: 24px; margin-bottom: 10px; }");
			printWriter.print("p { font-size: 16px; line-height: 1.5; margin-bottom: 10px; }");
			printWriter.print("</style>");
			printWriter.print("</head>");
			printWriter.print("<body>");

			printWriter.print("<div class=\"login-container\">");

			printWriter.print("<div class=\"error-message\">");
			printWriter.print("<h2>Manger  Not Found</h2>");
			printWriter.print("</div>");

			printWriter.print("</div>");
			printWriter.print("</body>");
			printWriter.print("</html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("branchcreate.jsp");
			dispatcher.include(req, resp);
		}
		}
	}
}
