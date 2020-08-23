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
	
	<c:url value="/admin/edit-user" var="urlEditUser" />
	<form:form action="${urlEditUser }" method="post" modelAttribute="userDTO">
	<form:hidden path="ID" />
	<p>TEN DANG NHAP</p>
	<form:input path="username" />
	<p style="color: red;">
		<form:errors path="username"></form:errors>
	</p>
	<p>MAT KHAU</p>
	<form:input path="pass" />
	<p style="color: red;">
		<form:errors path="pass"></form:errors>
	</p>
	<p>HO TEN</p>
	<form:input path="name" />
	<p>GIOI TINH</p>
	Nam:<form:radiobutton path="gender" value="true"/>
	Nu:<form:radiobutton path="gender" value="false"/>
	<p>EMAIL</p>
	<form:input path="email" />
	<p>PHONE</p>
	<form:input path="phone" />
	<p>DIA CHI</p>
	<form:textarea path="address"/>
	<p>ROLE</p>
	Khach:<form:radiobutton path="role" value="ROLE_KHACH"/>
	Admin:<form:radiobutton path="role" value="ROLE_ADMIN"/>
	<br/>
	<button type="submit">Submit</button>
	
	<jsp:include page="../../layouts/footer.jsp"/>
</form:form>
</body>
</html>
