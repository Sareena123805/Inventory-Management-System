<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="model.Stock" %>
<%@page import="controller.ViewStockController" %>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Inventory Management system</title>
    <style><%@include file="/css/light.css"%></style>
    <style><%@include file="/css/style.css"%></style>
    <style >
    @charset "UTF-8";
	.order-form{
    padding-top: 100px;
}
.order-design{
    padding: 1rem;

}
#Customer_ID{
width: 100px;
}
#quantity{
    width: 100px;
}

table{
	
    padding: 1rem;
    width: 100%;
}
th{
    text-align: left;
    background: rgb(14,12,12);
    color: white;
    padding: .5rem;
}
td{
	border:none;
    text-align: left;
    padding: .5rem;
    
    </style>
    
  
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
    
    <table>
  <thead>
  <tr>
  
  <th> Product Quantity </th>
   <th> Product Price </th> 
   <th> ID </th>
  
  
  </tr>
  </thead>
 <tbody>
 <%
 int i=1;
 List<Stock>lstCustomer = (List<Stock>) request.getAttribute("lstStock");
 %>
 
 <%
 if(lstCustomer!=null){
   for(Stock cust : lstCustomer){
     %>
     <tr>
     <td><%= cust.getS_ProductQTY() %></td>
     <td><%= cust.getS_Price() %></td>
     <td><%= cust.getS_ID() %></td>
     </tr>
     <%
   }
 }else{
   out.print("No data found");
 }
     %>
  

</tbody>
</table>
    
    
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