<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Suppliers</title>
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
          <a class="nav-link active" href="search-edit-supplier.jsp">Search Supplier</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-supplier.jsp">Add Supplier</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Supplier To View / Edit Data</h4>
	
	<form action="getSupplier">
		<label for="supplierCode" class="form-label">Supplier ID</label>
		<input id="supplierCode" name="supplierCode" class="form-control" type="text"/>
		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Supplier Data</h4>
 
 <form class="row g-3" action="updateSupplier" method="post">
	<div class="col-md-6">
		<label for="supplierID" class="form-label"> Supplier ID</label>
		<input id="supplierID" type="number" name="supplierID" class="form-control" value="${supplier.getSupplierID()}"/>
	</div>
	<div class="col-md-6">
		<label for="supplierName" class="form-label"> First Name</label>
		<input type="text" id="fname" class="form-control" name="fname" value="${supplier.getfName()}"/>
	</div>
	<div class="col-6">
		<label for="lname" class="form-label">Last Name</label>
		<input type="text" id="lname" class="form-control" name="lname" value="${supplier.getlName()}"/>
	</div>
	<div class="col-md-6">
		<label for="branch" class="form-label">Branch</label>
		<input type="text" id="branch" class="form-control" name="branch" value="${supplier.getBranch()}"/>
	</div>

	<div class="col-md-6">
		<label for="Price" class="form-label">Email</label>
		<input type="email" id="email" class="form-control" name="email" value="${supplier.getEmail()}"/>
	</div>

	<div class="col-md-6">
		<label for="contact" class="form-label">Contact</label>
		<input type="text" id="contact" class="form-control" name="contact" value="${supplier.getContact()}"/>
	</div>

	<div class="col-md-6">
		<label for="Price" class="form-label">Password</label>
		<input type="password" id="password" class="form-control" name="password" value="${supplier.getPassword()}"/>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Supplier</button>
	</div>
  </form>
  

  
  
</body>
</html>