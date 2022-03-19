<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TechMart Supplier</title>
      <!-- Font Awesome -->
      <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
      <!-- Google Fonts Roboto -->
      <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
      <!-- MDB -->
      <link rel="stylesheet" href="styles/mdb.min.css" />
      <!-- Custom styles -->
      <link rel="stylesheet" href="../css/admin.css" />
      <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js" integrity="sha512-d9xgZrVZpmmQlfonhQUvTR7lMPtO7NkZMkA0ABN3PHCbKA5nqylQ/yWlFAyY6hYgdF1Qh6nYiuADWwKB4C2WSw=="
        crossorigin="anonymous"></script>
</head>
<body>

  <jsp:include page="navsup.jsp" />

  
  <%
  String user = null;
  if(session.getAttribute("sessionusername") == null){
    response.sendRedirect("supplier-login.jsp");
    
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
    </div>
  </main>

  <main style="margin-top: 20px">
    <div class="container pt-4">
      <h2 class="text-center">Manage Products</h2>
      
      <ul class="nav nav-tabs" style="margin-top: 20px;">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="getProduct?action=all">All Requests</a>
        </li>
      </ul>
      
      <p>${message}</p>
      <p>${deleteMsg}</p>

      <div class="table-responsive">
        <table class="table" style="width:100%">
    
            <tr>
            <th>Request ID </th>
            <th>Branch</th>
            <th>Product ID</th>
            <th>Quantity</th>
            <th>Action</th>
          </tr>
          

            <tag:forEach var="product" items="${productList}">
            <tr>
              <td>${product.getId()}</td>
              <td>${product.getBranch()}</td>
              <td>${product.getProductID()}</td>
              <td>${product.getQuantity()}</td>
              <td>

                <form action="confirmRequest" method="post">
                  <input type="hidden" name="action" value="delete"/>
                  <input type="hidden" name="productID" value="${request.getId()}"/>
                  <button type="submit" class="btn btn-warning">Confirm</button>
                </form>

                <form action="rejectRequest" method="post">
                  <input type="hidden" name="action" value="delete"/>
                  <input type="hidden" name="productID" value="${request.getId()}"/>
                  <button type="submit" class="btn btn-danger">Reject</button>
                </form>
              
              </td>
            </tr>
            </tag:forEach>

   
        </table>
      </div>
    </div>

</main>

</body>
</html>
</body>
</html>