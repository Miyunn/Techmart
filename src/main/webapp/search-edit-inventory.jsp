<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Inventory</title>
</head>
<body>

  <jsp:include page="navadmin.jsp" />


  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Inventory</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getInventory?action=all">All Inventorys</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="search-edit-inventory.jsp">Search Inventory</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-inventory.jsp">Add Inventory</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Inventory To View / Edit Data</h4>
	
	<form action="getInventory">
		<label for="inventoryCode" class="form-label">Branch</label>
		<input id="branch" name="branch" class="form-control" type="text"/>

		<label for="inventoryCode" class="form-label">Item ID</label>
		<input id="itemID" name="itemID" class="form-control" type="number"/>

		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Inventory Data</h4>
 
 <form class="row g-3" action="updateInventory" method="post">
	<div class="col-md-6">
		<label for="inventoryID" class="form-label">Branch</label>
		<input id="inventoryID" type="text" name="branch" class="form-control" value="${inventory.getBranchName()}"/>
	</div>

	<div class="col-md-6">
		<label for="inventoryName" class="form-label"> Item ID</label>
		<input type="number" id="model" class="form-control" name="model" value="${inventory.getModel()}"/>
	</div>

	<div class="col-md-6">
		<label for="branch" class="form-label">Quantity</label>
		<input type="number" id="branch" class="form-control" name="branch" value="${inventory.getQuanity()}"/>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Inventory</button>
	</div>
  </form>

</body>
</html>