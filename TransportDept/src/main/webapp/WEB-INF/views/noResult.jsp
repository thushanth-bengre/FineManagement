<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</head>
<body>

<div class="topnav">
  <a class="active" href="\transport">Home</a>
  <a href="#news">Register Vehicle</a>
  <a href="#contact">Traffic Police</a>
  <a href="#about">DOT</a>
  <div class="topnav-right">
    <a href="#search">Login</a>
    <a href="#about">First-Time User</a>
  </div>
</div>

<div align="center">
<h1><font face = "Courier" color="#000000" size="7">Vehicle History</font></h1>
<h2><font face = "Courier" color="#000000" size="5">No Incidents found for the Vehicle!</font></h2>    
</div>


</body>
</html>