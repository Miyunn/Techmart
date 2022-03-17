<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Customers</title>
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
      <h2 class="text-center">Manage Customers</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getCustomer?action=all">All Customers</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="search-edit-customer.jsp">Search Customer</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-customer.jsp">Add Customer</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Customer To View / Edit Data</h4>
	
	<form action="getCustomer">
		<label for="customerCode" class="form-label">Customer ID</label>
		<input id="customerCode" name="customerCode" class="form-control" type="text"/>
		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Customer Data</h4>
 
 <form class="row g-3" action="updateCustomer" method="post">
	<div class="col-md-6">
		<label for="customerID" class="form-label"> Customer ID</label>
		<input id="customerID" type="number" name="customerID" class="form-control" value="${customer.getCustomerID()}"/>
	</div>
	<div class="col-md-6">
		<label for="customerName" class="form-label"> First Name</label>
		<input type="text" id="fname" class="form-control" name="fname" value="${customer.getfName()}"/>
	</div>
	<div class="col-6">
		<label for="lname" class="form-label">Last Name</label>
		<input type="text" id="lname" class="form-control" name="lname" value="${customer.getlName()}"/>
	</div>
	<div class="col-md-6">
		<label for="branch" class="form-label">Branch</label>
		<input type="text" id="branch" class="form-control" name="branch" value="${customer.getBranch()}"/>
	</div>

	<div class="col-md-6">
		<label for="Price" class="form-label">Email</label>
		<input type="email" id="email" class="form-control" name="email" value="${customer.getEmail()}"/>
	</div>

	<div class="col-md-6">
		<label for="contact" class="form-label">Contact</label>
		<input type="text" id="contact" class="form-control" name="contact" value="${customer.getContact()}"/>
	</div>

	<div class="col-md-6">
		<label for="Price" class="form-label">Password</label>
		<input type="password" id="password" class="form-control" name="password" value="${customer.getPassword()}"/>
	</div>

	<div class="col-md-12">
		<label for="Image" class="form-label">Address</label>
  		<input type="text" id="address" class="form-control" name="address" value="${customer.getAddress()}"/>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Customer</button>
	</div>
  </form>
  
</body>
</html>