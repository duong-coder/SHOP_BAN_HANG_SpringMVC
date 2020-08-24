<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="../static/css/trangchu.css">
    <link rel="stylesheet" href="../static/css/chi-tiet-san-pham.css">

</head>

<body>
	
    <div class="container-fluid">
    	<jsp:include page="../../layouts/header-home.jsp"/>
        
        <div class="container body-product">
        <div class="row">
            <div class="col-3">
                    <img src="<c:url value="/imageProducts/${productDTO.tenAnh }"/>" alt="" width="250px" height="300px">
            </div>
            <div class="col-5">
                <p class="name-product">${productDTO.tenSp}</p>
                <hr>
                <p class="price-product" style="color: orangered;">${productDTO.gia}</p>
                <hr>
                <div class="props-product">
                    <p class="tilte">Màu sắc</p>
                    <ul>
                        <li style="color: white; background-color: rgb(56, 54, 54);">Đen</li>
                        <li style="color: white; background-color: rgb(111, 111, 247);">Xanh</li>
                        <li style="background-color: whitesmoke;">Trắng</li>
                    </ul>
                </div>
                <div class="props-product">
                    <p>Loại</p>
                    <ul>
                        <li style="background-color: whitesmoke;">32GB</li>
                        <li style="background-color: whitesmoke;">64GB</li>
                        <li style="background-color: whitesmoke;">128GB</li>
                    </ul>
                </div>
                <div class="amount-product">
                    <label for="quantity">Số lượng</label>
                    <input id="quantity" type="number" min="1" value="1" max="${productDTO.soLuong}"> <br>
                </div>
                <div class="add-to-cart text-center ">
                    <button type="button" class="btn btn-warning">Thêm vào giỏ</button>
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
</body>

</html>