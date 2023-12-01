<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
First name: <form:input path = "firstName"/>
<br><br>
Last name: <form:input path = "lastName" />
<br><br>
Country: 
<form:select path="country">
<form:options items = "${student.countryOptions}"/>
</form:select>
<br><br>
Favorite language:
Java <form:radiobutton path="favoriteLanguage" value="java"/>
PHP <form:radiobutton path="favoriteLanguage" value="php"/>
C# <form:radiobutton path="favoriteLanguage" value="c#"/>
Ruby <form:radiobutton path="favoriteLanguage" value="ruby"/>
<br><br>

OperatingSystem: 
Linux: <form:checkbox path = "operatingSystems" value = "Linux" />
Mac OS: <form:checkbox path = "operatingSystems" value = "Mac OS"/>
MS Windows: <form:checkbox path = "operatingSystems" value = "Windows"/>
<input type="submit" value="Submit"/>
</form:form>
</body>
</html>