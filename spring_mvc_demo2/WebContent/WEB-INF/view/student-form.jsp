<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="f" uri ="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student form</title>
</head>
<body>
<f:form action = "processForm" modelAttribute = "student">
First name: <f:input path="firstName"/>
<br><br>
Last name: <f:input path="lastName"/>
<br><br>
Country: <f:select path="country">
<f:options items="${student.countryOptions }"/>
</f:select>
<br><br>
<input type="submit" value="Submit"/>
</f:form>
</body>
</html>