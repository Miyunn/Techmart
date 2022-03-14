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
      <h2 class="text-center">Manage Drivers</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getDriver?action=all">All Drivers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-driver.jsp">Search Driver</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-driver.jsp">Add Driver</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addDriver" method="post">
  		<label for="fname" class="form-label">First Name</label>
  		<input type="text" id="fname" class="form-control" name="fname"/>

      <label for="lname" class="form-label">Last Name</label>
  		<input type="text" id="lname" class="form-control" name="lname"/>

      <label for="address" class="form-label">Addres</label>
  		<input type="text" id="address" class="form-control" name="address"/>

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
  		
		<button type="submit" class="btn btn-primary"> Add Driver</button>
		
  	</form>
  
  </div>
  
  
</body>
</html>