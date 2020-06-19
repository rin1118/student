const lectureForm = document.getElementById("lectureForm"); 
const updateBtn = document.getElementById("updateBtn");
const deleteBtn = document.getElementById("deleteBtn");

function handleSubmit(e) {
	e.preventDefault();
	const target = e.target.value;

	if(target == "확인"){
		lectureForm.action="/lecture/update";
		lectureForm.method="post";
		lectureForm.submit();	
	}else if(target == "삭제") {
		lectureForm.method="post";
		lectureForm.action="/lecture/delete";
		lectureForm.submit();	
	}
}

updateBtn.addEventListener("click", handleSubmit);
deleteBtn.addEventListener("click", handleSubmit);