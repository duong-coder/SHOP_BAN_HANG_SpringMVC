$(document).ready(function() {
	var inputSelectItems = $("input[name='selectItem']");
	var buttonDeleteAllItem = $("#deleteAll");
	var buttonDeleteItems = $(".deleteItem");
	console.log(inputSelectItems, buttonDeleteAllItem, buttonDeleteItems);

	for(let i = 0; i <buttonDeleteItems.length; i++){
		$(buttonDeleteItems[i]).click(function (){
			let strIndexItem = $(buttonDeleteItems[i]).attr("id");
			let index = strIndexItem.replace("deleteItem", "");
			deleteItem(index);
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
	
	function checkSelectItem(items){
		for(item of items){
			if(item.checked){
				return true;
			}
		};
		
		return false;
	}

});