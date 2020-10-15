$(document).ready(function(){
	showProductOnLoad();
	function showProductOnLoad(){
		let products = $(".box-product");
        for(let i = 0; i < products.length; i++){
			setTimeout(()=>{
				$( $(".box-product")[i] ).addClass("box-product-animate");
				
			}, i*200);
        }
	};
});