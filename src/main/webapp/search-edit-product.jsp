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
  
  <h2>Search A Product</h2>
  
  <form action="getProduct">
	  <label for="productCode">Product ID : </label>
	  <input id="productCode" name="productCode" type="text"/>
	  <input type="hidden" name="action" value="single"> 
	  <button type="submit">Search</button>
  </form>
  
 <br>
 
 <div class="containter">
 
 	<form action="updateProduct" method="post">
 		<label for="productID">Product ID : </label>
 		<input id="productID" type="number" name="productID" value="${product.getId()}"/>/>
 		
  		<label for="productName">Enter Product Name:</label>
  		<input type="text" id="productName" name="productName" value="${product.getName()}"/>
  		
  		<label for="productModel">Enter Product Model:</label>
  		<input type="text" id="productModel" name="productModel" value="${product.getModel()}"/>
  		
  		<label for="productType">Enter Product Type:</label>
  		<input type="text" id=productType" name="productType" value="${product.getType()}"/>

		<label for="productModel">Display:</label>
  		<input type="checkbox" id="productDisplay" name="productDisplay" value="${product.getDisplay()}"/>

		<label for="Price">Price(LKR):</label>
  		<input type="number" id="Price" name="Price" value="${product.getPrice()}"/>

		<label for="Image">Image URL:</label>
  		<input type="text" id="image" name="image" value="${product.getImage()}"/>
  		
		<input type="hidden" name="action" value="update"/>
		<button type="submit">Update Product</button>
 		
 	</form>
 </div>
  
  
  
</body>
</html>