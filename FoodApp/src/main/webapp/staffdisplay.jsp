<%@page import="com.tyss.foodapp.service.implementation.MenuServiceImplemntation"%>
<%@page import="com.tyss.foodapp.dto.Menu"%>
<%@page import="com.tyss.foodapp.service.implementation.UserServiceImplementation"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff List</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/find.css">
</head>
<body>

	<%User userManager=(User) request.getSession().getAttribute("userlogin");
  request.getSession().setAttribute("userlogin",userManager);
  Menu menu=new MenuServiceImplemntation().getMenuServiceByUserId(userManager.getId());
   %>
<div class="navbar">
        <a href="branchmanger.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= userManager.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
	<form action="staffcontroller">
	<table class="branch-table">
  <tr> 
  <th>StaffId</th>
  <th>StaffName</th>
  <th>StaffEmail</th>
	  <th>Select</th>
	  
  </tr>
  
   
   <% 
     List<User> users= new UserServiceImplementation().getUserByRole("STAFF");
      for(User user:users) { %>
    	 <tr>
    	  <td><%=user.getId() %></td>
    	  <td><%=user.getName() %></td>
    	  <td><%=user.getEmail() %></td>
    	  <td> <input type="radio" name="user_id" value="<%=user.getId()%>" required="required"> </td>
    	  
    	  </tr> 
     <% }%> 
    	  
    
  </table>
     
     <input class="blue-button" type="submit" name="operation" value="Update">	
    <input class="blue-button" type="submit" name="operation" value="Delete">	
    
    <a class="blue-button" href="signup.jsp">ADD</a>
	</form>
</body>
</html>