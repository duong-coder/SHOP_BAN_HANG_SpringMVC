$(document).ready(function() {
	var inputSelectItems = $("input[name='selectItem']");
	var buttonDeleteAllItem = $("#deleteAll");
	var buttonDeleteItems = $(".deleteItem");
	var imputAmountItem = $(".amout-item");
	var maSPs = $("input[name='maSP']");
	var maMaus = $("input[name='maMau']");
	var maSizes = $("input[name='maSize']");
	console.log(inputSelectItems, buttonDeleteAllItem, buttonDeleteItems);

	for(let i = 0; i <buttonDeleteItems.length; i++){
		$(buttonDeleteItems[i]).click(function (){
			let strIndexItem = $(buttonDeleteItems[i]).attr("id");
			let index = strIndexItem.replace("deleteItem", "");
			deleteItem([index]);
		});
	}
	
	for(let i = 0; i < imputAmountItem.length; i++){
		$(imputAmountItem[i]).blur(function(){
			let maSP = $(maSPs[i]).val();
			let maMau = $(maMaus[i]).val();
			let maSize = $(maSizes[i]).val();
			let amount = $(imputAmountItem[i]).val();
			changeAmountInItem(maSP, maSize, maMau, amount, i);
			getPriceItem();
		});
	}
	
	$(inputSelectItems[0]).click(function (){
		if(inputSelectItems[0].checked){
			for(let i = 1; i < inputSelectItems.length; i++){
				inputSelectItems[i].checked = true;
			}
		}else{
			for(let i = 1; i < inputSelectItems.length; i++){
				inputSelectItems[i].checked = false;
			}
		}
		getPriceItem();
	});
	for(let i = 1; i < inputSelectItems.length; i++){
		$(inputSelectItems[i]).click(function(){
			getPriceItem();
//			saveOrder();
		});
	}
	
	$("#btnSaveOrder").click(function(){
//		alert("luu order");
		let indexs = saveOrder();
//		$.post(
//				"/ShopBanHang/order/save-order",
//				{
//					indexs: indexs
//				},
//				function(data){
//					location.href = "/ShopBanHang";
//				}
//		);
	});
	
	$("#deleteAll").click(function(){
//		inputSelectItems.remove(0);
		if(checkSelectItem(inputSelectItems)){
			let indexs = [];
			for(let i = 1; i < inputSelectItems.length; i++){
				if(inputSelectItems[i].checked){
					let strIdInput = $(inputSelectItems[i]).attr("id");
					let index = strIdInput.replace("item", "");
					indexs.push(Number.parseInt(index));
				}
			}
//			console.log(indexs);
			deleteItem(indexs);
		}else{
			alert("Ban chua chon san pham nao");
		}
	});

	function deleteItem(indexItems) {
		$.ajax({
			url : '/ShopBanHang/order/delete-items-order',
			type : 'POST',
			data : {
				indexs: indexItems
			},
			success : function() {
				location.reload();
			}
		});
	}
	
	function changeAmountInItem(maSP, maSize, maMau, amountInItem, index){
		console.log(maSP, maSize, maMau, amountInItem);
		$.ajax({
			url: '/ShopBanHang/order/change-amount-item	',
			type: 'POST',
			data: {
				maSP: maSP,
				maMau: maMau,
				maSize: maSize,
				amount: amountInItem
			},
			success : function(priceItem){
				let idPrice = "#priceItem" + index;
				$(idPrice).text(priceItem);
			}
		});
	}
	
	function checkSelectItem(items){
		if(items.length <= 1){
			return false;
		}
		for(item of items){
			if(item.checked){
				return true;
			}
		};
		
		return false;
	}
	function getIndexSelectItem(items){
		let indexs = [];
		for(let i = 1; i<items.length; i++){
			if(items[i].checked){
				let strIdInput = $(items[i]).attr("id");
				let index = strIdInput.replace("item", "");
				indexs.push(Number.parseInt(index));
			}
		}
		
		return indexs;
	}
	function getPriceItem(){
		let indexs = getIndexSelectItem(inputSelectItems);
		if(indexs.length > 0){
		$.ajax({
			url: '/ShopBanHang/order/price-item-order',
			type: 'POST',
			data: {
				indexs: indexs
			},
			success: function(price){
				$("#priceTemporary").text(price + " đ");
			}
			});
		}else{
			$("#priceTemporary").text("0 đ");
		}
	}
	function saveOrder(){
		let indexs = [];
//		for(let i = 1; i < inputSelectItems.length; i++){
//			if(inputSelectItems[i].checked){
//				indexs.push("indexs=" + i);
//				console.log(i);
//			}
//		}
//		let urlSave = "/ShopBanHang/order/save-order";
//		let data = "?";
//		indexs.forEach((item, index) =>{
//			if(index === 0){
//				data+= item;
//			}else{
//				data+= "&" + item;
//			}
//		});
//		urlSave = urlSave + data;
//		console.log(urlSave);
		for(let i = 1; i < inputSelectItems.length; i++){
			if(inputSelectItems[i].checked){
				indexs.push(i - 1);
				console.log(i - 1);
			}
		}
		
		return indexs;
	}
});