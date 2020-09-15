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
	
	<link rel="stylesheet" href="<c:url value='/static/css/chi-tiet-san-pham.css'/>"> 
    <link rel="stylesheet" href="<c:url value="/static/css/trangchu.css"/>">
	
</head>	

<body>
	
    <div class="container-fluid">
    	<jsp:include page="../../layouts/header-home.jsp"/>
        
        <div class="container category">
            <ul>
            	<c:forEach items="${categoryDTOs }" var="category">
            		<li id="category-${category.id }" class="">
            			<a href='<c:url value="/products/category/${category.id }" />'>
		                    <img src="<c:url value="/static/image/image-app/${category.image }" />" alt="" width="48px" height="48px">
		                    ${category.name }
	                    </a>
	                </li>
            	</c:forEach>
            </ul>
   		</div>
        
        <div class="container text-center u-box-san-pham">
            <h2 class="u-title-sanpham">TẤT CẢ SẢN PHẨM</h2>
            <div class="row row-cols-1 row-cols-md-4">
            	<c:forEach items="${productDTOs }" var="productDTO">
            		<div class="col mb-4">
	                    <div class="card h-100">
	                    	<a href="<c:url value="/products/${productDTO.maSp }" />">
	                        	<img src="<c:url value="/imageProducts/${productDTO.tenAnh }" />" class="card-img-top u-image-san-pham"
	                            	alt="..." width="253px" height="253px">
	                        </a>
	                        <div class="card-body">
	                            <h5 class="card-title">${productDTO.tenSp }</h5>
	                            <p class="card-text" style="color: rgb(240, 109, 109);">${productDTO.gia }</p>
	                        </div>
                    	</div>
                	</div>
            	</c:forEach>
            </div>
        </div>
        
        <jsp:include page="../../layouts/footer-home.jsp"/>
    </div>
</body>

</html>