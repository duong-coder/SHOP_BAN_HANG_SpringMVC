<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="../../layouts/header.jsp"/>
	<jsp:include page="../../layouts/menu-bar.jsp"/>
	
	<c:url value="/admin/add-product-detail" var="urlAddProductDetail"/>
	<form action="${urlAddProductDetail }"
				method="POST" 
				enctype="multipart/form-data">
		MA SAN PHAM <br/>
		 <select id="productID" name="productID">
			<c:forEach items="${productDTOs }" var="productDTO">
				<option value="${productDTO.maSp }">${productDTO.maSp }</option>
			</c:forEach>
		</select>
		 <br/>
		TEN SAN PHAM <br/>
		 <input type="text" id="nameProduct" name="nameProduct" readonly="readonly"/> <br/>
		
		MAU SAC 
		<select name="colorID">
			<c:forEach items="${colorDTOs }" var="colorDTO">
				<option value="${colorDTO.id }">${colorDTO.color }</option>
			</c:forEach>
		</select>
		<br/>
		KICH CO
		<select name="sizeID">
			<c:forEach items="${sizeDTOs }" var="sizeDTO">
				<option value="${sizeDTO.id }">${sizeDTO.size }</option>
			</c:forEach>
		</select>
		<br/>
		SO LUONG <br/>
		 <input name="amount"/> <br/>
		 
		<br/>
		<button type="submit">Submit</button>
		
		<jsp:include page="../../layouts/footer.jsp"/>
	</form>
	<script type="text/javascript" src="<c:url value="/static/js/form-product-detail.js"/>"></script>
</body>
</html>