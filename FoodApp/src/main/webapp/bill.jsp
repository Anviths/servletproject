<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="com.tyss.foodapp.dto.Item"%>
<%@page import="java.util.List"%>
<%@page import="com.tyss.foodapp.dto.FoodOrder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/find.css">
<link rel="stylesheet" href="css/foodorder.css">
</head>
 <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
<body>
  <%
  User userStaff=(User) request.getSession().getAttribute("userlogin");
  request.getSession().setAttribute("userlogin",userStaff);
  
  FoodOrder foodOrder=(FoodOrder) request.getSession().getAttribute("foodorder");
  request.getSession().setAttribute("foodorder",foodOrder);
     List<Item> items=(List<Item>) request.getSession().getAttribute("items");
  %>

 <div class="navbar">
        <a href="staff.jsp" class="home-button">Home</a>
       
        <span class="user-profile"><%= userStaff.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
    <h1>Bill </h1>
    <h3></h3>
<table>
       
        <tr>
            <th>Item id</th>
            <th>Item name</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total Price</th>
            
        </tr>
        <tr>
             
             <%for(Item item:items){ %>
            <td><%=item.getId() %></td>
            <td><%=item.getName() %></td>
            <td><%=item.getQuantity() %></td>
            <td><%=item.getPrice() %></td>
            <td><%=item.getPrice()*item.getQuantity() %></td>
        </tr>
        <%} %>
        <tr>
        <td colspan="4">total price</td>
        <td colspan="2"><%=foodOrder.getTotalPrice() %></td>
        </tr>
        <tr>
        <td colspan="4"></td>
        <td colspan="1"><a class="blue-button" href="staff.jsp">Place Order</a></td>
        </tr>
    
    </table>
</body>
</html>