<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../layouts/header.jsp"/>
	<jsp:include page="../../layouts/menu-bar.jsp"/>
	
	<c:url value="/admin/edit-product" var="urlEditProduct"/>
	<form:form action="${urlEditProduct }" modelAttribute="productDTO" 
				method="POST" 
				enctype="multipart/form-data">
		MA SAN PHAM <br/>
		 <form:input path="maSp"/> <br/>
		 
		TEN SAN PHAM <br/>
		 <form:input path="tenSp"/> <br/>
		<p style="color:red;"><form:errors path="tenSp" /> </p>
		
		MO TA <br/>
		<form:input path="moTa"/> <br/>
		
		GIA <br/>
		<form:input path="gia"/> <br/>
		<p style="color:red;"><form:errors path="gia" /> </p>
		
		SO LUONG <br/>
		<form:input path="soLuong"/> <br/>
		
		<form:hidden path="tenAnh"/> <br/>		
		
		Hinh anh <br/>
		<input type="file" name="file" /> <br>
		
		<button type="submit">Submit</button>
	</form:form>
	
	<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>