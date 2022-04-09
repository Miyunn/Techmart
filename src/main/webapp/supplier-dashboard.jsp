<%@page import="java.util.List"%>
<%@page import="com.code.techmart.model.Restock"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechMart Supplier</title>
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
<body>

  <jsp:include page="navsup.jsp" />

  
  <%
  String user = null;
  if(session.getAttribute("sessionusername") == null){
    response.sendRedirect("supplier-login.jsp");
    
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


  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Stock Resupply</h2>
   

      <div style="margin-top: 58px">
        <div class="container pt-4">
          <section>
            <div class="row">
              <div class="col-xl-6 col-md-12 mb-4">
                <div class="card">
                  <div class="card-body">
                    <div class="d-flex justify-content-between p-md-1">
                      <div class="d-flex flex-row">
                        <div class="align-self-center">
                          <h2 class="h1 mb-0 me-4">Last Update</h2>
                        </div>
                        <div>
                          <h4></h4>
                          <p class="mb-0"><%= (new java.util.Date()).toLocaleString()%></p>
                        </div>
                      </div>
                      <div class="align-self-center">
                        <i class="fa fa-calendar fa-3x"></i>
                      </div>
                    </div>
                  </div>
                </div>
              </div>  
        </div>
      </div>

         
      <form action="getRestock">
        <input id="supplierID" name="supplierID" class="form-control" type="hidden" value="${sessionScope.sessionUserID}"/>
    
        <input type="hidden" name="action" value="byID"> <br>
        <button type="submit" class="btn btn-primary">Load Requests</button>
      </form>

      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="getRestock?action=supplier">All Restock Requests</a>
        </li>
      </ul>
      
      <p>${message}</p>
      <p>${deleteMsg}</p>

      <div class="table-responsive">
        <table class="table" style="width:100%">
    
            <tr>
            <th>Request ID </th>
            <th>Branch</th>
            <th>Product ID</th>
            <th>Quantity</th>
            <th>Status</th>
            <th></th>
            <th></th>
          </tr>
          

            <tag:forEach var="restock" items="${restockList}">
            <tr>
              <td>${restock.getId()}</td>
              <td>${restock.getBranch()}</td>
              <td>${restock.getProductID()}</td>
              <td>${restock.getQuantity()}</td>
              <td>${restock.getStatus()}</td>
              <td>

                <form action="acceptRestock" method="post">
                  <input type="hidden" name="action" value="accept"/>
                  <input type="hidden" name="restockID" value="${restock.getId()}"/>
                  <button type="submit" class="btn btn-warning">Confirm</button>
                </form>
              </td>

              <td>
                <form action="declineRestock" method="post">
                  <input type="hidden" name="action" value="reject"/>
                  <input type="hidden" name="restockID" value="${restock.getId()}"/>
                  <button type="submit" class="btn btn-danger">Reject</button>
                </form>
              </td>
        
            </tr>
            </tag:forEach>
        </table>
      </div>
    </div>

</main>

</body>
</html>
</body>
</html>