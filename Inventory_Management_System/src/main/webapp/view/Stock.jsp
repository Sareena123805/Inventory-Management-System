<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Stock" %>
<%@page import="controller.StockController" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Inventory Management system</title>
    <style><%@include file="/css/light.css"%></style>
    <style><%@include file="/css/style.css"%></style>
    
    
  
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bxl-c-plus-plus'></i>
      <span class="logo_name">Inventory</span>
    </div>
      <ul class="nav-links">
        <li>
          <a href="#" class="active">
           
            <span class="links_name">Dashboard</span>
          </a>
        </li>
         <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/Sales.jsp'">
           
            <span class="links_name">Sales </span>
          </a>
        </li>
        <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/SalesLogin.jsp'">
        
            <span class="links_name">Sales view</span>
          </a>
        </li>
        <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/Orders.jsp'">
        
            <span class="links_name">Order </span>
          </a>
        </li>
        <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/OrderLogin.jsp'">
         
            <span class="links_name">Order View</span>
          </a>
        </li>
  
        <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/Supplier.jsp'">
           
            <span class="links_name">Supplier</span>
          </a>
        </li>
        <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/SupplierLogin.jsp'">
           
            <span class="links_name">Supplier View</span>
          </a>
        </li>
        <li>
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/Stock.jsp'">
          
            <span class="links_name">Stock</span>
          </a>
        </li>
        
   
       <li >
          <a href="#" onclick="window.location.href='<%= request.getContextPath() %>/view/StockLogin.jsp'">
            
            <span class="links_name">Stock View</span>
          </a>
        </li>
      </ul>
  </div>
    <section class="home-section">
    
    <h1 align="center">Store</h1>
    <div class="form"></div>
    <form action="<%=request.getContextPath()%>/StockController"
			method="post" class="form">
        <table>
        <tr> <td> Product Quantity</td><td> <input type="Number" name=s_ProductQTY></td></tr>
        <tr> <td> Price</td><td> <input type="Price" name=s_Price></td></tr>
        <tr> <td> Supplier ID</td><td> <input type="Number" name=s_ID></td></tr>
         <tr> <td> Store Product Name</td><td> <input type="Name" name=s_ProductName></td></tr>
         <tr> <td> Store Product ID</td><td> <input type="Number" name=s_ProductID></td></tr>
        <tr> <td> <input type="submit" id="Stock"value="Add" onclick="window.location.href='<%= request.getContextPath() %>/view/Dashboard.jsp'"/>
        <!-- </td><td> <input type=""></td></tr> -->
        </table>
      
          </form>
          
          </div>
    
        <button class="btns"onclick="window.location.href='<%= request.getContextPath() %>/view/StockLogin.jsp'"/>View <span class="tooltiptext"></span></button>
    
    
    
    </section>
 

  <script>
   let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".sidebarBtn");
sidebarBtn.onclick = function() {
  sidebar.classList.toggle("active");
  if(sidebar.classList.contains("active")){
  sidebarBtn.classList.replace("bx-menu" ,"bx-menu-alt-right");
}else
  sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
}
 </script>
 <script src="/js/clock.js"></script>
 <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
 <script src="/js/light.js"></script>
</body>
</html>