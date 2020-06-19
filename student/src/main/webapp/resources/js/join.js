const joinForm= document.getElementById("joinForm");
const loginForm= document.getElementById("loginForm");
const mypageForm = document.getElementById("mypageForm");

const handleUpdate = (e) => {
	e.preventDefault();
	console.log(e);
	const password = mypageForm.querySelector("#password");
	console.log(password.value);
	console.log(`${member}`); 
}


const handleLogin = (e) => {
	console.log(e);
}

const handleJoin = (e) => {
   e.preventDefault();
   console.log(e);
   const select = joinForm.querySelector(".department");
   const department = document.getElementById("d_name");
   department.value = select.value;
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