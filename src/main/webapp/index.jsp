<%@page import="java.util.List"%>
<%@page import="com.code.techmart.model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>TechMart</title>
<link rel="stylesheet" href="styles/store.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<jsp:include page="nav.jsp" />
<body>


<div class="container">

    <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
          <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
          <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img class="d-block w-100" src="images/EEq5Ou2WkAEP9En.jfif" alt="First slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="images/banner2.png" alt="Second slide">
          </div>
          <div class="carousel-item">
            <img class="d-block w-100" src="images/banner3.png" alt="Third slide">
          </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
      </div>

      <br> <br>

      <div class="newReleases">
        <h2 style="text-align: center;">Trending Products</h2>
      </div>
      
        <div class="container-fluid bg-trasparent my-4 p-3" style="position: relative">
        <div class="row row-cols-1 row-cols-xs-2 row-cols-sm-2 row-cols-lg-4 g-3">
           
            <tag:forEach var="product" items="${productList}">

                <div class="col hp">
                    <div class="card h-100 shadow-sm">
                    <a href="store.jsp">
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
           
                       	</div>
                    	</div>
                    </div>
                </div>

        </tag:forEach>

         </div>
    </div>

     







</div>


<jsp:include page="footer.jsp" />
</body>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</html>
