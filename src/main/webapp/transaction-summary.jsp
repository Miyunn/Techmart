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
<title>Techmart Store</title>
<link rel="stylesheet" href="styles/store.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

  <jsp:include page="nav.jsp" />

  <br>




    <div class="container-fluid bg-trasparent my-4 p-3" style="position: relative">
   
      <div class="transactionSum">

        <h2 style="text-align: center;">Transaction Summery</h2> 

        <br>

        <p>${message}</p>
        <!-- 
        Transaction ID : ${transaction.getTransactionID()} <br>
        Product ID : ${transaction.getProductID()} <br>
        Product Price : ${transaction.getPrice()} <br>
        Product Quantity : ${transaction.getQuantity()} <br>
        Product Total : ${transaction.getTotal()} <br>
        Customer ID : ${transaction.getCustomerID()} <br>
        Transaction Status : ${transaction.getStatus()} <br> <br> -->

        <p>You will be informed soon about your purchase <br>
        Thank you very much</p>
        <br>
        <a href="getProduct?action=store-all"><button class="btn btn-primary">Done</button></a>
        
        <br>
      </div>

    </div>

    <jsp:include page="footer.jsp" />
</body>
</html>