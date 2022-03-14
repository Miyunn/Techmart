<%@page import="java.util.List"%>
<%@page import="com.code.techmart.model.Agent"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Agents</title>
      <!-- Font Awesome -->
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
      <!-- Google Fonts Roboto -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
      <!-- MDB -->
      <link rel="stylesheet" href="styles/mdb.min.css" />
      <!-- Custom styles -->
      <link rel="stylesheet" href="../css/admin.css" />
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" integrity="sha512-d9xgZrVZpmmQlfonhQUvTR7lMPtO7NkZMkA0ABN3PHCbKA5nqylQ/yWlFAyY6hYgdF1Qh6nYiuADWwKB4C2WSw=="
        crossorigin="anonymous"></script>
    </head>
</head>
<body>

  <jsp:include page="navadmin.jsp" />


  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Agents</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="getAgent?action=all">All Agents</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-agent.jsp">Search Agent</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-agent.jsp">Add Agent</a>
        </li>
      </ul>
      
      <p>${message}</p>
      <p>${deleteMsg}</p>

      <div class="table-responsive">
        <table class="table" style="width:100%">
    
            <tr>
            <th>Agent ID </th>
            <th>First Name</th>
            <th>Last Model</th>
            <th>Contact</th>
            <th>Branch</th>
            <th>Email</th>
            <th>Action</th>
          </tr>
          

            <tag:forEach var="agent" items="${agentList}">
            <tr>
              <td>${agent.getAgentID()}</td>
              <td>${agent.getfName()}</td>
              <td>${agent.getlName()}</td>
              <td>${agent.getContact()}</td>
              <td>${agent.getBranch()}</td>
              <td>${agent.getEmail()}</td>
              <td>
                <form action="deleteAgent" method="post">
                  <input type="hidden" name="action" value="delete"/>
                  <input type="hidden" name="agentID" value="${agent.getAgentID()}"/>
                  <button type="submit" class="btn btn-danger">Delete</button>
                </form>
              
              </td>
            </tr>
            </tag:forEach>

   
        </table>
      </div>
    </div>
  </main>       
  <!--Main layout-->
  
  <!-- MDB -->
  <script type="text/javascript" src="../js/mdb.min.js"></script>
  <!-- Custom scripts -->
  <script type="text/javascript" src="../js/admin.js"></script>

</body>

</body>
</html>