const joinForm= document.getElementById("joinForm");
const loginForm= document.getElementById("loginForm");
const mypageForm = document.getElementById("mypageForm");
const memberDropBtn = document.getElementById("memberDropBtn");
const changePwForm = document.getElementById("changePwForm");
const jsId = document.getElementById("jsId");
const jsEmail = document.getElementById("jsEmail");

const handleMailChk = (e) => {
	const email = e.target;
	const emailValue = email.value;
	const data = {email : emailValue};
	
	$.ajax({
		type : "get",
		data: data,
		url : "/emailChk",
		success : function(data) {
			console.log(data);
			if(data == 1){
				swal("중복된 이메일 입니다.😥", "다시 입력해 주세요.", "warning");
				email.value = "";
			}
		} ,error: function(){
		     alert("에러@@@@@@");
			}	
	});			
}

const handleIdChk = (e) => {
	const id = e.target;
	const idValue = id.value;
	const data = {id : idValue};
	
	$.ajax({
		type : "get",
		data: data,
		url : "/idChk",
		success : function(data) {
			console.log(data);
			if(data == 1){
				swal("중복된 아이디 입니다.😥", "다시 입력해 주세요.", "warning");
				id.value = "";
			}
		} ,error: function(){
		     alert("에러@@@@@@");
			}	
	});				
}

const handleChangePw = (e) => {
	e.preventDefault();
	console.log(e);
	
	const pw = changePwForm.querySelector("#pw");
	const changePw = changePwForm.querySelector("#changePw");
	const checkPw = changePwForm.querySelector("#changePwChk");
	
	if(changePw.value != checkPw.value){
		swal('변경할 비밀번호를 확인해주세요.');
		checkPw.value = "";
	} else if(changePw.value == checkPw.value){
		const password = {
										pw: pw.value,
										changePw : changePw.value,
									};
		
		$.ajax({
			type : "get",
			data: password,
			dataType : "json",
			url : "/getPw",
			success : function(data) {
				if(data == true) {								
						$.ajax({
							type : "post",
							data: password,
							url : "/changePw",
							success : function(data) {
								swal({
									  title: "비밀번호 변경",
									  text: "성공!",
									  icon: "success",
									});	
								setTimeout("location.replace('/')",2000);
							} ,error: function(){
							     alert("에러@@@@@@");
								}	
						});			
				}
			} ,error: function(){
			     alert("에러@@@@@@");
				}	
		});
	}
}

const handleDrop = (e) => {
	console.log(e);
	
	swal({
		  title: "탈퇴 하시겠습니까?",
		  icon: "warning",
		  buttons: true,
		  dangerMode: true,
		})
		.then((willDelete) => {
		  console.log('탈퇴');
		  
			$.ajax({
				type : "POST",
				url : "/memberDrop",
				success : function() {
					 if (willDelete) {
						    swal("성공적으로 탈퇴 되었습니다.", {
						      icon: "success",
						 });
					 }
					 setTimeout("location.replace('/')",2000);
				} ,error: function(){
				     alert("에러@@@@@@");
					}	
			});
		});
}

const handleUpdate = (e) => {
	e.preventDefault();
	console.log(e);
	const password = mypageForm.querySelector("#password");
	console.log(password.value);
}

const handleLogin = (e) => {
	console.log(e);
}

const handleJoin = (e) => {
   e.preventDefault();
   console.log(e);
   
   const department = joinForm.querySelector("#department");
   const dName = document.getElementById("d_name");
   
   const roleSelect = joinForm.querySelector("#roleSelect");
   const role = joinForm.querySelector("#role");
   
   if(department.value == "" ){
	   swal("학과를 선택해 주세요.","", "warning");
   } 
   else if(roleSelect.value == "" ){
	   swal("직업을 선택해 주세요.","", "warning");
   } else {
	   dName.value = department.value;
	   role.value = roleSelect.value;
	   
	   console.log(role.value);
	   
	   joinForm.submit();
   }
}

function init() {
	
}

init();

if(joinForm){
	joinForm.addEventListener("submit", handleJoin);
}

if(loginForm){
	loginForm.addEventListener("submit", handleLogin);
}

if(mypageForm){
	mypageForm.addEventListener("submit", handleUpdate);
}

if(memberDropBtn) {
	memberDropBtn.addEventListener("click", handleDrop);
}

if(changePwForm){
	changePwForm.addEventListener("submit", handleChangePw);
}

if(jsId){
	jsId.addEventListener("change", handleIdChk);
}

if(jsEmail){
	jsEmail.addEventListener("change", handleMailChk);
}