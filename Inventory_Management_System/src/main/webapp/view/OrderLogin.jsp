<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
     <style><%@include file="/css/index.css"%></style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inventory Management</title>
   
</head>
<body>
  <H1 class="hello">Inventory Management</H1>
  <input type="hidden" id="status" value="<%=request.getAttribute("status") %>"/>
	<div class="login">
		<form action="<%=request.getContextPath()%>/ViewOrderController"
			method="post" class="form">
        <h2>Login Page</h2>
			<div class="input-group">
				<input type="text" name="loginUser" id="loginUser" required /> <label
					for="loginUser">User Name</label>
			</div>
			<br><br>
			<div class="input-group">
				<input type="password" name="loginPassword" id="loginPassword"
					required /> <label for="loginPassword">Password</label>
			</div>
			<br><br>
			<input type="submit" value="Login" class="submit-btn" />
			<!-- <input type="submit" value="Register" class="submit-btn" onclick="goToRegisterPage()"/> -->
			<input type="submit" value="Register" class="submit-btn" onclick="window.location.href='<%= request.getContextPath() %>/view/register.jsp'"/>
			<br><br>
        <input type="checkbox" id="check">    
        <span>Remember me</span> 
        <a href="#"> Forgot Password</a>   
        <br><br>    
        
        <br>
    </form>     
</div>    
        
 
    
</body>
<script src="js/jquery-3.6.1.min.js"></script>
<script src="js/main.js"></script>
<script type="text/javascript">
	var status = document.getElementById("status").value;
	if(status=="failed"){
		 alert("Either username or password is incorrect !!");
	}
</script>

<script>
	function goToRegisterPage(){
		window.location = "register.jsp";
	 }
</script>
</html>