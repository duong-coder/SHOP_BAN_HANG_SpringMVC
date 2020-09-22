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
    
    <link rel="stylesheet" href="<c:url value='/static/css/trangchu.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/css/gio-hang.css' />">
    <link rel="stylesheet" href="<c:url value='/static/css/chi-tiet-san-pham.css'/>">
    <%-- <link rel="stylesheet" href="<c:url value='/static/css/don-hang.css'/>"> --%>
    
</head>

<body>

    <jsp:include page="../../layouts/header-home-2.jsp"/>

    <div class="container body-order">
        <div class="row">
            <div class="col-7">
                <div class="row select-all-item">
                    <div class="col-0.5 checkbox-item">
                        <input type="checkbox" name="selectItem" id="allItem">
                    </div>
                    <div class="col-10">
                        <span class="text-title">CHỌN TẤT CẢ (${order.getOrderDetailDTOs().size() } SẢN PHẨM)</span>
                    </div>
                    <div class="col-1.5" id="deleteAll">
                        <i class="fa fa-trash-o" style="margin-right: 10px; font-size:24px; color: #9e9e9e;"></i>
                        <span class="text-title">XÓA</span>
                    </div>
                </div>
                <hr>
                <c:forEach items="${order.getOrderDetailDTOs() }" var="item" >
                	<div class="row item-order">
	                    <div class="col-1 checkbox-item">
	                        <input type="checkbox" name="selectItem" id="item${order.getOrderDetailDTOs().indexOf(item) }">
	                    </div>
	                    <div class="col-2 image-item">
	                    	<a href="<c:url value="/products/${item.getProductDetail().getProductDTO().getMaSp() }" />">
	                        	<img src="<c:url value="/imageProducts/${item.getProductDetail().getProductDTO().getTenAnh() }" />" alt="" width="90px" height="90px">
	                    	</a>
	                    </div>
	                    <div class="col-5">
	                        <p>${item.getProductDetail().getProductDTO().getTenSp() }</p>
	                        <p class="infor-item text-title">Màu sắc: ${item.getProductDetail().getColor().getColor() }, Loại: ${item.getProductDetail().getSize().getSize() }</p>
	                    </div>
	                    <div class="col-2 price-item">
	                        <p style="color: orangered;">${item.getProductDetail().getProductDTO().getGia()}</p>
	                        <i class="fa fa-trash-o deleteItem" id="deleteItem${order.getOrderDetailDTOs().indexOf(item) }" style="font-size:24px"></i>
	                    </div>
	                    <div class="col-2">
	                        <input class="amout-item" type="number" value="${item.getAmount() }">
	                    </div>
	                </div>
	                <hr>
                </c:forEach>
            </div>
            <div class="col-5 confirm-order">
                <div class="place-order">
                    <p class="text-title">ĐỊA ĐIỂM</p>
                    <p><i class="fa fa-map-marker" style="font-size: 24px;"></i> Tô Hiệu</p>
                </div>
                <hr>
                <div class="infor-order">
                    <p>Thông tin đơn hàng</p>
                    <div class="money-order">
                        <p class="text-title">Tạm tính:</p>
                        <div>
                            <span>0 đ</span>
                        </div>
                    </div>
                    <div class="money-order">
                        <p class="text-title">Phí giao hàng: </p>
                        <span>0 đ</span>
                    </div>
                    <div class="money-order sum-money-order">
                        <p>Tổng cộng: </p>
                        <span style="color: orangered;">0 đ</span>
                    </div>
                    <div class="btn-buy-order">
                        <button class="btn btn-warning">XÁC NHẬN GIỎ HÀNG</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="../../layouts/footer-home.jsp"/>
    <script type="text/javascript" src="<c:url value="/static/js/gio-hang.js"/>"></script>
</body>

</html>