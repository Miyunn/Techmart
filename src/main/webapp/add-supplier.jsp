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
      <h2 class="text-center">Manage Suppliers</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getSupplier?action=all">All Suppliers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-supplier.jsp">Search Supplier</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-supplier.jsp">Add Supplier</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addSupplier" method="post">
  		<label for="fname" class="form-label">First Name</label>
  		<input type="text" id="fname" class="form-control" name="fname"/>

      <label for="lname" class="form-label">Last Name</label>
  		<input type="text" id="lname" class="form-control" name="lname"/>

      <label for="contact" class="form-label">Contact</label>
  		<input type="text" id="contact" class="form-control" name="contact"/>
      
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

  		<input type="hidden" name="action" value="add"/>
  		
      <label for="email" class="form-label">Email</label>
  		<input type="email" id="email" class="form-control" name="email"/>
  		
  		<label for="password" class="form-label">Password</label>
  		<input type="password" id=password" class="form-control" name="password"/> <br>

		<button type="submit" class="btn btn-primary"> Add Supplier</button>
		
  	</form>
  
  </div>
  
  
</body>
</html>