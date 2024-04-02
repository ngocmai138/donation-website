<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nội dung của đợt quyên góp</title>
</head>
<body>
<f:form modelAttribute="donation" method = "get">
<h2>Nội dung của đợt quyên góp</h2>
<label>${donation.name}</label>
<h3>Thông tin</h3>
<table>
	<tr>
		<td><b>Mã đợt quyên góp: </b></td>
		<td>${ donation.code}</td>
	</tr>
	<tr>
		<td><b>Tên đợt quyên góp: </b></td>
		<td>${donation.name }</td>
	</tr>
	<tr>
		<td><b>Ngày bắt đầu: </b></td>
		<td>${donation.startDate }</td>
	</tr>
	<tr>
		<td><b>Ngày kết thúc: </b></td>
		<td>${donation.endDate }</td>
	</tr>
	<tr>
		<td><b>Cá nhân/Tổ chức: </b></td>
		<td>${donation.organizationName }</td>
	</tr>
	<tr>
		<td><b>Số điện thoại: </b></td>
		<td>${donation.phoneNumber }</td>
	</tr>
	<tr>
		<td><b>Tổng tiền quyên góp nhận được: </b></td>
		<td>${donation.money } VND</td>
	</tr>
	<tr>
		<td><b>Trạng thái: </b></td>
		<td>${status.getStatusString(donation.status) }</td>
	</tr>
</table>
<br>
<input type="button" value="Quyên góp" ${donation.status !=1 ? "hidden = 'hidden'":"" }/>
<br>
<h3>Danh sách quyên góp</h3>
<table>
	<c:forEach var="u" items="${ userDonations}">
		<tr>
			<td><b>${u.user.fullName}</b><br>
			${u.created }<br>
			${u.money } VND
			</td>
		</tr>
	</c:forEach>
</table>
</f:form>
</body>
</html>