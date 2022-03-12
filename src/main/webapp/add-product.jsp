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
  
  <p>${message}</p>
  
  <div class="container">
  	<form action = "addProduct" method="post">
  		<label for="productName">Enter Product Name:</label>
  		<input type="text" id="productName" name="productName"/>
  		
  		<input type="hidden" name="action" value="add"/>
  		
  		<label for="productModel">Enter Product Model:</label>
  		<input type="text" id="productModel" name="productModel"/>
  		
  		<label for="productType">Enter Product Type:</label>
  		<input type="text" id=productType" name="productType"/>

		<label for="productModel">Display:</label>
  		<input type="checkbox" id="productDisplay" name="productDisplay"/>

		<label for="Price">Price(LKR):</label>
  		<input type="number" id="Price" name="Price"/>

		<label for="Image">Image URL:</label>
  		<input type="text" id="image" name="image"/>

		<button type="submit"> Add Product</button>
		
  	</form>
  
  </div>
  
  
</body>
</html>