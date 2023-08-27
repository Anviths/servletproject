<%@page import="com.tyss.foodapp.dto.Menu"%>
<%@page import="com.tyss.foodapp.dto.User"%>
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
HttpSession httpSession= request.getSession();

User user=(User)httpSession.getAttribute("user");
request.getSession().setAttribute("userManager", user);

 %>
 <!--food product controller  -->
<form action="foodproduct">
FoodName :<input type="text" name="food_product_name"> <br><br>
Price :<input type="text" name="food_product_price"> <br><br><br>
About :<input type="text" name="food_product_about"> <br><br><br>
Food Type <select name="food_product_type">
     <option value="VEG" >Veg
     <option value="NONVEG" >Non-Veg
  
     </select> <br><br><br>
Availability <select name="food_product1_available">
     <option value="AVAILABILE" >AVAILABLE
     <option value="NOTAVAILABLE" >NOTAVAILABLE
  
     </select> <br><br><br>
     <input type="submit" value="Submit">
     </form>
</body>
</html>