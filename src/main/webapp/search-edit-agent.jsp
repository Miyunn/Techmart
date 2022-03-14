<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Agents</title>
</head>
<body>

  <jsp:include page="navadmin.jsp" />


  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Agents</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getAgent?action=all">All Agents</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="search-edit-agent.jsp">Search Agent</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-agent.jsp">Add Agent</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Agent To View / Edit Data</h4>
	
	<form action="getAgent">
		<label for="agentCode" class="form-label">Agent ID</label>
		<input id="agentCode" name="agentCode" class="form-control" type="text"/>
		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Agent Data</h4>
 
 <form class="row g-3" action="updateAgent" method="post">
	<div class="col-md-6">
		<label for="agentID" class="form-label"> Agent ID</label>
		<input id="agentID" type="number" name="agentID" class="form-control" value="${agent.getAgentID()}"/>
	</div>
	<div class="col-md-6">
		<label for="agentName" class="form-label"> First Name</label>
		<input type="text" id="fname" class="form-control" name="fname" value="${agent.getfName()}"/>
	</div>
	<div class="col-6">
		<label for="lname" class="form-label">Last Name</label>
		<input type="text" id="lname" class="form-control" name="lname" value="${agent.getlName()}"/>
	</div>
	<div class="col-md-6">
		<label for="branch" class="form-label">Branch</label>
		<input type="text" id="branch" class="form-control" name="branch" value="${agent.getBranch()}"/>
	</div>

	<div class="col-md-6">
		<label for="Price" class="form-label">Email</label>
		<input type="email" id="email" class="form-control" name="email" value="${agent.getEmail()}"/>
	</div>

	<div class="col-md-6">
		<label for="contact" class="form-label">Contact</label>
		<input type="text" id="contact" class="form-control" name="contact" value="${agent.getContact()}"/>
	</div>

	<div class="col-md-6">
		<label for="Price" class="form-label">Password</label>
		<input type="password" id="password" class="form-control" name="password" value="${agent.getPassword()}"/>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Agent</button>
	</div>
  </form>
  

  
  
</body>
</html>