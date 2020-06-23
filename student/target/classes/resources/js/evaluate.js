const submit = document.querySelectorAll("#submitBtn");
const searchForm = document.querySelector(".searchForm");
const lectureBookList = document.getElementById("lectureBookList");


const submitBlock = () => {

	const l_no = lectureBookList.querySelectorAll("#l_no");
	let submitBtn = "";
	
	$.ajax({
		type : "get",
		dataType : "json",
		url : "/lecture/evaluate/writeList",
		success : function(data) {
			data.forEach(item=>{
				l_no.forEach(num=>{
					if(num.value==item.l_no){
						submitBtn = num.form[3];
						submitBtn.disabled = true;
					}
				})
			})	
		} ,error: function(){
		     alert("에러@@@@@@");
			}	
	});
	
}

const handleSearch = (e) => {
	e.preventDefault();
	console.log(e);
	const select = searchForm.querySelector("select");
	const categoryValue = select.value;
	
	const category = document.getElementById("category");
	category.value = categoryValue;
	
	console.log(categoryValue);
	searchForm.submit();
}

const handleSubmit = (e) => {
	e.preventDefault();
	const form = e.path[1];
	
	if(e.target.value == '수정'){
		form.method="get";
		form.action="/lecture/evaluate/update";
		form.submit();
	} else if (e.target.value == '삭제'){
		form.action="/lecture/evaluate/delete";
		form.method="POST";
		form.submit();	
	}
}

const init = () => {
//	submit.forEach(item=>item.addEventListener("click", handleSubmit))
//	searchForm.addEventListener("submit", handleSearch);
}

init();

if(submit){
	submit.forEach(item=>item.addEventListener("click", handleSubmit));
}

if(searchForm){
	searchForm.addEventListener("submit", handleSearch);
}

if(lectureBookList){
	submitBlock();
}