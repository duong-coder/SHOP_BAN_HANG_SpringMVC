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
.space{
	margin-top: 0px;
	margin-bottom: 5px;
}
#name-product{
	font-weight: 500;
	line-height: 1.2;
	
}
#category{
	margin-bottom: 20px;
	color: #6c757d !important;
}
#price{
	margin-bottom: 20px;
	font-weight: bold;
	color: #4f4f4f;
}
#describe{
	margin-bottom: 20px;
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
						<div class="body-detail">
							<div class="row">
							    <div class="col-sm text-center">
							      <img class="img-fluid" alt="anh san pham" src="<c:url value='/imageProducts/${productDTO.tenAnh }' />">
							    </div>
							    <div class="col-sm">
							      <h2 class="space" id="name-product">${productDTO.tenSp }</h2>
							      <p class="space" id="category">${productDTO.category.name }</p>
							      <p class="space" id="price">${productDTO.gia } VND</p>
							      <p class="space" id="describe">${productDTO.moTa }</p>
							      <div class="details">
							      	<table class="table table-hover">
									  <thead>
									    <tr>
									      <th scope="col">STT</th>
									      <th scope="col">Màu sắc</th>
									      <th scope="col">Dung lượng</th>
									      <th scope="col">Số lượng</th>
									    </tr>
									  </thead>
									  <tbody>
									  	<c:forEach items="${productDTO.detailDTOs }" var="detail" varStatus="i">
										  	<tr>
										  		<th scope="row">${i.index + 1 }</th>
												<td>${detail.color.color }</td>
											    <td>${detail.size.size }</td>
											    <td>${detail.amount }</td>
										    </tr>
									  	</c:forEach>
									  </tbody>
									</table>
							      </div>
							    </div>
							  </div>
						</div>	
						<%-- <jsp:include page="../../layouts/pagination.jsp"></jsp:include> --%>

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