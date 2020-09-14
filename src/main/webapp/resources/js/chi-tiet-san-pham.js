$(document).ready(function() {
	// alert($("input[name='color']").attr("name"));
	var inputTagColors = $("input[name='color']");
	var inputTagSizes = $("input[name='size']");
	console.log(inputTagColors);

	$("input").change(function() {
		let inputTagColor = getValueInput(inputTagColors);

		const maSP = $("#codeProduct").val();
		const maMau = getValueInput(inputTagColors);
		const maSize = getValueInput(inputTagSizes);
		console.log(maSP + maMau + maSize);
		$.ajax({
			url : "/ShopBanHang/api/amount-product-detail",
			type : "GET",
			data : {
				maSP : maSP,
				maMau : maMau,
				maSize : maSize
			},
			success : function(amount) {
				changeAmountProductDetail(amount);
			}
		});
	});

	var changeAmountProductDetail = function(amount) {
		if (amount < 0) {
			$("#amountProductInStock").addClass("stocks");
			$("#amountProductInStock").text("Hết hàng");
		} else {
			$("#amountProductInStock").removeClass("stocks");
			$("#amountProductInStock").text(amount);
		}
	}
	var getValueInput = function(inputTags) {
		for (let i = 0; i < inputTags.length; i++) {
			if (inputTags[i].checked) {
				let inputTag = inputTags[i];
				return $(inputTag).val();
			}
		}
	}
	
	$("#btn-add-to-cart").click(function() {
		let inputTagColor = getValueInput(inputTagColors);

		const maSP = $("#codeProduct").val();
		const maMau = getValueInput(inputTagColors);
		const maSize = getValueInput(inputTagSizes);
		console.log(maSP + maMau + maSize);
		$.ajax({
			url : "/ShopBanHang/order/add-item",
			type : "GET",
			data : {
				maSP : maSP,
				maMau : maMau,
				maSize : maSize
			},
			success : function() {
			}
		});
	});
});