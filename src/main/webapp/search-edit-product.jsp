<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Techmart - Manage Products</title>
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
          <a class="nav-link" aria-current="page" href="getProduct?action=all">All Products</a>
        </li>
        <li class="nav-item">
          <a class="nav-link active" href="search-product.jsp">Search Product</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="add-product.jsp">Add Product</a>
        </li>
      </ul>
  
	<p>${message}</p>
	
	<h4 style="text-align: left;"> Enter Product To View / Edit Data</h4>
	
	<form action="getProduct">
		<label for="productCode" class="form-label">Product ID</label>
		<input id="productCode" name="productCode" class="form-control" type="text"/>
		<input type="hidden" name="action" value="single" > <br>
		<button type="submit" class="btn btn-primary">Search</button>
	</form>

	<br>
	<hr>
	<br>

	<h4 style="text-align: left;">Edit Product Data</h4>
 
 <form class="row g-3" action="updateProduct" method="post">
	<div class="col-md-6">
		<label for="productID" class="form-label"> Product ID</label>
		<input id="productID" type="number" name="productID" class="form-control" value="${product.getId()}"/>
	</div>
	<div class="col-md-6">
		<label for="productName" class="form-label">Enter Product Name</label>
		<input type="text" id="productName" class="form-control" name="productName" value="${product.getName()}"/>
	</div>
	<div class="col-6">
		<label for="productModel" class="form-label">Enter Product Model</label>
		<input type="text" id="productModel" class="form-control" name="productModel" value="${product.getModel()}"/>
	</div>
	<div class="col-6">
		<label for="productType" class="form-label">Enter Product Type</label>
  		<input type="text" id=productType" class="form-control" name="productType" value="${product.getType()}"/>
	</div>
	<div class="col-md-2">
		<label for="Price" class="form-label">Price(LKR)</label>
		<input type="number" id="Price" class="form-control" name="Price" value="${product.getPrice()}"/>
	</div>
	<div class="col-md-10">
		<label for="Image" class="form-label">Image URL</label>
  		<input type="text" id="image" class="form-control" name="image" value="${product.getImage()}"/>
	</div>

	<div class="col-12">
	  <div class="form-check">
		<input class="form-check-input" type="hidden" id="productDisplay" name="productDisplay" value="${product.getDisplay()}"/>
		<!-- <label for="productDisplay" class="form-check-label">
			Dipslay the product on site
		</label> -->
	  </div>
	</div>

	<input type="hidden" name="action" value="update"/>
	<div class="col-12">
	  <button type="submit" class="btn btn-primary">Update Product</button>
	</div>
  </form>
  

  
  
</body>
</html>