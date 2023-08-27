<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Staff Page</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>

	
  <%User userStaff=(User) request.getSession().getAttribute("user");
  request.getSession().setAttribute("userlogin",userStaff);

   %>
   <div class="navbar">
        <a href="staff.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= userStaff.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
      </div> 
<div class="wrapper">
    <div class="inner">
        <button>
            <span><a href="foodorder.jsp">Order food</a></span>
        </button>
        
        <button>
            <span><a href="findfoodorder.jsp">View FoodOrder</a></span>
        </button>
        <!-- <button>
            <span><a href="menu.jsp">View FoodOrder</a></span>
        </button> -->
    </div>
</div>
</body>
</html>