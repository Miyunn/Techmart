<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Vehicles</title>
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
      <h2 class="text-center">Manage Vehicles</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getVehicle?action=all">All Vehicles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="search-edit-vehicle.jsp">Search Vehicle</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-vehicle.jsp">Add Vehicle</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Vehicle To View / Edit Data</h4>
	
	<form action="getVehicle">
		<label for="vehicleCode" class="form-label">Vehicle License Number</label>
		<input id="vehicleCode" name="vehicleCode" class="form-control" type="text"/>
		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Vehicle Data</h4>
 
 <form class="row g-3" action="updateVehicle" method="post">
	<div class="col-md-6">
		<label for="vehicleID" class="form-label"> Vehicle License Number</label>
		<input id="vehicleID" type="text" name="vehicleID" class="form-control" value="${vehicle.getVehicleLicenseNo()}"/>
	</div>

	<div class="col-md-6">
		<label for="vehicleName" class="form-label"> Model</label>
		<input type="text" id="model" class="form-control" name="model" value="${vehicle.getModel()}"/>
	</div>

	<div class="col-md-6">
		<label for="branch" class="form-label">Branch</label>
		<input type="text" id="branch" class="form-control" name="branch" value="${vehicle.getBranch()}"/>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Vehicle</button>
	</div>
  </form>

</body>
</html>