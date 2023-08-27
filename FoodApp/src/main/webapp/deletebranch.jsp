<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="com.tyss.foodapp.service.implementation.BranchServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.dto.Branch"%>
<%@page import="com.tyss.foodapp.service.BranchService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete verify</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body>

    <% 
    User useradmin = (User) request.getSession().getAttribute("useradmin");
	 request.getSession().setAttribute("user",useradmin);
    Branch branch= (Branch) request.getSession().getAttribute("branch_data");
    request.getSession().setAttribute("branch_data",branch);
     
     %>
     <div class="navbar">
        <a href="admin.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= useradmin.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
     
     
     <div class="wrapper">
			<div class="inner">
				
				<form action="delete-branch">
					<h3>Enter the Password</h3>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" name="admin_password" class="form-control" placeholder="Password">
					</div>
					
					<button>
						<span>Delete Branch</span>
					</button>
				</form>
			
		</div>
		</div>
     
	<a href="admin.jsp"><button>admin page</button></a>
</body>
</html>