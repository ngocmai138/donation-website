<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List User</title>
</head>
<body>
<h2>List of User</h2>
<br>
<table>
	<tr>
		<th>Họ tên</th>
		<th>Email</th>
		<th>Số điện thoại</th>
		<th>Tài khoản</th>
		<th>Vai trò</th>
		<th>Trạng thái</th>
		<th>Hành động</th>
	</tr>
	<c:forEach var="u" items="${users }">
	<tr>
		<td>${ u.fullName}</td>
		<td>${u.email }</td>
		<td>${u.phoneNumber }</td>
		<td>${u.userName }</td>
		<td>${u.role.roleName }</td>
		<td>${u.status==1 ? 'Hoạt động':'Đã khóa' }</td>
		<td>
			<input type="button" value="Sửa" onclick=""/>
			<input type="button" value="Xóa" onclick=""/>
			<input type="button" value="Khóa" onclick=""/>
		</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>