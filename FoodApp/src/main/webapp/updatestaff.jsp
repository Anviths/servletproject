<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="com.tyss.foodapp.dto.Branch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
    
 
     <% 
     User userManager = (User) request.getSession().getAttribute("userlogin");
 	request.getSession().setAttribute("userlogin", userManager);
 	
 	User userStaff=(User) request.getSession().getAttribute("userstaff");
 	request.getSession().setAttribute("userstaff",userStaff);
     %>
    
<div class="navbar">
        <a href="branchmanger.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= userManager.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
    
    <div class="wrapper">
			<div class="inner">
				
				<form action="staff-update">
					<h3>Update Staff</h3>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" name="user_name" class="form-control" placeholder="user_name">
					</div>
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" name="user_email"class="form-control" placeholder="user_email">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" name="user_password" class="form-control" placeholder="Password">
					</div>
					
					<button>
						<span>Update Staff</span>
					</button>
				
				</form>
			
		</div>
		</div>
</body>
</html>