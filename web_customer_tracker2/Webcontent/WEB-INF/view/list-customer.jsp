<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List customer</title>
</head>
<body>
<h2>List customer</h2>
<input type="button" value="Add customer" onclick="window.location.href='showFormForAdd'"/>
<table>
<tr>
<th>First name</th>
<th>Last name</th>
<th>Email</th>
<th>Action</th>
</tr>
<c:forEach var="cus" items="${customers }">
<c:url var="updateLink" value="showFormForUpdate">
	<c:param name="customerId" value="${cus.id}" />
</c:url>
<c:url var="deleteLink" value="delete">
	<c:param name="customerId" value="${cus.id }" />
</c:url>
<tr>
<td>${cus.firstName }</td>
<td>${cus.lastName }</td>
<td>${cus.email }</td>
<td>
	<a href="${updateLink }" >Update</a>
</td>
<td>
	<a href="${deleteLink }" onclick="if(!confirm('Are you sure you want to delete this customer?')) return false;">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>