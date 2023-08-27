<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="com.tyss.foodapp.dto.Branch"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Branch</title>
<link rel="stylesheet" href="css/login.css">
<link rel="stylesheet" href="css/admin.css">
</head>
<body>

 <% Branch branch= (Branch) request.getSession().getAttribute("branch_data");
     request.getSession().setAttribute("branch_value", branch);
     User useradmin = (User) request.getSession().getAttribute("useradmin");
	 request.getSession().setAttribute("useradmin",useradmin);
   
     %>
  <div class="navbar">
        <a href="admin.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= useradmin.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
     <div class="wrapper">
			<div class="inner">
				
				<form action="branch_update">
					<h3>Update branch</h3>
					
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" name="branch_name"class="form-control" placeholder="Branch Name">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="text" name="branch_address" class="form-control" placeholder="Branch Address">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="tel" name="branch_phone" class="form-control" placeholder="Branch Phone" >
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="text" name="branch_email" class="form-control" placeholder="Branch Email">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="text" name="branch_manage_email" class="form-control" placeholder="Branch Manager Email">
					</div>
					
					<button>
						<span>Update branch</span>
					</button>
				
				</form>
			
		</div>
		</div>
     
    
</body>
</html>