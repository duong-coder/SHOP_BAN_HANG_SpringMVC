$(document).ready(function() {
	let category = {
			id: -1,
			name: "",
			image: ""
	};
	let color = {
			id: -1,
			color: ""
	};
	let size = {
			id: -1,
			size: ""
	};
	let detailDTO = {
			id: -1,
			productDTO: null,
			color: {},
			size: {},
			amount: 0
	};
	let productNew = {
			maSp: "",
			tenSp: "",
			moTa: "",
			gia: 0,
			tenAnh: "",
			category: {},
			file: null,
			detailDTOs: []
	};
    $("#btnAddDetail").click(function() {
        $(".details").append($(".detail:first-child").clone().removeAttr( "hidden"));
        addEventDelete();
    });
    function addEventDelete(){
    	$("button.btn-delete").each(function(){
        	$(this).click(function(){
    	    	let divDetail = $(".detail");
    	    	for(let i = 0; i<divDetail.length; i++){
    	    		if($($("div.detail")[i]).css("display") != 'none'){
    		    		if($("div.detail button.btn-delete")[i] === this){
    		    			$($("div.detail")[i]).remove();
    		    		}
    	    		}
    	    	}
    		});
        });
    }
    $("#btnUpdateProduct").click(function(){
    	let productNew = getProductInForm();
    	let formData = getFileInForm();
    	
    	console.log(productNew, formData);
    	$.ajax({
			url: "/ShopBanHang/api/admin/upload-image",
			type: "POST",
			data: formData,
			processData: false,
			contentType: false,
			enctype:"multipart/form-data",
			success: function(products){
				console.log("OK", products);
				$.ajax({
					url: "/ShopBanHang/api/admin/edit-product",
					contentType: "application/json",
					type: "POST",
					data:JSON.stringify(productNew),
					success: function(status){
						console.log("OK", status);
						alert("Cập nhật thành công.");
					},
					error: function(error){
						console.log(error);
						alert("Cập nhật thất bại.");
					}
		    	});
			},
			error: function(error){
				console.log(error);
				alert("Bạn chưa chọn ảnh.");
			}
    	});
    });
   
    
    $("#btnAddProduct").click(function(){
    	let productNew = getProductInForm();
    	let formData = getFileInForm();
    	console.log(productNew);
    	$.ajax({
			url: "/ShopBanHang/api/admin/upload-image",
			type: "POST",
			data: formData,
			processData: false,
			contentType: false,
			enctype:"multipart/form-data",
			success: function(products){
				console.log("OK", products);
				$.ajax({
					url: "/ShopBanHang/api/admin/add-product",
					contentType: "application/json",
					type: "POST",
					data:JSON.stringify(productNew),
					success: function(products){
						console.log("OK", products);
						alert("Thêm thành công.");
					},
					error: function(error){
						console.log(error);
						alert("Thêm thất bại.");
					}
		    	});
			},
			error: function(error){
				console.log(error);
				alert("Bạn chưa chọn ảnh.");
			}
    	});
	});	
    
    
    function getProductInForm(){
    	productNew = {};
    	productNew.maSp = $("input[id='maSP']").val();
    	productNew.tenSp = $("input[id='tenSP']").val();
    	productNew.moTa = $("textarea[id='moTa']").val();
    	productNew.gia = $("input[id='giaSP']").val();
    	let file = $("input[id='hinhAnh']").prop('files')[0];
    	productNew.tenAnh = file.name;
    	productNew.file = null;
    	productNew.detailDTOs = [];
    	category.id = $("select[id='hangSP']").val();
    	productNew.category = category;
    	
    	let divDetail = $(".detail");
    	
    	for(let i = 1; i<divDetail.length; i++){
			let idct = $($("input[name='idctsp']")[i]).val();
    		let colorID = $($("select[name='colorID']")[i]).val();
    		let sizeID = $($("select[name='sizeID']")[i]).val();
    		let amount = $($("input[name='amount']")[i]).val();
    		color.id = colorID;
    		size.id = sizeID;
    		detailDTO = {};
    		detailDTO.id = idct;
    		detailDTO.color = {...color};
    		detailDTO.size = {...size};
    		detailDTO.amount = amount;
    		
    		productNew.detailDTOs.push({...detailDTO});
    	}
    	
    	return productNew;
    }
    
    function getFileInForm(){
    	let file = $("input[id='hinhAnh']").prop('files')[0];
    	var formData = new FormData();
    	formData.append('file', file);
    	
    	return formData;
    }
});