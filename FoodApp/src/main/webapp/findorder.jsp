<%@page import="com.tyss.foodapp.dto.FoodOrder"%>
<%@page import="com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation"%>
<%@page import="com.tyss.foodapp.service.FoodOrderService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <form action="find-order">
    <h2>Enter the order id to update</h2>
    <input type="number" name="order_id">
    <input type="submit" value="search order">
    
    </form>
  
    
    
    
</body>
</html>