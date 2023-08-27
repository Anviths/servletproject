<%@page import="com.tyss.foodapp.service.implementation.FoodProductServiceImplementation"%>
<%@page import="com.tyss.foodapp.service.FoodProductService"%>
<%@page import="com.tyss.foodapp.dto.Menu"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tyss.foodapp.dto.FoodProduct"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.service.MenuService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.tyss.foodapp.service.implementation.MenuServiceImplemntation"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/find.css">
</head>
<body>


	
	 <%User userManager=(User) request.getSession().getAttribute("userlogin");
  request.getSession().setAttribute("userlogin",userManager);
  Menu menu=new MenuServiceImplemntation().getMenuServiceByUserId(userManager.getId());
  request.getSession().setAttribute("menu", menu);
   %>
	<div class="navbar">
        <a href="branchmanger.jsp" class="home-button">Home</a>
        <span  class="user-profile"> Menu-Id:<%= menu.getId() %></span>
        <span class="user-profile"><%= userManager.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
	<form action="menu-controller">
	 <table class="branch-table">
  <tr> 
  <th>ProductId</th>
  <th>ProductName</th>
  <th>ProductType</th>
  <th>ProductPrice</th>
  <th>Product Availability</th>
  <th>About</th>
  <th>click to add</th>
  </tr>
  
   
   <% 
   
      List<FoodProduct> foodProducts=new FoodProductServiceImplementation().getFoodProductByMenuId(menu.getId());
      for(FoodProduct foodProduct:foodProducts) { %>
    	 <tr>
    	  <td><%=foodProduct.getId() %></td>
    	  <td><%=foodProduct.getName() %></td>
    	  <td><%=foodProduct.getType() %></td>
    	  <td><%=foodProduct.getPrice() %></td>
    	  <td><%=foodProduct.getAvailabilty() %></td>
    	  <td><%=foodProduct.getAbout() %></td>
    	  <td> <input type="radio" name="items" value="<%=foodProduct.getId()%>" required="required"></td>
    	  </tr> 
     <% }%> 
    	  
    
  </table>
    
     <input type="submit" class="blue-button" name="menu_control" value="DeleteFoodProduct" >
     <input type="submit" class="blue-button" name="menu_control" value="UpdateFoodProduct" >
     <a class="blue-button" href="createmenu.jsp">ADD</a>
     </form>
</body>
</html>