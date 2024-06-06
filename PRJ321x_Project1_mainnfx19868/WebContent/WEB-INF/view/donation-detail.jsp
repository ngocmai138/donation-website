<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đợt quyên góp</title>
</head>
<body>
	<h2>Chi tiết đợt quyên góp</h2>
	<f:form modelAttribute="donation">
		<table>
			<tr>
				<td>Mã đợt quyên góp:</td>
				<td><f:input path="code" readonly="true" /></td>
			</tr>
			<tr>
				<td>Tên đợt quyên góp:</td>
				<td><f:input path="name" readonly="true" /></td>
			</tr>
			<tr>
				<td>Ngày bắt đầu:</td>
				<td><f:input path="startDate" readonly="true" /></td>
			</tr>
			<tr>
				<td>Ngày kết thúc:</td>
				<td><f:input path="endDate" readonly="true" /></td>
			</tr>
			<tr>
				<td>Tổng tiền quyên góp:</td>
				<td><f:input path="money" readonly="true" /></td>
			</tr>
			<tr>
				<td>Trạng thái:</td>
				<td><f:input path="status" readonly="true" /></td>
			</tr>
			<tr>
				<td>Tổ chức:</td>
				<td><f:input path="organizationName" readonly="true" /></td>
			</tr>
			<tr>
				<td>Số điện thoại:</td>
				<td><f:input path="phoneNumber" readonly="true" /></td>
			</tr>
			<tr>
				<td>Nội dung:</td>
				<td><f:textarea path="description" readonly="true" /></td>
			</tr>
		</table>
	</f:form>
	<h3>Danh sách những người quyên góp</h3>
	<f:form modelAttribute="pagination"
		action="${pageContext.request.contextPath }/admin/detailDonation"
		method="get" id="userDonationForm">
		<input type="hidden" name="pageNumber" id="pageNumber" />
		<input type="hidden" name="donationId" value="${donation.id }" />
		<f:select path="pageSize" id="pageSize">
			<f:options items="${pageSizes }" />
		</f:select> entries per page
	<br>
		<br>
		<input type="text" placeholder="Search...." value="${keyword }"
			name="keyword" />
		<table>
			<tr>
				<th>Họ tên</th>
				<th>Tiền quyên góp</th>
				<th>Ngày quyên góp</th>
				<th>Nội dung</th>
				<th>Trạng thái</th>
				<th>Hành động</th>
			</tr>
			<c:forEach var="u" items="${userDonations }">
				<input type="hidden" name="udId" value="${u.id }" />
				<c:url var="changeStatus" value="changeStatusUD">
					<c:param name="udId" value="${u.id }" />
				</c:url>
				<c:url var="cancelStatus" value="cancelStatusUD">
					<c:param name="udId" value="${u.id }" />
				</c:url>
				<tr>
					<td>${u.user.fullName }</td>
					<td>${u.money }</td>
					<td>${u.created }</td>
					<td>${u.text }</td>
					<td>${u.status == 0 ? "Chờ xác nhận": u.status == 1 ? "Đã xác nhận" : "Đã hủy xác nhận"}</td>
					<td><c:if test="${u.status==0 }">
							<input type="button"
								onclick="window.location.href='${changeStatus}'"
								value="Xác nhận" />
							<input type="button"
								onclick="window.location.href='${cancelStatus}'"
								value="Hủy xác nhận" />
						</c:if></td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="i" begin="1" end="${totalPages }">
			<a
				href="${pageContext.request.contextPath }/admin/detailDonation?pageSize=${pageSize}&pageNumber=${i}&donationId=${donation.id}">${i }</a>
		</c:forEach>
	</f:form>
	<br>
	<input type="button" value="Quay lại"
		onclick="window.location.href='listDonation'" />
	<br>
	<br>
	<script>
		window.onload = function() {
			var pageSize = document.getElementById('pageSize');
			var userDonationForm = document.getElementById('userDonationForm');
			var keyword = document.querySelector('input[name="keyword"]');
			pageSize.addEventListener('change', function() {
				userDonationForm.submit();
			});
			keyword.addEventListener('keydown', function(event) {
				if (event.key === 'Enter') {
					event.preventDefault;
					document.getElementById('pageNumber').value = '1';
					userDonationForm.submit();
				}
			});
		};
	</script>
</body>
</html>