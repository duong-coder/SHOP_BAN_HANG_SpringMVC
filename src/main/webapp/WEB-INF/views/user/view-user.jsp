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
	
	<p>Id: ${userDTO.ID }</p>
	<p>TEN DANG NHAP: ${userDTO.username}</p>
	<p>HO TEN: ${userDTO.name }</p>
	<p>EMAIL: ${userDTO.email }</p>
	<p>SO DT: ${userDTO.phone }</p>
	<%-- <img src="<c:url value="/static/image/image1.png"/>" /> --%>
	
	<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>
