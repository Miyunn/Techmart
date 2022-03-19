<%@page import="java.util.List"%>
<%@page import="com.code.techmart.model.Transaction"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Transactions</title>
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
      <h2 class="text-center">Manage Transactions</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="getTransaction?action=all">All Transactions</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-transaction.jsp">Search Transaction</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-transaction.jsp">Add Transaction</a>
        </li>
      </ul>
      
      <p>${message}</p>
      <p>${deleteMsg}</p>

      <div class="table-responsive">
        <table class="table" style="width:100%">
    
            <tr>
            <th>Transaction ID </th>
            <th>Customer ID</th>
            <th>Product ID</th>
            <th>Branch</th>
            <th>Quantity</th>
            <th>Unit Price</th>
            <th>Total</th>
            <th>Status</th>
            <th>Action</th>
          </tr>
          

            <tag:forEach var="transaction" items="${transactionList}">
            <tr>
              <td>${transaction.getTransactionID()}</td>
              <td>${transaction.getCustomerID()}</td>
              <td>${transaction.getProductID()}</td>
              <td>${transaction.getBranch()}</td>
              <td>${transaction.getQuantity()}</td>
              <td>${transaction.getUnitprice()}</td>
              <td>${transaction.getTotal()}</td>
              <td>${transaction.getStatus()}</td>
              <td>
                <form action="deleteTransaction" method="post">
                  <input type="hidden" name="action" value="delete"/>
                  <input type="hidden" name="transactionID" value="${transaction.getTransactionID()}"/>
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