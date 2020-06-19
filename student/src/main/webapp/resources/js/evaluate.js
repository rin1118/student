const submit = document.querySelectorAll("#submitBtn");
const searchForm = document.querySelector(".searchForm");

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
	submit.forEach(item=>item.addEventListener("click", handleSubmit))
	searchForm.addEventListener("submit", handleSearch);
}

init();