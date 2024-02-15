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
<h2>List customer </h2>
<table>
<tr>
	<th>First name</th>
	<th>Last name</th>
	<th>Email</th>
</tr>
<c:forEach var="cus" items="${customers }">
<tr>
<td>${cus.firstName }</td>
<td>${cus.lastName }</td>
<td>${cus.email }</td>
</tr>
</c:forEach>
</table>

</body>
</html>