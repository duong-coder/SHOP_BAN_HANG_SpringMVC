$(document).ready(function(){
//	$(".box-product").addClass("box-product-animate");
	showProductOnLoad();
	var listPage = $(".page-item");
	let a = listPage[1].textContent;
	console.log(listPage.length);
	let indexPage = 1;

	function showProductOnLoad(){
		let products = $(".box-product");
        for(let i = 0; i < products.length; i++){
			setTimeout(()=>{
				$( $(".box-product")[i] ).addClass("box-product-animate");
				
			}, i*200);
        }
	};
	
	$(".page-item").click(function(){
		let index = this.textContent;
		console.log(index);
		console.log(indexPage);
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
		$.ajax({
			url: "/ShopBanHang/api/product-limit/" + index,
			type: "GET",
			success: function(products){
				$(".box-product").removeClass("box-product-animate");
				$(".product-limit").parent().empty();
				for(let i = 0; i < products.length; i++){
					let aTag =  $("<a href=''></a>").attr("href", "/ShopBanHang/products/" + products[i].maSp);
					let imgTag = $("<img src='' class='card-img-top u-image-san-pham' alt='...' width='253px' height='253px'>").attr("src", "/ShopBanHang/imageProducts/" + products[i].tenAnh);
					let divTag = $("<div class='card-body'><h5 class='card-title'></h5><p class='card-text' style='color: rgb(240, 109, 109);'></p></div>");
					let divTotal = $("<div class='card h-100 product-limit'></div>");
					$( $(".box-product")[i] ).append(divTotal);
					$( $(".product-limit")[i] ).append(aTag, divTag);
					$( $(".product-limit a")[i] ).append(imgTag);
					
					/*$( $(".product-limit a")[i] ).attr("href", "/ShopBanHang/products/" + products[i].maSp);
					$( $(".product-limit a img")[i] ).attr("src", "/ShopBanHang/imageProducts/" + products[i].tenAnh);*/
					$( $(".product-limit div h5")[i] ).text(products[i].tenSp);
					$( $(".product-limit div p")[i] ).text(products[i].gia);
					
					setTimeout(()=>{
						$( $(".box-product")[i] ).addClass("box-product-animate");
						
					}, i*200);
				}
//				window.scrollTo(0,700);
				$('html, body').animate({scrollTop:700}, 'slow');
				
			}
		});
	});
});