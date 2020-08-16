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
	
	MA SP: ${productDTO.maSp } <br/>
	TEN SP:  ${productDTO.tenSp } <br/>
	MO TA: ${productDTO.moTa } <br/>
	GIA: ${productDTO.gia } <br/>
	SO LUONG: ${productDTO.soLuong } <br/>
	HINH: <img src="<c:url value='/imageProducts/${productDTO.tenAnh }' />" >
	<%-- <img alt="" src="">
	Image: <img src="<c:url value='/static/ImageProducts/${productDTO.imageUrl }' />" > --%>
	
	<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>