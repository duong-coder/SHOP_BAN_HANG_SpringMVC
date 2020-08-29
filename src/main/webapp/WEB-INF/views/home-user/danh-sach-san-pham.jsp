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
	
    <link rel="stylesheet" href="../static/css/trangchu.css">
	<style type="text/css">
		.navbar-ct{
		    background-color: black;
		}
		.category{
		    padding: 10px;
		    margin-top: 20px;
		    width: 1140px;
		    background-color: #f8f9fa;
		    border: 1px solid black ;
		}
		.category ul{
		    padding: 0px;
		    margin: 0px;
		    list-style: none;
		    display: flex;
		    justify-content: center;
		    align-items: center;
		    align-content: space-around;
		}
		.category ul li{
		    padding-left: 50px;
		    padding-right:50px;
		    /* margin-left: 40px; */
		    /* margin-right: 40px; */
		    font-size: large;
		    border-left: 1px solid black;
		    border-right: 1px solid black;
		}
		.category-select{
		    background-color: rgb(206, 200, 200);
		} 
	</style>
</head>	

<body>
	
    <div class="container-fluid">
    	<jsp:include page="../../layouts/header-home.jsp"/>
        
        <div class="container category">
            <ul>
                <li class="category-select">
                    <img src="<c:url value="/static/image/image-app/logo-apple.png" />" alt="" width="48px" height="48px">
                    Apple
                </li>
                <li>
                    <img src="<c:url value="/static/image/image-app/logo-xiaomi.png" />" alt="" width="48px" height="48px">
                    Xiaomi
                </li>
                <li>
                    <img src="<c:url value="/static/image/image-app/logo-samsung.jpg" />" alt="" width="48px" height="48px">
                    SamSung
                </li>
                <li>
                    <img src="<c:url value="/static/image/image-app/logo-oppo.jpg" />" alt="" width="48px" height="48px">
                    Oppo
                </li>
                <li>
                    <img src="<c:url value="/static/image/image-app/logo-oneplus.png" />" alt="" width="48px" height="48px">
                    OnePlus
                </li>
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