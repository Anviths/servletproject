<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
  	<title>Login </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<link href="https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap" rel="stylesheet">

	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	
	<link rel="stylesheet" href="css/login.css">

	</head>
	<body>
	<div class="wrapper">
			<div class="inner">
				
				<form action="login">
					<h3>Login Account</h3>
					
					
					<div class="form-holder">
						<span class="lnr lnr-envelope"></span>
						<input type="text" name="user_email"class="form-control" placeholder="User Id">
					</div>
					<div class="form-holder">
						<span class="lnr lnr-lock"></span>
						<input type="password" name="user_password" class="form-control" placeholder="Password">
					</div>
					
					<button>
						<span>Log-In</span>
					</button>
				<p class="text-center">Not a user? <a data-toggle="tab" href="signup.jsp">Sign Up</a></p>
				</form>
			
		</div>
		</div>

	

	</body>
</html>

