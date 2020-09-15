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
    
</head>
<body>
	<jsp:include page="../../layouts/header-home-2.jsp"/>
    
    <div class="container body-carts">
        <p class="my-cart">Đơn hàng của tôi</p>
        <div class="select-amount-cart">
            <label for="amount-cart">Hiển thị:</label>
            <select name="amount-cart" id="amount-cart">
                <option value="5">5 đơn hàng gần nhất</option>
                <option value="10">10 đơn hàng gần nhất</option>
                <option value="15">15 đơn hàng gần nhất</option>
            </select>
        </div>
        <div class="cart">
            <div class="row title-cart">
                <div class="col-10 id-date-cart">
                    <p class="id-cart">Đơn hàng:# ${order.maHD}</p>
                    <p class="date-cart">Đặt ngày ${order.date}</p>
                </div>
                <p class="col-2 text-center detail-cart"><a href="<c:url value="/order/detail/${order.maHD}" />">Chi tiết</a> </p>
            </div>
            <hr>
            <c:forEach items="${order.getOrderDetailDTOs() }" var="item">
            	<div class="row content-cart">
                <img src="<c:url value="/imageProducts/${item.getProductDetail().getProductDTO().getTenAnh() }" />" alt="" width="100px">
                <p class="col">${item.getProductDetail().getProductDTO().getTenSp() }</p>
                <p class="col">Số lượng: ${item.getAmount() }</p>
                <div class="col status-item-cart">
                    Đã giao hàng
                </div>
                <p class="col">Đã giao ngày 25 thg 6 2020</p>
            </div>
            </c:forEach>
            <%-- 
            <div class="row content-cart">
                <img src="<c:url value="/static/image/image-products/iphone-12-pro-max-600x600.jpg" />" alt="" width="100px">
                <p class="col">Iphone 12 Pro Max</p>
                <p class="col">Số lượng: 1</p>
                <p class="col status-item-cart">Đã giao hàng</p>
                <p class="col">Đã giao ngày 25 thg 6 2020</p>
            </div> --%>
        </div>
    </div>
    
    <jsp:include page="../../layouts/footer-home.jsp"/>
</body>
</html>