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
}

</style>

</head>
<body>



<div class="panel panel-primary">
  <div class="panel-heading">User Entry</div>
  <div class="panel-body">
  	
  	<form:form action="processUserDetails" method="post" modelAttribute="formDto">
	  <div class="form-group">
	    <label for="name">Name:</label>
	    <input type="text" name="name" class="form-control" id="name">
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Phone No:</label>
	    <input type="text" name="phoneNo" class="form-control" id="phoneNo">
	  </div>
	  
	  <div class="form-group">
	    <label for="name">Username:</label>
	    <input type="text" name="username" class="form-control" id="username">
	  </div>
	  <div class="form-group">
	    <label for="phoneNo">Password:</label>
	    <input type="text" name="password" class="form-control" id="password">
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
  				</tr>
  			</c:forEach>
  		</tbody>
  		
  	</table>
  
  </div>
</div>


</body>
</html>