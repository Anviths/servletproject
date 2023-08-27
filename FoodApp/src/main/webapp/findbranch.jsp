<%@page import="com.tyss.foodapp.dto.User"%>
<%@page import="com.tyss.foodapp.dto.Branch"%>
<%@page import="java.util.List"%>
<%@page
	import="com.tyss.foodapp.service.implementation.BranchServiceImplementation"%>
<%@page import="com.tyss.foodapp.service.BranchService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Branch view</title>
<link rel="stylesheet" href="css/admin.css">
<link rel="stylesheet" href="css/find.css">
</head>
<body>
<%
User useradmin=(User) request.getSession().getAttribute("userlogin");
request.getSession().setAttribute("userlogin",useradmin);
 %>
<!--  send to branchupdate class-->

<div class="navbar">
        <a href="admin.jsp" class="home-button">Home</a>
        <span class="user-profile"><%= useradmin.getName().toUpperCase() %></span>
        <a href="logout.jsp" class="logout-button"> Log-Out</a>
        
    </div>
 <form action="branchupdate">
     <table class="branch-table">
        <tr>
            <th>Branch Id</th>
            <th>Branch Name</th>
            <th>Branch Address</th>
            <th>Branch Phone</th>
            <th>Branch Email</th>
            <th>Select Branch</th>
            <th></th>
        </tr>
        
	<%
	 
	BranchService branchService = new BranchServiceImplementation();
	List<Branch> branches= branchService.getAllBranches();
	for(Branch branch:branches){
		
	%>
        <tr> 
            <td><%= branch.getId() %></td>
            <td><%= branch.getName() %></td>
            <td><%= branch.getAddress() %></td>
            <td><%= branch.getPhoneNumber() %></td>
            <td><%= branch.getEmail() %></td>
            <td> <input type="radio" name="update_value" value="<%= branch.getId() %>" required="required"> </td>
        </tr>
        <% } %>
    </table> <br><br>
    <input class="blue-button" type="submit" name="update" value="Update">	
    <input class="blue-button" type="submit" name="update" value="Delete">	
    
    <a class="blue-button" href="branchcreate.jsp">ADD</a>
</form>
	
</body>
</html>