<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {    
	background-image: url("resources/Images/Trafficjam.jpg");

    /* Full height */
    height: 100%; 

    /* Center and scale the image nicely */
    background-position: inherit;
    background-repeat: repeat;
    background-size: cover;    
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}



.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px; 
  text-decoration: none;
  font-size: 17px;
}


.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {  
  color: white;
}

.topnav-right {
  float: right;
}

.button {
    background-color: #922B21;
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
}
</style>
<script>
function validateForm() {
    var username = document.forms["loginForm"]["username"].value;
    if (username == "") {
        alert("Username Cannot be blank");
        return false;
    }
    var password = document.forms["loginForm"]["password"].value;
    if (password == "") {
        alert("Password Cannot be blank");
        return false;
    }
}
</script>
</head>
<body>

<div class="topnav">
  <a class="active" href="\transport">Home</a>  
  <div class="topnav-right">
    <a href="login.htm">Login</a>    
  </div>
</div>

<div align="center">
<h1>${loginError}</h1>
</div>




</body>
</html>
