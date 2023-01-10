<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory Management System</title>
<style><%@include file="/css/Landing.css"%></style>
</head>
<body>

<div class="container">
  <div class="circle-orange-small"></div>
  <div class="circle-blue"></div>
  <div class="circle-orange-big"></div>
  <div class="circle-center"></div>
  <div class="circle-center-text">
    <h1>Inventory Management System</h1>
    <hr><br>
    <p>Recording stocks has never been this easier!</p>
    <div class="cta">
     <button type="submit"  id ="added" onclick="window.location.href='<%= request.getContextPath() %>/view/Login.jsp'"/>Login</button>
     
    </div>
    <div class="cta">
      <button type="submit"  id ="added" onclick="window.location.href='<%= request.getContextPath() %>/view/register.jsp'"/>Register</button>
      <div class="btn"></div>
    </div>
  </div>
  <div class="circle-green"></div>
  <div class="circle-blue-small"></div>
</div>

</body>
</html>