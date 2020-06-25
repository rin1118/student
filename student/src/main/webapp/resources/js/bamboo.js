const favBtn = document.querySelectorAll("#favBtn");
const notFavBtn = document.querySelectorAll("#notFav");
const searchForm = document.querySelector(".searchForm");
const messageUpdate = document.querySelectorAll(".messageUpdate");
const messageDel = document.querySelector("#messageDel");
const writeForm = document.querySelector(".writeForm");
const backBtn = document.getElementById("backBtn");

const handleBack = (e) => {
	e.preventDefault()
	history.back();
}

const handleDel = (e) => {
	e.preventDefault();
	console.log(e);
	
	const b_no = writeForm.querySelector("#b_no");
	const data = {
							b_no : b_no.value 
						}
	
	$.ajax({
		type : "post",
		data: data,
		url : "/bamboo/delete",
		success : function(data) {
			swal("삭제 되었습니다.");
			setTimeout(function() {
				location.href = "/bamboo/main";
			}, 2000);
		} ,error: function(request, status, error){
			swal("다시 시도해주세요.");
			}	
	});
}

const handleUpdate = (e) => {
	
	e.preventDefault();
	
	const writer = e.target.dataset.writer;
	const b_no = e.target.dataset.b_no;
	
	console.log(writer);
	console.log(b_no);
	
	swal({
		  text: '비밀번호를 입력해주세요.',
		  content: "input",
		  button: {
		    text: "확인",
		    closeModal: false,
		  },
		}).then(pw=>{
				
				swal.stopLoading();
			    swal.close();
				
			    const writerChk = {
					writer: writer,
					password: pw,
					b_no : b_no
				}
				
				$.ajax({
					type : "get",
					dataType: "json",
					data: writerChk,
					url : "/bamboo/writeMessage",
					success : function(data) {
						const {b_no, description, password, title, writer} = data;
						location.href = `/bamboo/update?
						b_no=${b_no}&
						description=${description}&
						title=${title}&writer=${writer}
						`;
					} ,error: function(request, status, error){
						swal("비밀번호를 확인해주세요.");
						}	
				});
		});
}

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
	
}

init();

if(searchForm){
	searchForm.addEventListener("submit", handleSearch);
}

if(messageUpdate){
	messageUpdate.forEach(item=>{
		item.addEventListener("click", handleUpdate);
	})
}

if(messageDel){
	messageDel.addEventListener("click", handleDel);
}

if(backBtn){
	backBtn.addEventListener("click", handleBack);
}