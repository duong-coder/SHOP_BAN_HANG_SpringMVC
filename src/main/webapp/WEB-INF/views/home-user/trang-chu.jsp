<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
	
	<jsp:include page="../../layouts/head-home.jsp"/>
	
    <link rel="stylesheet" href="<c:url value='/static/css/chi-tiet-san-pham.css'/>"> 
    <link rel="stylesheet" href="<c:url value='/static/css/trangchu.css'/>">

</head>

<body>
	
    <div class="container-fluid">
    	<jsp:include page="../../layouts/header-home.jsp"/>

        <div class="text-center u-margin-card-group">
            <div class="card-group ">
                <div class="card u-border-card">
                    <h2><img src="<c:url value="static/image/image-app/icons8-gold-medal-100.png" />" class="fa fa-home fa-3x"> </h2>
                    <div class="card-body">
                        <h3 class="card-title">CHẤT LƯỢNG</h3>
                        <p class="card-text">Chúng tôi cam kết mang sẽ đến cho các bạn chất lượng sản phẩm tốt nhất</p>
                    </div>
                </div>
                <div class="card u-border-card">
                    <h2><img src="<c:url value="static/image/image-app/icons8-money-box-100.png" />" class="fa fa-home fa-3x"> </h2>
                    <div class="card-body">
                        <h3 class="card-title">TIẾT KIỆM CHI PHÍ</h3>
                        <p class="card-text">Cam kết giá rẻ nhất Việt Nam giúp các bạn tiết kiệm hơn 20% cho từng sản
                            phẩm</p>
                    </div>
                </div>
                <div class="card u-border-card">
                    <h2><img src="<c:url value="static/image/image-app/icons8-car-100.png" />" class="fa fa-home fa-3x"> </h2>
                    <div class="card-body">
                        <h3 class="card-title">GIAO HÀNG</h3>
                        <p class="card-text">Cam kết giao hàng tận nơi trong ngày. Để mang sản phẩm đến cho
                            quý khách nhanh nhất</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="container text-center u-box-san-pham">
            <h2 class="u-title-sanpham">SẢN PHẨM HOT</h2>
            <div class="row row-cols-1 row-cols-md-4">
            	<c:forEach items="${productDTOs }" var="productDTO">
            		<div class="col mb-4">
                    <div class="card h-100">
                    	<a href="<c:url value="/products/${productDTO.maSp }" />">
	                        <img src="<c:url value="/imageProducts/${productDTO.tenAnh }" />" class="card-img-top u-image-san-pham"
	                            alt="..." width="253px" height="253px">
	                    </a>
                        <div class="card-body">
                            <h5 class="card-title">${productDTO.tenSp }</h5>
                            <p class="card-text" style="color: rgb(240, 109, 109);">${productDTO.gia }</p>
                        </div>
                    </div>
                </div>
            	</c:forEach>
            </div>
        </div>
        
        <jsp:include page="../../layouts/footer-home.jsp"/>
    </div>
</body>

</html>