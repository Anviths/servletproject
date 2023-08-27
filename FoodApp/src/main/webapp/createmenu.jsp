<%@page import="com.tyss.foodapp.service.implementation.MenuServiceImplemntation"%>
<%@page import="com.tyss.foodapp.dto.Menu"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Menu</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/login.css">
</head>
<body>
   <%  
   User userManager=(User) request.getSession().getAttribute("userlogin");
   request.getSession().setAttribute("userlogin", userManager);
	
	 Menu menu=(Menu) request.getSession().getAttribute("menu");
	   
	if(menu==null)
	 menu=new MenuServiceImplemntation().getMenuServiceByUserId(userManager.getId());
	request.getSession().setAttribute("menu", menu);
	%> 
	<div class="navbar">
        <a href="branchmanger.jsp" class="home-button">Home</a>
        <span  class="user-profile"> Menu-Id:<%= menu.getId() %></span>
        <span class="user-profile"><%= userManager.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
	<!--food product controller  -->

     
     <div class="wrapper">
			<div class="inner">
				
				<form action="foodproduct">
					<h3>Add Food Product To Menu</h3>
					
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" name="food_product_name"class="form-control" placeholder="Food Name">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="text" name="food_product_about" class="form-control" placeholder="about">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<span class="lnr lnr-lock"></span>
						<select class="form-control" name="food_product_type" required="required">
							
							<option class="form-control" value="VEG"  >VEG
							<option class="form-control" value="NONVEG" >Non-VEG
							</select>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<span class="lnr lnr-lock"></span>
						<select class="form-control" name="food_product_available" required="required" >
							
							<option class="form-control" value="AVAILABILE" >AVAILABLE
							<option class="form-control" value="NOTAVAILABLE" >NOTAVAILABLE
							</select>
					</div>
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="number" name="food_product_price"class="form-control" placeholder="Food Price">
					</div>
					<button>
						<span>Create</span>
					</button>
				
				</form>
			
		</div>
		</div>
</body>
</html>