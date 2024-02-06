<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer form</title>
<style>
	.error{color:red}
</style>
</head>
<body>
<f:form action="processForm" modelAttribute="customer">
First name: <f:input path="firstName"/>
<br><br>
Last name (*): <f:input path="lastName"/>
<f:errors path="lastName" cssClass="error"/>
<br><br>
Free passes: <f:input path="freePasses"/>
<f:errors path="freePasses" cssClass="error"/>
<br><br>
Post code: <f:input path="postalCode"/>
<f:errors path="postalCode" cssClass="error"/>
<br><br>
Course code: <f:input path="courseCode"/>
<f:errors path = "courseCode" cssClass="error"/>
<br><br>
<input type="submit" value="Submit"/>
</f:form>
</body>
</html>