const joinForm= document.getElementById("joinForm");
const loginForm= document.getElementById("loginForm");
const mypageForm = document.getElementById("mypageForm");

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
   
   dName.value = department.value;
   role.value = roleSelect.value;
   
   console.log(role.value);
   
   joinForm.submit();
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