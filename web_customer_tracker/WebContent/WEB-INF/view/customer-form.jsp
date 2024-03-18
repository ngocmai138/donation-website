<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer form</title>
</head>
<body>
<h2>Customer form</h2>
<br><br>
<f:form action="addCustomer" modelAttribute="customer" method="POST">
<table>
	<tbody>
		<tr>
			<td>
				<f:hidden path="id"/>
			</td>
		</tr>
		<tr>
			<td>
				<label>First name: </label>
			</td>
			<td>
				<f:input path="firstName"/>
			</td>
		</tr>
		<tr>
			<td>
				<label>Last name: </label>
			</td>
			<td>
				<f:input path="lastName"/>
			</td>
		</tr>
		<tr>
			<td>
				<label>Email: </label>
			</td>
			<td>
				<f:input path="email"/>
			</td>
		</tr>
		<tr>
		<td></td>
		<td>
			<input type="submit" value="Save"/>
		</td>
		</tr>
	</tbody>
</table>
</f:form>
<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
</body>
</html>