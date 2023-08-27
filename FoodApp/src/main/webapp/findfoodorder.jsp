<%@page import="com.tyss.foodapp.dto.FoodOrder"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.service.implementation.FoodOrderServiceImplementation"%>
<%@page import="com.tyss.foodapp.service.FoodOrderService"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Order</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/find.css">
<!-- <link rel="stylesheet" href="css/foodorder.css"> -->
</head>
<body>
<%User userStaff=(User) request.getSession().getAttribute("userlogin");
  request.getSession().setAttribute("userlogin",userStaff);

   %>
   <div class="navbar">
        <a href="staff.jsp" class="home-button">Home</a>
       
        <span class="user-profile"><%= userStaff.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
	
      
   
      
   
  <div class="wrapper">
        <div class="inner">
            <form action="update-food-order" class="food-order-form">
                <h3>Food Order</h3>
					
				
					
					<table class="branch-table">
  <tr> 
  <th>ProductId</th>
  <th>CustomerName</th>
  <th>CustomerNumber</th>
  <th>Order time</th>
  <th>Order Status</th>
  <th>quantity</th>
  <th>Total Price</th>
  <th>click to add</th>
  </tr>
  
   
   <% 
  FoodOrderService foodOrderService=new FoodOrderServiceImplementation();
      List<FoodOrder> foodOrders=foodOrderService.getAllFoodOrdersByUserId(userStaff.getId());
      for(FoodOrder foodOrder:foodOrders) { %>
    	 <tr>
    	  <td><%=foodOrder.getId() %></td>
    	  <td><%=foodOrder.getCustomerName()%></td>
    	  <td><%=foodOrder.getCustomerNumber() %></td>
    	  <td><%=foodOrder.getOrderCreatedTime() %></td>
    	  <td><%=foodOrder.getStatus() %></td>
    	  <td><%=foodOrder.getItems().size() %></td>
    	  <td><%=foodOrder.getTotalPrice() %></td>
    	  <td> <input type="radio" name="order_items" required="required" value="<%=foodOrder.getId()%> "></td>
    	  </tr> 
     <% }%> 
    	  
      </table> 
    
      <input type="submit" class="blue-button" name="menu_control" value="DeleteFoodProduct" >
     <input type="submit" class="blue-button" name="menu_control" value="UpdateFoodProduct" >
     <a class="blue-button" href="createmenu.jsp">ADD</a>
            </form>
        </div>
    </div>
		
  

</body>
</html>