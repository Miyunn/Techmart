<%@page import="java.util.List"%>
<%@page import="com.code.techmart.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Products</title>
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
      <h2 class="text-center">Manage Products</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="getProduct?action=all">All Products</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-product.jsp">Search Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-product.jsp">Add Product</a>
        </li>
      </ul>
      
      <p>${message}</p>
      <p>${deleteMsg}</p>

      <div class="table-responsive">
        <table class="table" style="width:100%">
    
            <tr>
            <th>Product ID </th>
            <th>Brand name</th>
            <th>Product Name</th>
            <th>Product Type</th>
            <th>Price</th>
            <th>Image</th>
            <th>Action</th>
          </tr>
          

            <tag:forEach var="product" items="${productList}">
            <tr>
              <td>${product.getId()}</td>
              <td>${product.getName()}</td>
              <td>${product.getModel()}</td>
              <td>${product.getType()}</td>
              <td>${product.getPrice()}</td>
              <td>${product.getImage()}</td>
              <td>
                <form action="deleteProduct" method="post">
                  <input type="hidden" name="action" value="delete"/>
                  <input type="hidden" name="productID" value="${product.getId()}"/>
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