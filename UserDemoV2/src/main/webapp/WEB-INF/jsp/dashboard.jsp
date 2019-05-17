<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>


<jsp:include page="common.jsp"></jsp:include>

<style type="text/css">

body {
	padding: 25px;
	font-family: "Lato", sans-serif;
}


.sidenav {
  height: 100%;
  width: 0;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  background-color: #111;
  overflow-x: hidden;
  transition: 0.5s;
  padding-top: 60px;
}

.sidenav a {
  padding: 8px 8px 8px 32px;
  text-decoration: none;
  font-size: 25px;
  color: #818181;
  display: block;
  transition: 0.3s;
}

.sidenav a:hover {
  color: #f1f1f1;
}

.sidenav .closebtn {
  position: absolute;
  top: 0;
  right: 25px;
  font-size: 36px;
  margin-left: 50px;
}

@media screen and (max-height: 450px) {
  .sidenav {padding-top: 15px;}
  .sidenav a {font-size: 18px;}
}

</style>

</head>
<body>




<h1>Welcome ${sessionScope.loginUser.name } <a href="/login?logout">Logout</a></h1>



<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="#">About</a>
  <a href="#">Services</a>
  <a href="#">Clients</a>
  <a href="#">Contact</a>
</div>


<span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; open</span>

<script>
function openNav() {
  document.getElementById("mySidenav").style.width = "250px";
}

function closeNav() {
  document.getElementById("mySidenav").style.width = "0";
}
</script>




<div class="panel panel-primary">
  <div class="panel-heading">User Entry</div>
  <div class="panel-body">
  	
  	<form:form action="processUserDetails" method="post" modelAttribute="formDto">
  		<input type="hidden" id="id" name="id" value="${formDto.id }"/>
	  <div class="form-group">
	    <label for="name">Name:</label>
	    <input type="text" name="name" class="form-control" id="name" value="${formDto.name}">
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone No:</label>
	    <input type="text" name="phoneNo" class="form-control" id="phoneNo" value="${formDto.phoneNo}">
	  </div>
	  
	  <div class="form-group">
	    <label for="name">Username:</label>
	    <input type="text" name="username" class="form-control" id="username" value="${formDto.username}">
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Password:</label>
	    <input type="text" name="password" class="form-control" id="password" value="${formDto.password}">
	  </div>
	  
	  <button type="submit" class="btn btn-default">Submit</button>
	
  	</form:form>
  </div>
</div>

<div class="panel panel-primary">
  <div class="panel-heading">User List</div>
  <div class="panel-body">
  	
  	<table class="table">
  		<thead>
  			<tr>
  				<th>Sr.No.</th>
  				<th>Name</th>
  				<th>Phone No</th>
  				<th>DOB</th>
  				<th>Address</th>
  				<th>Action</th>
  			</tr>
  		</thead>
  		
  		<tbody>
  			<c:forEach items="${userDtoList}" var="row" varStatus="status">
  				<tr>
  					<td>${status.count}</td>
  					<td>${row.name}</td>
  					<td>${row.phoneNo}</td>
  					<td>${row.dob}</td>
  					<td>${row.address}</td>
  					<td><a href="editUser?id=${row.id}">EDIT</a> / <a href="deleteUser?id=${row.id}">DELETE</a></td>
  				</tr>
  			</c:forEach>
  		</tbody>
  		
  	</table>
  
  </div>
</div>


</body>
</html>