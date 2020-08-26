$(document).ready(function(){
    $("#productID").change(function(){
    	let productID = $("#productID").val();
    	console.log(productID);
        $.ajax({
        	url:"/ShopBanHang/api/name-product",
        	type:"GET",
        	data:{
        		maSP: productID,
        	},
        	success: function(nameProduct){
        		$("#nameProduct").val(nameProduct);
        	}
        });
    });
});