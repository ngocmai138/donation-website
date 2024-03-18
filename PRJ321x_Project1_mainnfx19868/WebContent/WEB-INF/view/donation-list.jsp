<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Donation list</title>
</head>
<body>
<h2>Danh sách đợt quyên góp</h2>
<input type="button" value="Thêm mới" onclick="window.location.href='formToAddDonation'"/>
<br><br>
<f:form modelAttribute="pagination" action="${pageContext.request.contextPath }/admin/listDonation" method="get" id="paginationForm">
	<f:hidden path="pageNumber" value="${pagination.pageNumber }" id="pageNumber"/>
	<f:select path="pageSize" id="pageSize">
		<option value="" selected="selected" hidden = "true">${numSize }</option>
		<f:options items="${pageSizes }"/>
	</f:select>
<br><br>
	<input type="text" placeholder="Search....." name="keyword" value="${keyword }"/>	
</f:form>
<br><br>
<table>
	<tr>
		<th>Mã</th>
		<th>Tên</th>
		<th>Ngày bắt đầu</th>
		<th>Ngày kết thúc</th>
		<th>Tổ chức</th>
		<th>Tổng tiền</th>
		<th>Trạng thái</th>
		<th>Hoạt động</th>
	</tr>
	<c:forEach var="d" items="${donations}">
	<tr>
		<td>${d.id }</td>	
		<td>${d.name }</td>	
		<td>${d.startDate }</td>	
		<td>${d.endDate }</td>	
		<td>${d.organizationName }</td>	
		<td>${d.money }</td>	
		<td>${d.status }</td>	
		<td>
			<input type="Submit" value="Cập nhật"/>
			<input type="Submit" value="Chi tiết"/>
			<input type="Submit" value="Xóa"/>
			<input type="Submit" value="Quyên góp"/>
		</td>	
	</tr>
	</c:forEach>
</table>
<div>
<c:forEach var="i" begin="1" end="${totalPages }">
	<a href="${pageContext.request.contextPath }/admin/listDonation?pageSize=${numSize}&pageNumber=${i}&keyword=${keyword}"> ${i } </a>
</c:forEach>
</div>
<script>
window.onload = function(){
	var pageSize = document.getElementById('pageSize');
	var keyword = document.getElementById('keyword');
	var paginationForm = document.getElementById('paginationForm');
	pageSize.addEventListener('change', function(){
		document.getElementById('pageNumber').value = '1';
		paginationForm.submit();
	});
};
</script>
</body>
</html>