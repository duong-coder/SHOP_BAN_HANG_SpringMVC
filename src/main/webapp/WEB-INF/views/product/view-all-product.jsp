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
	<h2>DANH SACH SAN PHAM</h2>
	<a href="<c:url value = '/admin/add-product' /> ">Them san pham</a>
		<table>
		<tr>
			<th>MA SP</th>
			<th>TEN SP</th>
			<th>GIA</th>
			<th>SO LUONG</th>
			<th>LUA CHON</th>
		</tr>
		<c:forEach items="${productDTOs }" var="productDTO">
			<tr>
				<td>${productDTO.maSp }</td>
				<td>${productDTO.tenSp }</td>
				<td>${productDTO.gia }</td>
				<td>${productDTO.soLuong }</td>
				<td>
					<a href="<c:url value='/admin/product-detail/${productDTO.maSp}'/>">Chi tiet</a>
					<a href="<c:url value='/admin/edit-product/${productDTO.maSp}'/>">Sua</a>
					<a href="<c:url value='/admin/delete-product/${productDTO.maSp}'/>">Xoa</a>
				</td>
			</tr>
				
		</c:forEach>
	</table>
	<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>