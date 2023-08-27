<%@page import="com.tyss.foodapp.dto.FoodOrder"%>
<%@page import="com.tyss.foodapp.dto.FoodProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.service.implementation.FoodProductServiceImplementation"%>
<%@page import="com.tyss.foodapp.service.FoodProductService"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update food order</title>
<link rel="stylesheet" href="css/foodorder.css">
</head>
<body>
<%User userStaff=(User) request.getSession().getAttribute("userlogin");
  request.getSession().setAttribute("userlogin",userStaff);
  FoodOrder foodOrder=(FoodOrder) request.getSession().getAttribute("foodorder");
  request.getSession().setAttribute("foodorder",foodOrder);
   %>
   <div class="navbar">
        <a href="staff.jsp" class="home-button">Home</a>
       
        <span class="user-profile"><%= userStaff.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
	
      
   
      
   
  <div class="wrapper">
        <div class="inner">
            <form action="update-foodorder" class="food-order-form">
                <h3>Food Order</h3>
					
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" name="food_order_customer_name" class="form-control" placeholder="Customer Name">
					</div>
					
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="text" name="food_order_customer_phone" class="form-control" placeholder="Customer phone">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="text" name="food_order_customer_email" class="form-control" placeholder="Customer email">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<span class="lnr lnr-lock"></span>
						<select class="form-control" name="status" >
							<option class="form-control" value="" >Select 
							<option class="form-control" value="PENDING">PENDING
							<option class="form-control" value="ONTHEWAY">ONTHEWAY
							<option class="form-control" value="PREPARING">PREPARING
							<option class="form-control" value="DELIVERD">DELIVERD
							</select>
					</div>
					
					<table class="branch-table">
  <tr> 
  <th>ProductId</th>
  <th>ProductName</th>
  <th>ProductType</th>
  <th>ProductPrice</th>
  <th>Product Availability</th>
  <th>About</th>
  <th>quantity</th>
  <th>click to add</th>
  </tr>
  
   
   <% 
  FoodProductService foodProductService=new FoodProductServiceImplementation(); 
      List<FoodProduct> foodProducts=foodProductService.getFoodAllProducts();
      for(FoodProduct foodProduct:foodProducts) { %>
    	 <tr>
    	  <td><%=foodProduct.getId() %></td>
    	  <td><%=foodProduct.getName() %></td>
    	  <td><%=foodProduct.getType() %></td>
    	  <td><%=foodProduct.getPrice() %></td>
    	  <td><%=foodProduct.getAvailabilty() %></td>
    	  <td><%=foodProduct.getAbout() %></td>
    	  <td><input  type="number" name="item_quantity_<%= foodProduct.getId() %>"></td>
    	  <td> <input type="checkbox" name="order_items" value="<%=foodProduct.getId()%>"></td>
    	  </tr> 
     <% }%> 
    	  
      </table> 
    
     <button class="food-order-button">
                    <span>Place Order</span>
                </button>
            </form>
        </div>
    </div>
		
  

</body>
</html>