//const form = document.getElementById("lectureBookForm");
const submitBtn = document.querySelectorAll("#submitBtn");
const deleteBtn = document.querySelectorAll("#deleteBtn");
const lectureNo = document.getElementById("l_no");
const signUp = document.getElementById("signUp");
const signUpItem = signUp.querySelectorAll("form");
const result = document.getElementById("result");
const resultItem = result.querySelectorAll("form");

function handleBlock(){
	signUpItem.forEach(signUpItem => {
		resultItem.forEach(resultItem => {
			if(signUpItem.id == resultItem.id){
				const id = signUpItem.id;
				const submit = signUpItem.querySelector("#submitBtn");
				submit.disabled = true;
			}
		});
		}
	);
}

function handleDelete (e) {
	e.preventDefault();
	const f = e.target.form;
//	console.log(f);
	
	$.ajax({
		type : "POST",
		data : $(f).serialize(),
		url : "/lecture/signUpCancel",
		success : function(data) {
			f.remove();
			swal("수강 취소", "성공", "success");
			signUpItem.forEach(item => {
				if(item.id == f.id){
					const submit = item.querySelector("#submitBtn");
					console.log(submit);
					submit.disabled = false;
				}
			})
		} ,error: function(){
		     alert("에러@@@@@@");
			}	
	});
}


function handleSubmit(e){
	e.target.disabled = true;
	e.preventDefault();

	let form = "#"+e.path[1].id;
	const s_no = "3"; 	//학번
	const l_no = lectureNo.value; //강의번호

	$.ajax({
	type : "POST",
	dataType : 'json',
	data : $(form).serialize(),
	url : "/lecture/signUp",
	success : function(data) {
		result.innerHTML = "";
		
		swal("수강 신청", "성공", "success");

		for(let i=0;i<data.length;i++){
			const {l_no, title, description, category, professor} = data[i];
			const f = document.createElement('form');
			
			const categoryTitle = document.createElement("span");
			const lectureTitle = document.createElement("span");
			const professorTitle = document.createElement("span");
			
			const numLi = document.createElement('input');
			const titleLi = document.createElement('input');
			const categoryLi = document.createElement('input');
			const professorLi = document.createElement('input');
			const sub = document.createElement('input');
			
			categoryTitle.innerText = "강의분류 : ";
			lectureTitle.innerText = "강의명 : ";
			professorTitle.innerText = "교수명 : ";
			
			numLi.value = l_no;
			titleLi.value = title;
			categoryLi.value = category;
			professorLi.value= professor;
			sub.value='삭제';
			
			numLi.name="l_no";
			numLi.type="hidden";
			
			f.id = `BookForm${l_no}`;
			f.className = "listItem";
			f.method="post";
			f.action="/lecture/signUpCancel";
			sub.type="submit";
			sub.id="deleteBtn";
			sub.addEventListener("click", handleDelete);
			
			f.appendChild(numLi);
			
			f.appendChild(categoryTitle);
			f.appendChild(categoryLi);
			
			f.appendChild(lectureTitle);
			f.appendChild(titleLi);
			
			f.appendChild(professorTitle);
			f.appendChild(professorLi);
			
			f.appendChild(sub);

			result.appendChild(f);
			
		}
	},error: function(){
	     alert("에러@@@@@@");
	 }
	});
}

function init(){
	handleBlock();
	submitBtn.forEach(item => item.addEventListener("click", handleSubmit));
	deleteBtn.forEach(item => item.addEventListener("click", handleDelete));
};

init();