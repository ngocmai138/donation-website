<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
First name: <form:input path="firstName"/><br><br>
Last name: <form:input path="lastName"/><br><br>
Country: <form:select path="country">
<form:option value = "Brazil" label="Brazil"/>
<form:option value = "Franch" label = "Franch"/>
<form:option value = "Germany" label = "Germany"/>
<form:option value = "India" label = "India" />
</form:select>
<br><br>
<input type="submit" value="Submit"/>
</form:form>
</body>
</html>