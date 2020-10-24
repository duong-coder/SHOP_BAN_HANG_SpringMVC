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
					let tdIndex = $("<th></th>").text(i + 1);
					let tdInput = $("<td scope='row'><input class='select-item' type='checkbox'></td>");
					let tdNameProduct = $("<td></td>").text(products[i].tenSp);
					let tdPriceProduct = $("<td></td>").text(products[i].gia);
					let tdCategoryProduct = $("<td></td>").text(products[i].category.name);
					let tdBtnAddetail = $("<td><button type='button' class='btn btn-primary btn-add-detail'>Thêm chi tiết</button><button type='button' class='btn btn-warning btn-update'>Cập nhật sản phẩm</button></td>");
					
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