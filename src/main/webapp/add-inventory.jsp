<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <jsp:include page="navadmin.jsp" />

  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Inventory</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getInventory?action=all">All Inventory</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-driver.jsp">Search Inventory</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-driver.jsp">Add Inventory</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addInventory" method="post">

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

      <label for="lname" class="form-label">Item ID</label>
  		<input type="text" id="itemID" class="form-control" name="itemID"/>

      <label for="lname" class="form-label">Quantity</label>
  		<input type="text" id="quantity" class="form-control" name="quantity"/>

  		<input type="hidden" name="action" value="add"/> <br>
  		
		<button type="submit" class="btn btn-primary"> Add Inventory</button>
		
  	</form>
  
  </div>
  
  
</body>
</html>