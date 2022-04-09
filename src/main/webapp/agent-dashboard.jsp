<%@page import="java.util.List"%>
<%@page import="com.code.techmart.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@taglib prefix="tag" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Agent</title>
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
      <link rel="stylesheet" href="styles/mdb.min.css" />
      <link rel="stylesheet" href="/css/admin.css" />
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" integrity="sha512-d9xgZrVZpmmQlfonhQUvTR7lMPtO7NkZMkA0ABN3PHCbKA5nqylQ/yWlFAyY6hYgdF1Qh6nYiuADWwKB4C2WSw=="
        crossorigin="anonymous"></script>
<body>

  <%
  String user = null;
  if(session.getAttribute("sessionusername") == null){
    response.sendRedirect("agent-login.jsp");
    
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
  
</head>
<body>
 
  <jsp:include page="nava.jsp" />

  <!--Main Navigation-->
  <main style="margin-top: 58px">
    <div class="container pt-4">
      <section>
        <div class="row">
          <div class="col-xl-6 col-md-12 mb-4">
            <div class="card">
              <div class="card-body">
                <div class="d-flex justify-content-between p-md-1">
                  <div class="d-flex flex-row">
                    <div class="align-self-center">
                      <h2 class="h1 mb-0 me-4">Last Update</h2>
                    </div>
                    <div>
                      <h4></h4>
                      <p class="mb-0"><%= (new java.util.Date()).toLocaleString()%></p>
                    </div>
                  </div>
                  <div class="align-self-center">
                    <i class="fa fa-calendar fa-3x"></i>
                  </div>
                </div>
              </div>
            </div>
          </div>  
          <div class="col-xl-3 col-sm-6 col-12 mb-4">
            <div class="card">
              <div class="card-body">
                <div class="d-flex justify-content-between px-md-1">
                  <div class="align-self-center">
                    <i class="fas fa-pencil-alt text-info fa-3x"></i>
                  </div>
                  <div class="text-end">
                    <h3><?php countcls();?></h3>
                    <p class="mb-0">Total Sales</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="col-xl-3 col-sm-6 col-12 mb-4">
            <div class="card">
              <div class="card-body">
                <div class="d-flex justify-content-between px-md-1">
                  <div class="align-self-center">
                    <i class="far fa-user text-success fa-3x"></i>
                  </div>
                  <div class="text-end">
                    <h3>  <?php countteach();?></h3>
                    <p class="mb-0">Registered Custoemrs</p>
                  </div>
                </div>
              </div>
            </div>
        </div>
      </section>
      
      <section class="mb-4">
        <div class="card">
          <div class="card-header text-center py-3">
            <h5 class="mb-0 text-center">
              <strong>Sales Summery</strong>
            </h5>
          </div>
          <div class="card-body">
            <div class="table-responsive">
              <table class="table">
                <tr>
                  <td>
                    <form action="getTransaction" method="post">
                      <input type="hidden" name=action value="agent"/>
                      <input type="hidden" name="branch" value="${sessionScope.sessionBranch}"/>
                      <button type="submit" class="btn btn-warning bold-btn">Manage Transactions</button>
                    </form>
<p><%System.out.println(session.getAttribute("sessionBranch"));%></p>
                  </td>
                  <td></td> 
                </tr>
              </table>
            </div>

              <a href="instituteedit.php" class="btn btn-primary" style="float: right;"  >EDIT</a>
            </sectioin>
    </div>
  </main>
</body>
</html>
</body>
</html>