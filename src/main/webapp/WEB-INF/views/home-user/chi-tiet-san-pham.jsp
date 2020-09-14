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

    <link rel="stylesheet" href="<c:url value='/static/css/trangchu.css'/>">
    <link rel="stylesheet" href="<c:url value='/static/css/chi-tiet-san-pham.css'/>">

</head>

<body>
	
    <div class="container-fluid">
    	<%-- <jsp:include page="../../layouts/header-home.jsp"/> --%>
        <jsp:include page="../../layouts/header-home-2.jsp"/>
        
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
        
        <div class="container body-product">
        <div class="row">
            <div class="col-3">
                    <img src="<c:url value="/imageProducts/${productDTO.tenAnh }"/>" alt="" width="250px" height="300px">
            </div>
            <div class="col-5">
                <p class="name-product">${productDTO.tenSp}</p>
                <input type="hidden" id="codeProduct" value="${productDTO.maSp }" />
                <hr>
                <p class="price-product" style="color: orangered;">${productDTO.gia} đ</p>
                <hr>
                <div class="props-product">
                    <p class="tilte">Màu sắc</p>
                    <ul>
                    	<c:forEach items="${colorProductDetailDTOs }" var="colorDTO" varStatus="i">
                    		<li style="border: solid 1px black;">
							    <c:choose>
							         <c:when test = "${i.index == 0}">
							            <input type="radio" value="${colorDTO.id }" checked="checked" id="color${i.index }" name="color"/>
							         </c:when>

							         <c:otherwise>
							            <input type="radio" value="${colorDTO.id }" id="color${i.index }" name="color"/>
							         </c:otherwise>
							      </c:choose>
                    			<label for="color${i.index }" >${colorDTO.color}</label>
                    		</li>
                    	</c:forEach>
                    </ul>
                </div>
                <div class="props-product">
                    <p>Loại</p>
                    <ul>
                    	<c:forEach items="${sizeProductDetailDTOs }" var="sizeDTO" varStatus="i">
                    		<li style="border: solid 1px black;">
                    			<c:choose>
							         <c:when test = "${i.index == 0}">
							            <input type="radio" value="${sizeDTO.id }" checked="checked" id="size${i.index }" name="size"/>
							         </c:when>

							         <c:otherwise>
							            <input type="radio" value="${sizeDTO.id }" id="size${i.index }" name="size"/>
							         </c:otherwise>
							      </c:choose>
                    			<label for="size${i.index }" >${sizeDTO.size}</label>
                    		</li>
                    	</c:forEach>
                    </ul>
                </div>
                <div class="amount-product">
                    <label for="quantity">Số lượng</label>
                    <input id="quantity" type="number" min="1" value="1" 
                    	max="2"> <br>
                </div>
               	<p>Số lượng trong kho: <span id="amountProductInStock"></span> </p>
                <div class="add-to-cart text-center ">
                    <button id="btn-add-to-cart" type="button" class="btn btn-warning">Thêm vào giỏ</button>
                </div>
            </div>
            <div class="col-4 infor-product">
                <p class="tilte">Mô tả</p>
                <table>
	                <c:forEach items="${inforProducts }" var="item">
	                	<tr>
	                        <td>${item.getKey()}</td>
	                        <td class="infor-detail">${item.getValue()}</td>
	                    </tr>
	                    <tr>
	                        <td><hr></td>
	                    </tr>
	                </c:forEach>
                </table>
            </div>
        </div>
    </div>
        
        <jsp:include page="../../layouts/footer-home.jsp"/>
    </div>
    <script type="text/javascript" src="<c:url value="/static/js/chi-tiet-san-pham.js"/>">
	</script>
</body>

</html>