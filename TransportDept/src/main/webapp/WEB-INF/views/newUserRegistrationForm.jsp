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
</head>
<body>

<div class="topnav">
  <a class="active" href="\transport">Home</a>
  <div class="topnav-right">
    <a href="login.htm">Login</a>    
  </div>
</div>

<div align="center">
<h1>User Registration Form</h1>
</div>

<div align="left">
	<h2>Please Enter your Information Below</h2>
        <form:form action ="newUser" method="post" modelAttribute="person">
            First Name:   <form:input path="firstName"/> <form:errors path="firstName"/><br /><br />
            Last Name:   <form:input path="lastName"/> <form:errors path="lastName"/><br/><br/>
            Username: <form:input path="userName"/> <form:errors path="userName"/><br/><br/>
            Password:   <form:password path="password"/> <form:errors path="password"/><br/><br/>
            License #:   <form:input path="licenseNo"/> <form:errors path="licenseNo"/><br/><br/>            
           <input type="submit" value="RegisterUser" class="button"/>            
        </form:form>
</div>


</body>
</html>
