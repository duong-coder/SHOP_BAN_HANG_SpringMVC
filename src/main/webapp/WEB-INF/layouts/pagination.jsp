<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<nav aria-label="Page navigation example">
	<ul class="pagination justify-content-center">
		<li class="page-item">
			<div class="page-link" aria-label="Previous" data-limit="1">
				<span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
			</div>
		</li>
		<c:forEach begin="1" end="${pagination }" var="limit">
			<li class="page-item"><div class="page-link">${limit }</div></li>
		</c:forEach>
		<li class="page-item">
			<div class="page-link" aria-label="Next" data-limit="${pagination })">
				<span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
			</div>
		</li>
	</ul>
</nav>