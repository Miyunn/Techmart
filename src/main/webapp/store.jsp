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
<title>Techmart Store</title>
<link rel="stylesheet" href="styles/store.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

  <jsp:include page="nav.jsp" />

  <br>
  <h2 style="text-align: center;">Products</h2>

    <p>${message}</p>

    <div class="container-fluid bg-trasparent my-4 p-3" style="position: relative">
        <div class="row row-cols-1 row-cols-xs-2 row-cols-sm-2 row-cols-lg-4 g-3">
           
            <tag:forEach var="product" items="${productList}">

                <div class="col hp">
                    <div class="card h-100 shadow-sm">
                    <a href="#">
                        <img src="${product.getImage()}" class="card-img-top" alt="product.title" />
                    </a>
            
                    <div class="label-top shadow-sm">
                        <a class="text-white" href="#">${product.getType()}</a>
                    </div>
                    <div class="card-body">
                        <div class="clearfix mb-3">
                        <span class="float-start badge rounded-pill bg-success">LKR ${product.getPrice()}</span>
            
                        </div>
                        <h5 class="card-title">
                        <a target="_blank" href="#">${product.getModel()}</a>
                        </h5>
            
                        <div class="d-grid gap-2 my-4">
            			<%
            			System.out.println(session.getAttribute("sessionUserID"));
            			%>
        
            			<form action="addTransaction" method="post">
            				<input type="hidden" name=action value="add"/>
            				<input type="hidden" name="customerID" value="${sessionScope.sessionUserID}"/>
            				<input type="hidden" name="productID" value="${product.getId()}"/>
            				 <input type="hidden" name="branch" value="${sessionScope.sessionBranch}"/>
            				  <input type="hidden" name="quantity" value="1"/>
            				  <input type="hidden" name="total" value="${product.getPrice()}"/>
            				  <button type="submit" class="btn btn-warning bold-btn">BUY</button>
            			</form>
            
                        </div>
                    </div>
                    </div>
                </div>

        </tag:forEach>

         </div>
    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>