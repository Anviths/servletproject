<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/admin.css">
<title>Admin page</title>
</head>
<body>
  <%User useradmin=(User) request.getSession().getAttribute("user");
  request.getSession().setAttribute("useradmin",useradmin);
   %>


 <div class="navbar">
        <a href="admin.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= useradmin.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>

<div class="wrapper">
    <div class="inner">
        <button>
            <span><a href="branchcreate.jsp">Create Branch</a></span>
        </button>
        <button>
            <span><a href="findbranch.jsp">View Branch</a></span>
        </button>
        <button>
            <span><a href="viewuser.jsp">View User</a></span>
        </button>
    </div>
</div>

</body>
</html>