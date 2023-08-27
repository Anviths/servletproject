<%@page import="com.tyss.foodapp.util.Role"%>
<%@page import="com.tyss.foodapp.dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta charset="utf-8">
		<title>RegistrationForm</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">

		
		<!-- STYLE CSS -->
		<link rel="stylesheet" href="css/signup.css">

</head>
<body>
<%User user=(User) request.getSession().getAttribute("userlogin");
  request.getSession().setAttribute("userlogin",user);
 
   %>
    <div class="wrapper">
			<div class="inner">
				
				<form action="sign-up">
					<h3>New Account?</h3>
					<div class="form-holder">
						<span class="lnr lnr-user"></span>
						<input type="text" name="user_name" class="form-control" placeholder="Username">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-phone-handset"></span>
						<input type="text" class="form-control" placeholder="Phone Number">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" name="user_email"class="form-control" placeholder="Mail">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" name="user_password" class="form-control" placeholder="Password">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<span class="lnr lnr-lock"></span>
						<select class="form-control" name="user_role">
							<option class="form-control"  >Select role
							<option class="form-control" value="BRANCHMANAGER" >BranchManager
							<option class="form-control" value="STAFF">staff
							<option class="form-control" value="CUSTOMER">customer
							</select>
					</div>
					<button>
						<span>Register</span>
					</button>
					
					<p class="text-center">Already  user? <a data-toggle="tab" href="login.jsp">Log-In</a></p>
					
				</form>
				
			
		</div>
</body>
</html>