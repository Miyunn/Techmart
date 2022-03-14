<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Drivers</title>
</head>
<body>

  <jsp:include page="navadmin.jsp" />


  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Drivers</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getDriver?action=all">All Drivers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="search-edit-driver.jsp">Search Driver</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-driver.jsp">Add Driver</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Driver To View / Edit Data</h4>
	
	<form action="getDriver">
		<label for="driverCode" class="form-label">Driver ID</label>
		<input id="driverCode" name="driverCode" class="form-control" type="text"/>
		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Driver Data</h4>
 
 <form class="row g-3" action="updateDriver" method="post">
	<div class="col-md-6">
		<label for="driverID" class="form-label"> Driver ID</label>
		<input id="driverID" type="number" name="driverID" class="form-control" value="${driver.getDriverID()}"/>
	</div>
	<div class="col-md-6">
		<label for="driverName" class="form-label"> First Name</label>
		<input type="text" id="fname" class="form-control" name="fname" value="${driver.getfName()}"/>
	</div>
	<div class="col-6">
		<label for="lname" class="form-label">Last Name</label>
		<input type="text" id="lname" class="form-control" name="lname" value="${driver.getlName()}"/>
	</div>
	<div class="col-md-6">
		<label for="branch" class="form-label">Branch</label>
		<input type="text" id="branch" class="form-control" name="branch" value="${driver.getBranch()}"/>
	</div>

	<div class="col-md-6">
		<label for="contact" class="form-label">Contact</label>
		<input type="text" id="contact" class="form-control" name="contact" value="${driver.getContact()}"/>
	</div>

	<div class="col-md-12">
		<label for="Image" class="form-label">Address</label>
  		<input type="text" id="address" class="form-control" name="address" value="${driver.getAddress()}"/>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Driver</button>
	</div>
  </form>

</body>
</html>