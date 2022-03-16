<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>Agent - Techmart</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link rel='stylesheet' type='text/css' media='screen' href='styles/main.css'>
    <link rel='stylesheet' type='text/css' media='screen' href='styles/register.css'>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src='main.js'></script>
</head>
<body>

   

   <jsp:include page="nav.jsp" />

    <div class="sidenav">
        <div class="login-main-text">
           <h2>Tech Mart<br>Customer Register</h2>
           <p>Welcome to Tech Mart <br> Fill in the form below to get started</p>
        </div>
     </div>
     <div class="main">
        <div class="col-md-6 col-sm-12">
           <div class="login-form">
              <form action="addCustomer" method="post">

               <h3>Personal Information</h3>

                 <div class="form-group">
                    <label>First Name</label>
                    <input type="text" class="form-control" id="fName" name="fname" placeholder="Frist Name">
                 </div>

                 <div class="form-group">
                     <label>Last Name</label>
                     <input type="text" class="form-control" id="lName" name="lname" placeholder="Last Name">
                  </div>

                  <div class="form-group">
                     <label>Address</label>
                     <input type="text" class="form-control" id="address" name="address" placeholder="Address">
                  </div>

                  <div class="form-group">
                     <label>Select Area</label> <br>
                     <select name="branch" id="branch" class="form-control">
                        <option value="Colombo">Colombo</option>
                        <option value="Galle">Galle</option>
                        <option value="Kandy">Kandy</option>
                        <option value="Nugegoda">Nugegoda</option>
                        <option value="Gampaha">Gampaha</option>
                        <option value="Kurunegala">Kurunegala</option>
                        <option value="Jaffna">Jaffna</option>
                      </select>

                  </div>

                  <div class="form-group">
                     <label>Address</label>
                     <input type="text" class="form-control" id="address" name="address" placeholder="Address">
                  </div>

                  <div class="form-group">
                     <label>Contact Number</label>
                     <input type="tel" class="form-control" id="contact" name="contact" placeholder="Contact Number">
                  </div>

                  <hr>

                  <h3>Account Information</h3>

                  <div class="form-group">
                     <label>Email Address</label>
                     <input type="email" class="form-control" id="email" name="email" placeholder="Email">
                  </div>


                 <div class="form-group">
                    <label>Password</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Password">
                 </div>

                  <div class="form-group">
                     <label>Confirm Password</label>
                     <input type="password" class="form-control" placeholder="Confirm Password">
                  </div>

                  <input type="hidden" name="action" value="add"/>

                 <button type="submit" class="btn btn-black">Register</button>

              </form>

               <%
                  out.println(request.getAttribute("message")); 
               %>
           
           </div>
        </div>
     </div>
    
</body>
</html>