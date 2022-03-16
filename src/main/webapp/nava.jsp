<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="styles/main.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src='main.js'></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
          <a class="navbar-brand" href="agentHome.jsp">TechMart Agent</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
            
              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="agentLogout.jsp">View Products</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="agentLogout.jsp">Manage Inventory</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="agentLogout.jsp">View Sales</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="agentLogout.jsp">Manage Delivery</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" aria-current="page" href="logout.jsp">Logout()</a>
              </li>

              <li class="nav-item">
                <a class="nav-link" href="notifications.jsp">Notifications(0) </a>
              </li>
            </ul>
          </div>
        </div>
      </nav>
</body>
</html>