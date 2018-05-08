<%@page import="com.me.transport.pojo.Role"%>
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
<c:set var="person" value="${sessionScope.person}" scope="session"></c:set>

<c:choose>
<c:when test="${person == null}">
<div class="topnav">
  <a class="active" href="\transport">Home</a>  
  <a href="registrationtp.htm">Traffic Police Registration</a>
  <a href="registrationdot.htm">DOT Registration</a>
  <div class="topnav-right">
    <a href="login.htm">Login</a>
    <a href="registrationUser.htm">First-Time User</a>
  </div>
</div>
</c:when>

<c:when test="${person.role == 'TP'}">
<div class="topnav">
  <a class="active" href="\transport">Home</a>  
  <a href="searchLP.htm">Add Fines</a>
  <a href="searchVehicle.htm">Add Incident</a>
  <div class="topnav-right">
    <a href="logout.htm">Logout</a>
   <font size="4" color="#f2f2f2" >Welcome ${person.firstName }</font>
  </div>
</div>
</c:when>
</c:choose>

<div align="center">
<h1><font face = "Courier" color="#000000" size="7">Add Incident</font></h1>
<h2><font face = "Courier" color="#000000" size="5">Enter Vehicle Identification Number Below!</font></h2>
<form name='searchvehicle' action="addIncident" method="post">
              	<input type="text" name="vin"  /><br/><br/>
               <input type="submit"  value="Enter" class="button"/>
         </form>
</div>


</body>
</html>
