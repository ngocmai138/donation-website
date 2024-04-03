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
	entries per page
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
		<th>Số điện thoại</th>
		<th>Tổng tiền</th>
		<th>Trạng thái</th>
		<th>Hoạt động</th>
	</tr>
	<c:forEach var="d" items="${donations}">
	<c:url var="deleteLink" value="deleteDonation">
		<c:param name="donationId" value="${d.id }"/>
	</c:url>
	<c:url var="updateLink" value="updateDonation">
		<c:param name="donationId" value="${d.id }"/>
	</c:url>
	<c:url var="detailLink" value="detailDonation">
		<c:param name="donationId" value="${d.id }"/>
	</c:url>
	<c:url var="changeStatus" value = "changeStatusDonation">
		<c:param name="donationId" value = "${d.id }"/>
	</c:url>
	<tr>
		<td>${d.code }</td>	
		<td>${d.name }</td>	
		<td>${d.startDate }</td>	
		<td>${d.endDate }</td>	
		<td>${d.organizationName }</td>	
		<td>${d.phoneNumber }</td>
		<td>${d.money }</td>	
		<td>${statusDonation.getStatusString(d.status)}</td>	
		<td>
			<input type="Submit" value="Cập nhật" 
					onclick="window.location.href='${updateLink}'"
					${d.status == 3 ? "hidden = 'hidden'" : " "} />
			<input type="Submit" value="Chi tiết"
					onclick="window.location.href='${detailLink}'"/>
			<input type="Submit" 
					value="Xóa" 
					${d.status!=0 ? "hidden='hidden'": " "} 
					onclick="if(!confirm('Bạn chắc chắn muốn xóa?')) 
								return false; 
							else 
								window.location.href='${deleteLink}'"/>
			<input type="Submit" 
					${d.status==3? "hidden='hidden'": " "}
					value="${statusDonation.getButtonLabel(d.status) }"
					onclick="window.location.href='${changeStatus }'"
					/>
		</td>	
	</tr>
	</c:forEach>
</table>
<br><br>
<div>Showing ${ firstResult} to ${lastResult } of ${totalDonations } entries</div>
<br><br>
<div>
<c:forEach var="i" begin="1" end="${totalPages }">
	<a href="${pageContext.request.contextPath }/admin/listDonation?pageSize=${numSize}&pageNumber=${i}&keyword=${keyword}"> ${i } </a>
</c:forEach>
</div>
<br>
<input type="button" value="Quay lại" onclick="window.location.href='${pageContext.request.contextPath }/admin'"/>
<script>
window.onload = function(){
	var pageSize = document.getElementById('pageSize');
	var keyword = document.querySelector('input[name="keyword"]');
	var paginationForm = document.getElementById('paginationForm');
	pageSize.addEventListener('change', function(){
		document.getElementById('pageNumber').value = '1';
		paginationForm.submit();
	});
	keyword.addEventListener('keydown', function(event){
		if(event.key === 'Enter'){
			event.preventDefault();
			document.getElementById('pageNumber').value='1';
			paginationForm.submit();
		}
	});
};
</script>
</body>
</html>