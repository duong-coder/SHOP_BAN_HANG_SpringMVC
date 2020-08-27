<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../layouts/header.jsp"/>
	<jsp:include page="../../layouts/menu-bar.jsp"/>
	<h2>DANH SACH CHI TIET SAN PHAM </h2>
	<h3>-${productDetails[0].getProductDTO().maSp }-${productDetails[0].getProductDTO().tenSp }</h3>
	<a href="<c:url value = '/admin/add-product-detail' /> ">Them chi tiet san pham</a>
		<table>
		<tr>
			<th>KICH CO</th>
			<th>MAU SAC</th>
			<th>SO LUONG</th>
			<th>LUA CHON</th>
		</tr>
		<c:forEach items="${productDetails }" var="productDetail">
			<tr>
				<td>${productDetail.getSize().size }</td>
				<td>${productDetail.getColor().color }</td>
				<td>${productDetail.amount }</td>
				<td>
					<a href="<c:url value='/admin/edit-product-detail/${productDetails[0].getProductDTO().maSp }/${productDetail.getColor().id }/${productDetail.getSize().id }'/>">Sua</a>
					<a href="<c:url value='/admin/delete-product-detail/'/>">Xoa</a>
				</td>
			</tr>
				
		</c:forEach>
	</table>
	<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>