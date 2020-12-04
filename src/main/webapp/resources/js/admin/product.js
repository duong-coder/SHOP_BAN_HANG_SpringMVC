$(document).ready(function(){
	var listPage = $(".page-item");
	let a = listPage[1].textContent;
	let indexPage = 1;
	let urlGetProducts = "/ShopBanHang/api/admin/product-limit/";
	$("#category").change(function(){
		let categoryID = $("#category").val();
		if(categoryID != 0){
			urlGetProducts = "/ShopBanHang/api/admin/product-limit-category/" + categoryID + "/";
		}else{
			urlGetProducts = "/ShopBanHang/api/admin/product-limit/";
		}
		getProductsAjax(urlGetProducts, 1);
		reloadPagination(categoryID, 10);
	});
	
	$("#btnDelete").click(function(){
		let arrItemWillDelete = [];
		let items = $("input.select-delete");
		for(let i = 0; i<items.length; i++){
			let isDelete = $(items[i]).prop("checked");
			if(isDelete){
				let maSP = $($("input[data='maSP']")[i]).val();
				arrItemWillDelete.push(maSP);
			}
		}
		console.log(arrItemWillDelete);
		"/delete-product"
		$.ajax({
			url: "/ShopBanHang/api/admin/delete-product",
			type: "POST",
			data: {
				maSPs: arrItemWillDelete
			},
			success: function(){
				alert("Xoa thanh cong");
				getProductsAjax(urlGetProducts, indexPage);
			},
			error: function(error){
				console.log(error);
				alert("Xoa that bai");
			}
		});
	});
	
	$("#selectAll").click(function(){
		let flagSelectAll = $("#selectAll").prop("checked");
		let items = $("input.select-delete");
		for(let i = 0; i<items.length; i++){
			$(items[i]).prop("checked", flagSelectAll);
		}
	});
	
	function addEventInPagination(){
		$(".page-item").click(function(){
			let index = this.textContent;
			if(index.includes("Previous")){
				if(indexPage > 1){
					indexPage--;
					index=indexPage;
				}else{
					return;
				}
			}else if(index.includes("Next")){
				if(indexPage < (listPage.length - 2)){
					indexPage++;
					index=indexPage;
				}else{
					return;
				}
			}
			indexPage=index;
			getProductsAjax(urlGetProducts, index);
		});
	};
	addEventInPagination();
	
	function getProductsAjax(urlGet, index){
		$.ajax({
			url: urlGet + index,
			type: "GET",
			success: function(products){
				console.log(products);
				$(".list-product").empty();
				for(let i = 0; i < products.length; i++){
					let trTag =  $("<tr></tr>");
					let tdIndex = $("<th>" + (i + 1) + "<input type='text' class='masp' data='maSP' value='"+ products[i].maSp +"' hidden></th>");
					let tdInput = $("<td scope='row'><input class='select-item select-delete' type='checkbox'></td>");
					let tdNameProduct = $("<td></td>").text(products[i].tenSp);
					let tdPriceProduct = $("<td></td>").text(products[i].gia);
					let tdCategoryProduct = $("<td></td>").text(products[i].category.name);
					let tdBtnAddetail = $("<td>" +
							"<a href='/ShopBanHang/admin/infor-product/"+products[i].maSp +"'><button type='button' class='btn btn-primary btn-add-detail'>Xem chi tiết</button></a>" +
							"<a href='/ShopBanHang/admin/edit-product/"+products[i].maSp +"'><button type='button' class='btn btn-warning btn-update'>Cập nhật sản phẩm</button></a>" +
							"</td>");
					
					trTag.append(tdIndex);
					trTag.append(tdInput);
					trTag.append(tdNameProduct);
					trTag.append(tdPriceProduct);
					trTag.append(tdCategoryProduct);
					trTag.append(tdBtnAddetail);
					
					$(".list-product").append(trTag);
				}
			}
		});
	}
	
	async function reloadPagination(indexCategory, limitProduct){
		let amount = 0;
		if(indexCategory == 0){
			await countAllProduct().then(
				function(count){
					amount = count;
				}
			);
		}else{
			console.log(amount);
			await countProductByCategory(indexCategory).then(
				function(count){
					amount = count;
				}
			);
		}

		let tagPageLater = $(".page-item");
		let amountPage = Math.ceil(amount/limitProduct);
		console.log(amountPage);
		
		removeIndexPageOld(tagPageLater);
		for(let i = 1; i<=amountPage; i++){
			let liTag = $("<li class='page-item'><div class='page-link'>"+ i + "</div></li>");
			$(".page-item")[i-1].after(liTag[0]);
		}
		addEventInPagination();
	}
	function removeIndexPageOld(arrTagPageLater){
		for(let i = 1; i <= arrTagPageLater.length - 2; i++){
			$(".page-item")[1].remove();
		}
	}
	function countAllProduct(){
		return new Promise(function(resolve, reject){
			let count = 0;
			$.ajax({
				url: "/ShopBanHang/api/admin/amount-product",
				type: "GET",
				success: function(amount){
					count = amount;
					
					resolve(count);
				}
			});
		});
	}
	function countProductByCategory(indexCategory){
		return new Promise(function(resolve, reject){
			let count = 0;
			$.ajax({
				url: "/ShopBanHang/api/admin/product-limit-category/" + indexCategory,
				type: "GET",
				success: function(amount){
					count = amount;
					
					resolve(count);
				}
			});
		});
	}
	
});