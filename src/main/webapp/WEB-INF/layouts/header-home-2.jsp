<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

        <div class="navbar-ct">
          <nav class="navbar sticky-top navbar-expand-lg navbar-light u-nav-bar">
              <a class="navbar-brand" href="#">
                  <img src="<c:url value="/static/image/image-app/logo-shop.jpg" />" alt="" width="80px" height="80px">
              </a>
              <button class="navbar-toggler" type="button" data-toggle="collapse"
                  data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                  aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
              </button>

              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto u-nav-bar-center">
                      <li class="nav-item active ">
                          <a class="nav-link u-word-color" href="<c:url value='/'/>">TRANG CHỦ <span
                                  class="sr-only">(current)</span></a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link u-word-color" href="<c:url value='/products/all-product'/>">SẢN PHẨM</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link u-word-color" href="#">DỊCH VỤ</a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link u-word-color" href="#">LIÊN HỆ</a>
                      </li>
                  </ul>
                  <ul class="navbar-nav">
                      <li class="nav-item active ">
                      	<c:choose>
				         <c:when test = "${not empty userLogin.username}">
				            <a class="nav-link u-word-color" href="<c:url value='/user/user-detail'/>">${userLogin.username }</a>
				         </c:when>
				         
				         <c:when test = "${empty userDTO.username}">
				            <a class="nav-link u-word-color" href="<c:url value='/sign-in'/>"> ${userDTO.username} ĐĂNG NHẬP </a>
				         </c:when>
				      </c:choose>
                      </li>
                      <li class="nav-item active ">
                      	<c:choose>
				         <c:when test = "${not empty userLogin.username}">
				            <a class="nav-link u-word-color" href="<c:url value='/sign-out'/>">ĐĂNG XUẤT</a>
				         </c:when>
				      </c:choose>
                          
                      </li>
                  </ul>
                  <a class="navbar-brand  count-cart" href="<c:url value="/order/cart" />">
                      <img src="<c:url value="/static/image/image-app/icons8-shopping-cart-64.png" />"alt="" width="50px" height="50px">
                      <c:if test="${order.getOrderDetailDTOs().size() > 0 }">
	                      <p id="amountItem">${order.getOrderDetailDTOs().size() }</p>
                      </c:if>
                      <c:if test="${order.getOrderDetailDTOs().size() <= 0 }">
	                      <p id="amountItem" hidden="true">${order.getOrderDetailDTOs().size() }</p>
                      </c:if>
                  </a>
              </div>
          </nav>
		</div>
