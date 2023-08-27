<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="com.tyss.foodapp.controller.FindFoodOrder"%>
<%@page import="com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation"%>
<%@page import="com.tyss.foodapp.service.FoodOrderService"%>
<%@page import="com.tyss.foodapp.util.Status"%>
<%@page import="com.tyss.foodapp.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  
  <%
	User user = (User) request.getSession().getAttribute("user");
	%>
   <%
  FoodOrder foodOrder= (FoodOrder) request.getAttribute("foodorder");
   
   %>
    <h2> Order id :<%=foodOrder.getId() %></h2>
    <h2> customer name :<%=foodOrder.getCustomerName() %>    </h2>
    <h2> customer number : <%=foodOrder.getCustomerNumber() %> </h2>
    <h2> order time :<%=foodOrder.getOrderCreatedTime() %></h2>
    <h2> status :<%=foodOrder.getStatus() %>  </h2>
    <h2> total price :<%=foodOrder.getTotalPrice() %></h2> <br><br>
    
      <a href="updatefoodorder.jsp">update</a>
    
    <% 
    request.getSession().setAttribute("foodorder", foodOrder);
    %>
</body>
</html>