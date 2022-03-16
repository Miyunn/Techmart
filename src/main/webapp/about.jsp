<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>About Us</title>

    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="styles/main.css" rel="stylesheet">
    <link href="styles/about.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src='main.js'></script>
</head>
<body>
  <jsp:include page="nav.jsp" />

      <div class="aboutContainer">

        <img src="images/aboutImg.png" id="aboutimg">
        <div class="centered">
          
         <h2> About Us</h2>
         <br>
         <p>We are Sri Lankans leading mobile phone and accessory dealer
            with several branches located all over the island. <br>
            Recognized as the most trusted dealer we have been providing our service over a decade satisfying 
            over 1 million customers island wide </p>

          
        </div>

      </div>  
     

      <jsp:include page="footer.jsp" />
</body>
</html>