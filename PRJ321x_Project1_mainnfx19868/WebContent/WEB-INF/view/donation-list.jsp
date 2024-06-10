<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Quản trị</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/static/admin1/assets/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/static/admin1/assets/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
	crossorigin="anonymous"></script>

<script
	src="${pageContext.request.contextPath}/static/admin1/assets/js/datatables-simple-demo.js"></script>

<script
	src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
</head>

<body class="sb-nav-fixed">
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<nav th:fragment="html_nav"
			class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
			<!-- Navbar Brand-->
			<a class="navbar-brand ps-3" href="${pageContext.request.contextPath}/admin">QUẢN TRỊ</a>
			<!-- Sidebar Toggle-->
			<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
				id="sidebarToggle" href="#!">
				<i class="fas fa-bars"></i>
			</button>
			<!-- Navbar Search-->
			<form
				class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

			</form>
			<!-- Navbar-->
			<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle"
					href="${pageContext.request.contextPath}/main" role="button"><i
						class="fas fa-user fa-fw"></i><span> Trang chủ</span></a></li>
			</ul>
		</nav>
	</nav>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<div th:fragment="html_menu" id="layoutSidenav_nav">
				<nav class="sb-sidenav accordion sb-sidenav-dark"
					id="sidenavAccordion">
					<div class="sb-sidenav-menu">
						<div class="nav">
							<a class="nav-link"
								href="${pageContext.request.contextPath}/admin/listUser">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý người dùng
							</a> <a class="nav-link"
								href="${pageContext.request.contextPath}/admin/listDonation">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý đợt quyên góp
							</a>
						</div>
					</div>

				</nav>
			</div>
		</div>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Danh sách đợt quyên góp</h1>
					<c:if test="${not empty message }">
						<div style="color: green">${message }</div>
					</c:if>
					<div class="card mb-4">
						<div class="card-header">
							<button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#exampleModalAdd">
								Thêm mới</button>
							<!-- Modal Add-->
							<div class="modal fade" id="exampleModalAdd" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabelll">Thêm
												mới</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<f:form modelAttribute="user"
												action="${pageContext.request.contextPath}/admin/addDonation">
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Mã đợt
															quyên góp:</label> <input type="text" class="form-control"
															id="addname" name="code" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Tên
															đợt quyên góp:</label> <input type="Text" class="form-control"
															id="addcost" name="name" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Ngày
															bắt đầu:</label> <input type="date" class="form-control"
															id="addname" name="startDate" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Ngày
															kết thúc:</label> <input type="date" class="form-control"
															id="addcost" name="endDate" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Tổ
															chức:</label> <input type="text" class="form-control"
															id="addname" name="organizationName" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Số
															điện thoại:</label> <input type="number" class="form-control"
															id="addcost" name="phoneNumber" required>
													</div>
													<div class="col-12">
														<label for="ct_id" class="col-form-label">Nội
															dung:</label>
														<textarea name="description" placeholder="Nhập nội dung"
															class="form-control" cols="50" rows="5"></textarea>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Đóng</button>
													<button type="submit" class="btn btn-primary">Thêm
													</button>
												</div>
											</f:form>
										</div>

									</div>
								</div>
							</div>
							<!-- Modal Add-->
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr style="background-color: gray !important;">
										<th>Mã</th>
										<th>Tên</th>
										<th>Ngày bắt đầu</th>
										<th>Ngày kết thúc</th>
										<th>Tổ chức</th>
										<th>Số điện thoại</th>
										<th>Tổng tiền</th>
										<th>Trạng thái</th>
										<th style="width: 220px">Hành động</th>
									</tr>
								</thead>
								<tfoot>
									<tr>

									</tr>
								</tfoot>
								<tbody>
								<input type="hidden" value="${donations.size()}" id="dodai" />
									<c:forEach var="d" items="${donations}">
									<tr>
											<td>${d.code }</td>
											<td>${d.name }</td>
											<td>${d.startDate }</td>
											<td>${d.endDate }</td>
											<td>${d.organizationName }</td>
											<td>${d.phoneNumber }</td>
											<td>${d.money }</td>
											<td>${statusDonation.getStatusString(d.status)}</td>
											<td style="">
												<input type="button" style="width: 105px; visibility:${d.status == 3 ? 'hidden':'visible'}"
													class="btn btn-primary mt-1" data-bs-toggle="modal"
													data-bs-target="#exampleModal${d.id }" value="Cập nhật"> 
												
												<form action="${pageContext.request.contextPath }/admin/detailDonation"
													style="margin-left: 110px; margin-top: -38px">
													<input type="hidden" class="form-control" id="id"
														name="donationId" value="${d.id }">
													<button type="submit" style="width: 105px"
														class="btn btn-warning">Chi tiết</button>
												</form>
												<button type="button" style="width: 105px; visibility: ${d.status!=0 ? 'hidden': 'visible' }"
													
													class="btn btn-danger mt-1" data-bs-toggle="modal"
													data-bs-target="#idModelDel${d.id }">Xóa</button> 
												<f:form
													action="${pageContext.request.contextPath }/admin/changeStatusDonation"
													style="margin-left: 110px; margin-top: -38px">
													<input type="hidden" class="form-control" id="id"
														name="donationId" value="${d.id }">
													<button type="submit" style="width: 105px"
														${d.status==3? "hidden='hidden'": " "}
														class="btn btn-success">${statusDonation.getButtonLabel(d.status) }</button>
												</f:form> 
												<div class="modal fade" id="idModelDel${d.id}" tabindex="-1"
													aria-labelledby="exampleModalLabel" aria-hidden="true">
													<div class="modal-dialog">
														<div class="modal-content">
															<div class="modal-header">
																<h5 class="modal-title" id="exampleModalLabel">Bạn
																	chắc chắn muốn xóa ?</h5>
																<button type="button" class="btn-close"
																	data-bs-dismiss="modal" aria-label="Close"></button>
															</div>
															<div class="modal-body">
																Đợt quyên góp : <span>${d.name}</span>
																<form
																	action="${pageContext.request.contextPath}/admin/deleteDonation">
																	<input type="hidden" name="donationId" value="${d.id }" />
																	<div class="modal-footer" style="margin-top: 20px">
																		<button type="button" class="btn btn-secondary"
																			data-bs-dismiss="modal">Close</button>
																		<button type="submit" class="btn btn-danger">Xóa</button>

																	</div>
																</form>

															</div>

														</div>
													</div>
												</div>
											</td>
										</tr>
										<div class="modal fade" tabindex="-1" id="exampleModal${d.id}"
											aria-labelledby="exampleModalLabel" aria-hidden="true">
											<div class="modal-dialog modal-lg ">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabell">Cập
															nhật</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														<f:form modelAttribute="donation"
															action="${pageContext.request.contextPath }/admin/addDonation">
															<input type="hidden" name="id" value="${d.id }">
															<div class="row">
																<div class="col-6">
																	<label for="addname" class="col-form-label">Mã
																		đợt quyên góp:</label> <input type="text" class="form-control"
																		id="addname" name="code" value="${d.code }" readonly
																		required>
																</div>
																<div class="col-6">
																	<label for="addcost" class="col-form-label">Tên
																		đợt quyên góp:</label> <input type="text" class="form-control"
																		id="addcost" value="${d.name }" name="name" required>
																</div>
															</div>
															<div class="row">
																<div class="col-6">
																	<label for="addname" class="col-form-label">Ngày
																		bắt đầu:</label> <input type="date" class="form-control"
																		id="addname" value="${d.startDate }" name="startDate"
																		required>
																</div>
																<div class="col-6">
																	<label for="addcost" class="col-form-label">Ngày
																		kết thúc:</label> <input type="date" class="form-control"
																		id="addcost" value="${d.endDate }" name="endDate"
																		required>
																</div>
															</div>
															<div class="row">
																<div class="col-6">
																	<label for="addname" class="col-form-label">Tổ
																		chức:</label> <input type="text" class="form-control"
																		id="addname" value="${ d.organizationName}"
																		name="organizationName" required>
																</div>
																<div class="col-6">
																	<label for="addcost" class="col-form-label">Số
																		điện thoại:</label> <input type="number" class="form-control"
																		id="addcost" value="${d.phoneNumber }"
																		name="phoneNumber" required>
																</div>
																<div class="col-12">
																	<label for="ct_id" class="col-form-label">Nội
																		dung:</label>
																	<textarea name="description" class="form-control"
																		cols="50" rows="5">${d.description }</textarea>
																</div>
															</div>
															<div class="modal-footer">
																<button type="button" class="btn btn-secondary"
																	data-bs-dismiss="modal">Đóng</button>
																<button type="submit" class="btn btn-primary">Lưu
																</button>
															</div>
														</f:form>
													</div>

												</div>
											</div>
										</div>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>

			</main>
			<script>

      ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
        console.log("da" + eidt);
      })
              .catch(error => {
                console.error(error);
              });

    </script>
			<script>

      var dodai = document.getElementById("dodai").value;
      var a = parseInt(dodai);
      for(var i = 1;i<=a+10;i++){
        var name = "#editor"  + i
        ClassicEditor.create(document.querySelector(name)).then(eidt => {
          console.log("da" + eidt);
        })
                .catch(error => {
                  console.error(error);
                });
      }


    </script>
			<footer class="py-4 bg-light mt-auto"> </footer>
		</div>
	</div>

	<script src="js/JQuery3.3.1.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script src="js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script src="js/datatables-simple-demo.js"></script>

</body>

</html>
