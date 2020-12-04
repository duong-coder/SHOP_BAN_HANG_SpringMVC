<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../layouts/head-home.jsp"></jsp:include>
<script type="text/javascript"
	src="<c:url value="/static/js/admin/product.js"/>"></script>
<link rel="stylesheet"
	href="<c:url value='/static/css/admin/style.css'/>">
<style>
body {
	height: 1000px;
}

.copyrights {
	margin-top: 50px;
}

.tbl-product {
	margin-top: 10px;
}
</style>
</head>
<body>
	<div class="page-container">
		<div class="left-content">
			<div class="mother-grid-inner">
				<!--header start here-->
				<jsp:include page="../../layouts/admin/header.jsp"></jsp:include>
				<!--heder end here-->
				<!-- script-for sticky-nav -->
				<script>
					$(document).ready(function() {
						var navoffeset = $(".header-main").offset().top;
						$(window).scroll(function() {
							var scrollpos = $(window).scrollTop();
							if (scrollpos >= navoffeset) {
								$(".header-main").addClass("fixed");
							} else {
								$(".header-main").removeClass("fixed");
							}
						});

					});
				</script>
				<!-- /script-for sticky-nav -->
				<!--inner block start here-->
				<div class="inner-block">
					<div class="product-block">
						<div class="pro-head">
							<h2>Products</h2>
						</div>
						<c:url var="urlAddProduct" value="/admin/add-product"></c:url>
						<a href="${urlAddProduct}">
							<button type="button" class="btn btn-success">
								Thêm sản phẩm
							</button>
						</a>
						<button type="button" id="btnDelete" class="btn btn-danger">Xóa</button>
						<table class="table table-hover tbl-product">
							<thead class="thead-dark">
								<tr>
									<th>STT</th>
									<th scope="col"><input class="select-item" id="selectAll" type="checkbox"></th>
									<th scope="col">Tên sản phẩm</th>
									<th scope="col">Giá tiền</th>
									<th scope="col">
										<div class="input-group mb-1">
											<!-- <div class="input-group-prepend">
												<button id="btn-category" class="btn btn-primary" type="button">Tìm</button>
											</div> -->
											<select class="custom-select" id="category">
												<option selected value="0">All</option>
												<c:forEach items="${categories }" var="category">
													<option value="${category.getId() }">${category.getName() }</option>
												</c:forEach>
											</select>
										</div>
									</th>
									<th scope="col">Hành động</th>
								</tr>
							</thead>
							<tbody class="list-product">
								<c:forEach items="${products }" var="product" varStatus="loop">
									<tr>
										<th>${loop.index + 1}<input type="text" class="masp" data="maSP" value="${product.maSp }" hidden></th>
										<td scope="row"><input class="select-item select-delete" type="checkbox"></td>
										<td>${product.tenSp }</td>
										<td>${product.gia}</td>
										<td>${product.getCategory().getName()}</td>
										<td>
											<a href="<c:url value="/admin/infor-product/${product.maSp }"/>">
												<button type="button" class="btn btn-primary btn-add-detail">Xem chi tiết</button>
											</a>
											<a href="<c:url value="/admin/edit-product/${product.maSp }"/>">
												<button type="button" class="btn btn-warning btn-update">Cập nhật
													sản phẩm</button>
											</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<jsp:include page="../../layouts/pagination.jsp"></jsp:include>

						<!-- <div class="clearfix"> </div> -->
					</div>
				</div>
				<!--inner block end here-->
				<!--copy rights start here-->
				<jsp:include page="../../layouts/admin/footer.jsp"></jsp:include>
				<!--COPY rights end here-->
			</div>
		</div>
		<!--slider menu-->
		<jsp:include page="../../layouts/admin/slidebar-menu.jsp"></jsp:include>
		<div class="clearfix"></div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/static/js/admin/scripts.js'/>"></script>
</body>
</html>