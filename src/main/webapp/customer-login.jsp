<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Login - Techmart</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='main.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='styles/login.css'>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src='main.js'></script>
</head>
<body>
   
    <div class="sidenav">
        <div class="login-main-text">
           <h2>Techmart<br> Customer Portal</h2>
           <p>Login from here to access</p>
        </div>
     </div>
     
     <div class="main">
        <div class="col-md-6 col-sm-12">
           <div class="login-form">
              <form action="customerLogin" method="post">
                 <div class="form-group">
                    <label>User Name</label>
                    <input type="text" class="form-control" placeholder="User Name" name="username">
                 </div>

                 <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" placeholder="Password" name="password">
                 </div>
                 
                 <input type="hidden" name="action" value="login">
                 <button type="submit" class="btn btn-black">Login</button>
                  <a href="register.jsp"><button type="button" class="btn btn-black">Register</button></a>
              </form>
              
              	<p>${loginMessage}</p>
           </div>
        </div>
     </div>
    
</body>
</html>