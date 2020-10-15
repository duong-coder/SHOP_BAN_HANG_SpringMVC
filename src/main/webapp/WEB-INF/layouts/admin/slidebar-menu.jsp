<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="sidebar-menu">
	<div class="logo">
		<a href="#" class="sidebar-icon"> <span class="fa fa-bars"></span>
		</a> <a href="#"> <span id="logo"></span> <!--<img id="logo" src="" alt="Logo"/>-->
		</a>
	</div>
	<div class="menu">
		<ul id="menu">
			<li id="menu-home"><a href="index.html"><i
					class="fa fa-tachometer"></i><span>Dashboard</span></a></li>
			<li><a href="#"><i class="fa fa-product-hunt"></i><span>Products</span><span
					class="fa fa-angle-right" style="float: right"></span></a>
				<ul>
					<li><a href="<c:url value="/admin/all-product"/>">Product</a></li>
					<li><a href="product-detail.html">Detail</a></li>
					<li><a href="color.html">Color</a></li>
					<li><a href="memory.html">Memory</a></li>
				</ul></li>
			<li><a href="customer.html"><i class="fa fa-user"></i><span>Customer</span></a></li>
			<li><a href="order.html"><i class="fa fa-shopping-cart"></i><span>Order</span></a></li>
			<li><a href="#"> <i class="fa fa-cogs"></i> <span>Setting</span>
					<span class="fa fa-angle-right" style="float: right"></span>
			</a>
				<ul>
					<li><a href="grids.html">Grids</a></li>
					<li><a href="portlet.html">Portlets</a></li>
				</ul></li>
		</ul>
	</div>
</div>