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
      <h2 class="text-center">Manage Products</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link" aria-current="page" href="getProduct?action=all">All Products</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="search-edit-product.jsp">Search Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="add-product.jsp">Add Product</a>
        </li>
      </ul>
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addProduct" method="post">
  		<label for="productName" class="form-label">Enter Product Name:</label>
  		<input type="text" id="productName" class="form-control" name="productName"/>
  		
  		<input type="hidden" name="action" value="add"/>
  		
  		<label for="productModel" class="form-label">Enter Product Model:</label>
  		<input type="text" id="productModel" class="form-control" name="productModel"/>
  		
  		<label for="productType" class="form-label">Enter Product Type:</label>
  		<input type="text" id=productType" class="form-control" name="productType"/>

		<label for="productModel" class="form-label">Display:</label>
  		<input type="checkbox" id="productDisplay" name="productDisplay"/>

		<label for="Price" class="form-label">Price(LKR):</label>
  		<input type="number" id="Price"  class="form-control"name="Price"/>

		<label for="Image" class="form-label">Image URL:</label>
  		<input type="text" id="image" class="form-control" name="image"/> <br> 

		<button type="submit" class="btn btn-primary"> Add Product</button> 
		
  	</form>
  
  </div>
  
  
</body>
</html>