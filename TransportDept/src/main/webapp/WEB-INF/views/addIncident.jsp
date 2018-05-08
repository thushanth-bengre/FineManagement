<%@page import="com.me.transport.pojo.Role"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">
			      $(function() {
			          $('#idDateField').datepicker();
			      });
</script>
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
  <a href="addfines.htm">Add Fines</a>
  <a href="addincident.htm">Add Incident</a>
  <div class="topnav-right">
    <a href="logout.htm">Logout</a>
   <font size="4" color="#f2f2f2" >Welcome ${person.firstName }</font>
  </div>
</div>
</c:when>
</c:choose>

<div align="center">
<h1>Add Incident</h1>
</div>

<div align="left">
	<h2>Please enter Incident details below</h2>
        <form:form action = "saveincident" method="post" modelAttribute="incident">
        Vehicle Identification Number: 	<c:out value="${vehicle.vin}"></c:out><br /><br />
        Model: 							<c:out value="${vehicle.model}"></c:out><br /><br />
        Manufacturer: 					<c:out value="${vehicle.manufacturer}"></c:out><br /><br />       
            Location:   <form:input path="location"/> <form:errors path="location"/><br /><br />
            Date:   	<form:input id="idDateField" path="date"/> <form:errors path="date"/><br/><br/>            
            Summary: 	<form:input path="summary"/> <form:errors path="summary"/><br/><br/>                     
           <input type="submit" value="Add Incident" class="button"/>           
        </form:form>
</div>

</body>
</html>
