<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer confirmation</title>
</head>
<body>
Customer is confirmed: ${customer.firstName } ${customer.lastName }
<br><br>
Free passes: ${customer.freePasses }
<br><br>
Post code: ${customer.postalCode }
<br><br>
Course code: ${customer.courseCode }
</body>
</html>