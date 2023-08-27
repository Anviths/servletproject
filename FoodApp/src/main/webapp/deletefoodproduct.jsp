<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.dto.FoodProduct"%>
<%@page import="com.tyss.foodapp.service.FoodProductService"%>
<%@page import="com.tyss.foodapp.service.implementation.FoodProductServiceImplementation"%>
<%@page import="com.tyss.foodapp.dto.Menu"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <h1>enter password to delete food product</h1>
  <!-- <input type="text" name="password" > -->
<% User user=(User) request.getSession().getAttribute("userManager");
	   request.getSession().setAttribute("userManager", user);
	   
	   Menu menu=(Menu) request.getSession().getAttribute("menu");
	   request.getSession().setAttribute("menu", menu);
	   
	  FoodProduct foodProduct=(FoodProduct) request.getSession().getAttribute("foodproduct");
	   /* request.getSession().setAttribute("items" ,foodProduct); */
	   
	   
		  
		  
		 new  FoodProductServiceImplementation().deleteFoodProduct(foodProduct);
	  
	   request.getRequestDispatcher("menu.jsp").forward(request, response);
	%>
	
	
	
</body>
</html>