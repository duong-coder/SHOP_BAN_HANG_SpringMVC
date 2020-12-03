<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="../../layouts/head-home.jsp"></jsp:include>
<script type="text/javascript"
	src="<c:url value="/static/js/admin/add-product.js"/>"></script>
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
						
						<div class="container">
                            <div class="row justify-content-center">
                                <div class="col-8">
                                    <form:form action="${urlAddProduct }" modelAttribute="productDTO" method="POST" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label for="maSP">Mã sản phẩm</label>
                                            <form:input type="text" path="maSp" class="form-control" id="maSP" aria-describedby="MaSPHelp"/>
                                            <small id="MaSPHelp" class="form-text text-muted" style="color:red;"><form:errors path="tenSp" /></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="tenSP">Tên sản phẩm</label>
                                            <form:input type="text" path="tenSp" class="form-control" id="tenSP" aria-describedby="TenSPHelp"/>
                                            <small id="TenSPHelp" class="form-text text-muted" style="color:red;"><form:errors path="tenSp" /></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="hangSP">Hãng</label>
                                            <form:select class="form-control" path="category.id" id="hangSP" name="categoryID">
												<c:forEach items="${categoryDTOs }" var="categoryDTO">
													<form:option value="${categoryDTO.id }">${categoryDTO.name } ${category.id }</form:option>
												</c:forEach>
											</form:select>
                                        </div>
                                        <div class="form-group">
                                            <label for="giaSP">Giá sản phẩm</label>
                                            <form:input type="number" path="gia" class="form-control" id="giaSP" aria-describedby="GiaHelp"/>
                                            <small id="GiaHelp" class="form-text text-muted" style="color:red;"><form:errors path="gia" /></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="moTa">Mô tả sản phẩm</label>
                                            <form:textarea type="text" path="moTa" class="form-control" id="moTa" aria-describedby="MoTaHelp"/>
                                            <small id="MoTaHelp" class="form-text text-muted" style="color:red;"><form:errors path="moTa" /></small>
                                        </div>
                                        <div class="form-group">
                                            <label for="hinhAnh">Hình ảnh</label>
                                            <input type="file"  name="file"class="form-control-file" id="hinhAnh">
                                        </div>
                                        <div class="details">
	                                        <div class="detail" hidden>
												<hr>				
												<input type="text" name="idctsp" value="${detailDTO.id}" hidden/>	
		                                        <div class="form-row">
		                                            <div class="form-group col-md-3">
		                                                <label>Màu sắc</label>
		                                                <select class="form-control" name="colorID">
															<c:forEach items="${colorDTOs }" var="colorDTO">
															<option value="${colorDTO.id }">${colorDTO.color }</option>
															</c:forEach>
														  </select>
		                                            </div>
		                                            <div class="form-group col-md-3">
		                                                <label >Dung lượng</label>
		                                                <select class="form-control" name="sizeID">
															<c:forEach items="${sizeDTOs }" var="sizeDTO">
																<option value="${sizeDTO.id }">${sizeDTO.size }</option>
															</c:forEach>
														  </select>
		                                            </div>
		                                            <div class="form-group col-md-3">
		                                                <label >Số lượng</label>
		                                                <input type="number" class="form-control" name="amount">
		                                            </div>
		                                            <div class="form-group col-md-3">
		                                            	<label for="">Loại bỏ</label><br>
		                                            	<button type="button" class="btn btn-warning btn-delete">Xóa</button>
		                                            </div>
		                                        </div>
	                                        </div>
	                                        <c:if test="${not empty productDTO.detailDTOs}">
	                                        	<c:forEach items="${productDTO.detailDTOs }" var="detailDTO" varStatus="i">
	                                        		<div class="detail">
														<hr>
														<input type="text" name="idctsp" value="${detailDTO.id}" hidden/>				
				                                        <div class="form-row">
				                                            <div class="form-group col-md-3">
				                                                <label>Màu sắc</label>
				                                                <select class="form-control" name="colorID">
																	<c:forEach items="${colorDTOs }" var="colorDTO">
																		<c:choose>
																			<c:when test="${colorDTO.id == detailDTO.getColor().id }">
																				<option value="${colorDTO.id }" selected="selected">${colorDTO.color }</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${colorDTO.id }">${colorDTO.color }</option>
																			</c:otherwise>
																		</c:choose>
																	</c:forEach>
																  </select>
				                                            </div>
				                                            <div class="form-group col-md-3">
				                                                <label>Dung lượng</label>
				                                                <select class="form-control" name="sizeID">
				                                                	<c:forEach items="${sizeDTOs }" var="sizeDTO">
																		<c:choose>
																			<c:when test="${sizeDTO.id == detailDTO.getSize().id }">
																				<option value="${sizeDTO.id }" selected="selected">${sizeDTO.size }</option>
																			</c:when>
																			<c:otherwise>
																				<option value="${sizeDTO.id }">${sizeDTO.size }</option>
																			</c:otherwise>
																		</c:choose>
															  		</c:forEach>
																  </select>
				                                            </div>
				                                            <div class="form-group col-md-3">
				                                                <label>Số lượng</label>
				                                                <input type="number" class="form-control" value="${detailDTO.amount }" name="amount"/>
				                                            </div>
				                                            <div class="form-group col-md-3">
				                                            	<label for="">Loại bỏ</label><br>
				                                            	<button type="button" class="btn btn-warning btn-delete">Xóa</button>
				                                            </div>
				                                        </div>
			                                        </div>
	                                        	</c:forEach>
		                                        
	                                        </c:if>
                                        </div>
										<button type="button" id="btnAddDetail" class="btn btn-primary">Thêm chi tiết >></button><br> <br>
										<hr>
										<c:choose>
											<c:when test="${not empty productDTO.maSp}">
												<button type="button" id="btnUpdateProduct" class="btn btn-success">Cập nhật sản phẩm</button>
											</c:when>
											<c:otherwise>
												<button type="button" id="btnAddProduct" class="btn btn-success">Thêm sản phẩm</button>
											</c:otherwise>
										</c:choose>	
                                    </form:form>
                                </div>

                            </div>
                        </div>
						
						<div class="clearfix"> </div>
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