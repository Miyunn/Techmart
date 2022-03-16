<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechMart - Admin</title>
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
      <h2 class="text-center">Manage Agents</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getAgent?action=all">All Agents</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-agent.jsp">Search Agent</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-agent.jsp">Add Agent</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addAgent" method="post">
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

		<button type="submit" class="btn btn-primary"> Add Agent</button>
		
  	</form>
  
  </div>
  
  
</body>
</html>