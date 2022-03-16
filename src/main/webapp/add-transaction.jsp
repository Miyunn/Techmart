<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart- Admin</title>
</head>
<body>

  <%
  String user = null;
  if(session.getAttribute("sessionusername") == null){
    response.sendRedirect("admin-login.jsp");
    
  }
  else user = (String) session.getAttribute("sessionusername");
  
  String userName = null;
  String sessionID = null;
  Cookie[] cookies = request.getCookies();
  if(cookies !=null){
  for(Cookie cookie : cookies){
    if(cookie.getName().equals("sessionusername")) userName = cookie.getValue();
    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
  }
  }
  %>
  
  <jsp:include page="navadmin.jsp" />

  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Transactions</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getTransaction?action=all">All Transactions</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-transaction.jsp">Search Transaction</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-transaction.jsp">Add Transaction</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addTransaction" method="post">
  		<label for="fname" class="form-label">Customer ID</label>
  		<input type="number" id="fname" class="form-control" name="customerID"/>

      <label for="lname" class="form-label">Product ID</label>
  		<input type="number" id="lname" class="form-control" name="productID"/>

      <label for="contact" class="form-label">Quantity</label>
  		<input type="number" id="contact" class="form-control" name="quantity"/>
      
      <label for="branch" class="form-label">Select Branch</label>
      <select name="branch" id="branch" class="form-control">
         <option value="Colombo">Colombo</option>
         <option value="Galle">Galle</option>
         <option value="Kandy">Kandy</option>
         <option value="Nugegoda">Nugegoda</option>
         <option value="Gampaha">Gampaha</option>
         <option value="Kurunegala">Kurunegala</option>
         <option value="Jaffna">Jaffna</option>
       </select>

       <label for="contact" class="form-label">Unit Price</label>
       <input type="number" id="contact" class="form-control" name="unitprice"/> 

       <label for="contact" class="form-label">Status</label>
       <input type="text" id="contact" class="form-control" name="status"/> 


  		<input type="hidden" name="action" value="add"/> <br>
  		
		<button type="submit" class="btn btn-primary"> Add Transaction to the System</button>
		
  	</form>
  
  </div>
  
  
</body>
</html>