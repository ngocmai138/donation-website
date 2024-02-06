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
Favorite language:
<br>
<f:radiobutton path="favoriteLanguage" value="java"/> Java
<f:radiobutton path="favoriteLanguage" value="c#"/> C#
<f:radiobutton path="favoriteLanguage" value="php"/> PHP
<f:radiobutton path="favoriteLanguage" value="ruby"/> Ruby
<br><br>
Operating systems:
<f:checkbox path="operatingSystem" value="windows"/> Windows
<f:checkbox path="operatingSystem" value="mac os"/> Mac OS
<f:checkbox path="operatingSystem" value="Linux"/> Linux
<br><br>
<input type="submit" value="Submit"/>
</f:form>
</body>
</html>