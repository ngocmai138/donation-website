<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nội dung của đợt quyên góp</title>
<style>
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	background-color: #fefefe;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
}

.close {
	cursor: pointer;
}
</style>
</head>
<body>
	<h2>Nội dung của đợt quyên góp</h2>
	<c:if test="${not empty message }">
		<div style="color: green;">${message }</div>
	</c:if>
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
			<td>${donation.money }VND</td>
		</tr>
		<tr>
			<td><b>Trạng thái: </b></td>
			<td>${status.getStatusString(donation.status) }</td>
		</tr>
	</table>
	<br>
	<input type="button" value="Quyên góp" class="donateButton"
		${donation.status !=1 ? "hidden = 'hidden'":""}
		data-modal-target="#donateModal" />
	<div class="modal" style="display: none" id="donateModal">
		<div class="modal-content">
			<span class="close">&times;</span>
			<p>Quyên góp</p>
			<f:form modelAttribute="donate"
				action="${pageContext.request.contextPath }/addDonate" method="post">
				<table>
					<tr>
						<td>Họ tên <br> <input type="text"
							value="${user.fullName }" readonly />
						</td>
					</tr>
					<tr>
						<td>Số tiền quyên góp <br> <input type="text"
							name="money" />
						</td>
					</tr>
					<tr>
						<td>Lời nhắn <br> <input type="text" name="text" />
						</td>
					</tr>
					<tr>
						<td><input type="hidden" name="userId" value="${user.id }" />
							<input type="hidden" name="donationId" value="${donation.id }" />
						</td>
					</tr>
					<tr>
						<td><input type="button" value="Đóng" class="close" /> <input
							type="submit" value="Quyên góp" /></td>
					</tr>
				</table>
			</f:form>
		</div>
	</div>
	<br>
	<h3>Danh sách quyên góp</h3>
	<f:form modelAttribute="pagination"
		action="${pageContext.request.contextPath }/detailDonation"
		id="userDonationForm">
		<input type="hidden" name="pageNumber" id="pageNumber" />
		<input type="hidden" name="donationId" value="${donation.id }" />
		<f:select path="pageSize" id="pageSize">
			<f:options items="${pageSizes }" />
		</f:select> entries per page
		<br>
		<br>
		<input type="text" placeholder="Search..." value="${keyword }"
			name="keyword" />
		<table>
			<tr>
				<th>Họ tên</th>
				<th>Tiền quyên góp</th>
				<th>Ngày quyên góp</th>
				<th>Nội dung</th>
				<th>Trạng thái</th>
			</tr>
			<c:forEach var="u" items="${ userDonations}">
				<tr>
					<td>${u.user.fullName}</td>
					<td>${u.money } VND</td>
					<td>${u.created }</td>
					<td>${u.text }</td>
					<td>${u.status }</td>
				</tr>
			</c:forEach>
		</table>
		<c:forEach var="i" begin="1" end="${totalPages }">
			<a
				href="${pageContext.request.contextPath }/detailDonation?pageSize=${pageSize}&pageNumber=${i}&donationId=${donation.id}">
				${i } </a>
		</c:forEach>
	</f:form>
	<br>
	<input type="button" value="Quay lại"
		onclick="window.location.href='${pageContext.request.contextPath }/main'" />
	<script>
		document.addEventListener("DOMContentLoaded", function() {
			var btn = document.getElementsByClassName("donateButton")[0];
			var closeButtons = document.getElementsByClassName("close");
			var modal = document.getElementById("donateModal");
			btn.onclick = function() {
				var targetModal = document.querySelector(this
						.getAttribute("data-modal-target"));
				targetModal.style.display = "block";
			}
			for (var i = 0; i < closeButtons.length; i++) {
				closeButtons[i].onclick = function() {
					modal.style.display = "none";
				}
			}
			window.onclick = function(event) {
				if (event.target == modal) {
					modal.style.display = "none";
				}
				var pageSize = document.getElementById("pageSize");
				var userDonationForm = document
						.getElementById("userDonationForm");
				var keyword = document.querySelector('input[name="keyword"]');
				pageSize.addEventListener('change', function() {
					userDonationForm.submit();
				});
				keyword.addEventListener("keydown", function(event) {
					if (event.key === "Enter") {
						event.preventDefault;
						document.getElementById('pageNumber').value = '1';
						userDonationForm.submit();
					}
				});
			}
		});
	</script>
</body>
</html>