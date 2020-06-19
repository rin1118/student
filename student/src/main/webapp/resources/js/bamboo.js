const favBtn = document.querySelectorAll("#favBtn");
const notFavBtn = document.querySelectorAll("#notFav");
const searchForm = document.querySelector(".searchForm");

const handleSearch = (e) => {
	e.preventDefault();
	console.log(e);
	const select = searchForm.querySelector("select");
	const categoryValue = select.value;
	
	const category = document.getElementById("category");
	category.value = categoryValue;
	searchForm.submit();
}

const handleFav = (e) => {
	const target = e.target;
	
	if(target.id=='favBtn'){
			const favNum = target.nextElementSibling;
			let value = parseInt(favNum.innerHTML)
				
			const data = {
				favNum : value+1,
				b_no: e.target.dataset.b_no
			};
				
			$.ajax({
					type : "POST",
					data : data,
					url : "/bamboo/favorite",
					success : function() {
						value += 1;
						favNum.innerText = value;
					} ,error: function(){
					     alert("에러@@@@@@");
						}	
			});
		} else if(target.id == 'notFav'){

			const notFav = target.nextElementSibling;
			let value = parseInt(notFav.innerHTML)

			const data = {
				notFavNum : value+1,
				b_no: e.target.dataset.b_no
			};
				
			$.ajax({
					type : "POST",
					data : data,
					url : "/bamboo/notFavorite",
					success : function() {
						value+=1;
						notFav.innerText = value;
					} ,error: function(){
					     alert("에러@@@@@@");
						}	
			});
		}
	
}

const init  = () => {
	favBtn.forEach(item=>{
		item.addEventListener("click", handleFav);
	});
	notFavBtn.forEach(item=>{
		item.addEventListener("click", handleFav);
	})
	searchForm.addEventListener("submit", handleSearch);
}

init();


