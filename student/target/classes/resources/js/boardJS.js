const boardForm = document.getElementById("boardForm"); 
const updateBtn = document.getElementById("boardUpdateBtn");
const deleteBtn = document.getElementById("boardDeleteBtn");

function handleSubmit(e) {
	e.preventDefault();
	const target = e.target.value;
	const id= new URLSearchParams(location.search).get("id");
	console.log(id);
	
	if(target == "수정"){
		boardForm.action="/board/update";
		boardForm.method="get";
		boardForm.submit();	
	}else if(target == "삭제") {
		boardForm.method="post";
		boardForm.action="/board/delete";
		boardForm.submit();	
	}
}

updateBtn.addEventListener("click", handleSubmit);
deleteBtn.addEventListener("click", handleSubmit);