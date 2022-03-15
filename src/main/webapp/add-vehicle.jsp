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
      <h2 class="text-center">Manage Vehicles</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getVehicle?action=all">All Vehicles</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-vehicle.jsp">Search Vehicle</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-vehicle.jsp">Add Vehicle</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addVehicle" method="post">
  		<label for="fname" class="form-label">Vehicle License Number</label>
  		<input type="text" id="fname" class="form-control" name="vehicleID"/>

      <label for="lname" class="form-label">Model</label>
  		<input type="text" id="lname" class="form-control" name="model"/>
      
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

  		<input type="hidden" name="action" value="add"/> <br>
  		
		<button type="submit" class="btn btn-primary"> Add Vehicle</button>
		
  	</form>
  
  </div>
  
</body>
</html>