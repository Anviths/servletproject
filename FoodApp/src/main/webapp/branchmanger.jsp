<%@page import="com.tyss.foodapp.service.implementation.MenuServiceImplemntation"%>
<%@page import="com.tyss.foodapp.dto.Menu"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch Manger page</title>
<link rel="stylesheet" href="css/admin.css">
</head>
<body>
<%User userManager=(User) request.getSession().getAttribute("user");
  request.getSession().setAttribute("userlogin",userManager);
  Menu menu=new MenuServiceImplemntation().getMenuServiceByUserId(userManager.getId());
  request.getSession().setAttribute("menu", menu);
   %>
   <div class="navbar">
        <a href="branchmanger.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= userManager.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
      </div> 
<div class="wrapper">
    <div class="inner">
        <button>
            <span><a href="signup.jsp">Create staff</a></span>
        </button>
        <%if(menu==null){ %>
        <button>
            <span><a href="createmenu.jsp">Create menu</a></span>
        </button>
        <%} else{
		 request.getSession().setAttribute("menu", menu);
		}%>
        <button>
            <span><a href="staffdisplay.jsp">Display staff</a></span>
        </button>
        <button>
            <span><a href="menu.jsp">View Menu</a></span>
        </button>
    </div>
</div>
</body>
</html>