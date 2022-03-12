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
<title>Products</title>
</head>
<body>

<p>${message}</p>



<table>
	<thead>
		<tr>
		<th>Product ID </th>
		<th>Product Name</th>
		<th>Product Model</th>
		<th>Product Type</th>
		<th>On Display</th>
		<th>Price</th>
		<th>Image</th>
	</tr>
	</thead>
	
	<tbody>
		<tag:forEach var="product" items="${productList}">
		<tr>
			<td>${product.getId()}</td>
			<td>${product.getName()}</td>
			<td>${product.getModel()}</td>
			<td>${product.getType()}</td>
			<td>${product.getDisplay()}</td>
			<td>${product.getPrice()}</td>
			<td>${product.getImage()}</td>
		</tr>
		</tag:forEach>
	</tbody>

</table>
</body>
</html>