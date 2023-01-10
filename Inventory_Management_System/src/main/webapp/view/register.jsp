<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Customer</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="js/register.js"></script>
<script src="js/bootstrap.min.js"></script>

<style>
<%@
include file ="/css/register.css"%>
</style>


</head>
<body>
	<div class="container">
		<center>
			<h1>Customer Registration </h1>
		</center>
		<div class="card">
			<div class="card-body">
				<form action="<%=request.getContextPath()%>/RegisterController"
					method="post">

					<div class="form-group row">
						<label for="firstName" class="col-sm-2 col-form-label">First
							Name</label>
						<div class="col-sm-7">
							<input type="text" name="firstName" class="form-control"
								name="firstName" placeholder="Enter first name">
						</div>
					</div>

					<div class="form-group row">
						<label for="lastName" class="col-sm-2 col-form-label">Last
							Name</label>
						<div class="col-sm-7">
							<input type="text" class="form-control"
								name="lastName" placeholder="Enter last name">
						</div>
					</div>
					
					<div class="form-group row">
						<label for="phoneNo" class="col-sm-2 col-form-label">Phone No</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="phoneNo"
								placeholder="Enter Contact Address">
						</div>
					</div>
					<div class="form-group row">
						<label for="address" class="col-sm-2 col-form-label">Address</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="address"
								placeholder="Enter Address">
						</div>
					</div>


					<div class="form-group row">
						<label for="username" class="col-sm-2 col-form-label">Username</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="username"
								placeholder="Enter user name">
						</div>
					</div>

					<div class="form-group row">
						<label for="password" class="col-sm-2 col-form-label">Password</label>
						<div class="col-sm-7">
							<input type="password" class="form-control" name="password"
								placeholder="Enter Password">
						</div>
					</div>
					<button type="submit"  id ="added"class="btn btn-primary" onclick="window.location='/view/Landing.jsp'" >Register Customer</button>
					<script>
					
					
					document.getElementById('added').onclick = function(){
					    alert('User Registered');
					}
					</script>
					
				</form>
			</div>
		</div>
	</div>
	<!-- /.container -->
</body>
</html>