<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%-- <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../../layouts/header.jsp"/>
	<jsp:include page="../../layouts/menu-bar.jsp"/>

	<hr/>
	<p>
		<a href=" <c:url value="/admin/add-user"/> ">Them khach hang</a>
	</p>
	<table>
		<tr>
			<th>ID</th>
			<th>TEN DANG NHAP</th>
			<th>HO TEN</th>
			<th>EMAIL</th>
			<th>LUA CHON</th>
		</tr>
		<c:forEach items="${userDTOs}" var="user">
			<tr>
				<td>${user.ID }</td>
				<td>${user.username }</td>
				<td>${user.name }</td>
				<td>${user.email }</td>
				<td>
					<a href="<c:url value="/admin/user-detail/${user.ID }"/>">Chi tiet</a>
					<a href="<c:url value="/admin/edit-user/${user.ID}"/>">Sua</a>
					<a href="<c:url value="/admin/delete-user/${user.ID }"/>">Xoa</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>
	<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>