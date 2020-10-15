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
	});
	
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
					let tdBtnAdđetail = $("<td><button type='button' class='btn btn-primary btn-add-detail'>Thêm chi tiết</button></td>")
					
					trTag.append(tdIndex);
					trTag.append(tdInput);
					trTag.append(tdNameProduct);
					trTag.append(tdPriceProduct);
					trTag.append(tdCategoryProduct);
					trTag.append(tdBtnAdđetail);
					
					$(".list-product").append(trTag);
				}
			}
		});
	}
	
	function reloadPagination(limitProduct){
		
	}
});