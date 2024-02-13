/*
 	유저 가입 비동기 시스템

 
 */

let check = 0;

function vildjoinCheck(form){
	const regex = /\d{2,3}-\d{3,4}-\d{4}/;
	const emailregex = /[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;
	if(!form.id.value.trim()){
		alert("아이디 입력해주세요!");
		form.id.focus();
		return false;
	}
	if(!form.pw.value.trim()){
		alert("비밀번호 입력해주세요!");
		form.pw.focus();
		return false;
	}
	if(!form.age.value.trim()){
		alert("나이 입력해주세요!");
		form.age.focus();
		return false;
	}
	if(form.age.value < 18){
		alert("18세 미만 고객은 이용불가능합니다.");
		form.age.focus();
		form.age.value = "";
		return false;
	}
	if(form.age.value >= 110){
		alert("나이를 잘못입력하셨습니다.");
		form.age.focus();
		form.age.value="";
		return false;
	}
	if(!form.job.value.trim()){
		alert("직업을 입력해주세요!");
		form.age.focus();
		return false;
	}
	if(!form.tel.value.trim()){
		alert("전화번호를 입력해주세요!");
		form.tel.focus();
		return false;
		
	}
	if(!form.tel.value.match(regex)){
		alert("전화번호를 다시 입력해주세요.");
		form.tel.focus();
		return false;
	}
	if(!form.email.value.trim()){
		alert("이메일 입력해주세요!");
		form.email.focus();
		return false;
	}
	if(!form.email.value.match(emailregex)){
		alert("이메일을 다시 입력해주세요!");
		form.email.focus();
		return false;
	}
	if(!form.info.value.trim()){
		alert("자기소개 입력해주세요!");
		form.info.focus();
		return false;
	}
	
	if(check == 0){
		alert("id 중복체크해주세요");
		return false;
	}else if(check == -1){
		alert("id 아이디를 다시 확인해주세요!");
		return false;
	}
	alert("가입 완료!");
	form.submit();
}

function hypenTel(target){
	target.value= target.value
	.replace(/[^0-9]/g,'')
	.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/,`$1-$2-$3`);
}
document.querySelector("#checkId").addEventListener("click",() =>{
	let id = document.querySelector("#id");
	console.log(id);
	if(id.value.length == 0){
		alert("id 값 입력하세요");
		document.querySelector("#id").focus();
		document.querySelector("#id").value = "";
		return;
	}
	
	fetch("validIdCheck.do",{
		method:"POST",
		headers:{"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8",},
		body: "id="+id.value,
	})
	.then((response) => response.text())
	.then(result => getResult(result))
	.catch(() => alert("error"));
})
function getResult(data){
	if(data === "valid"){
		alert("이 아이디는 사용 가능합니다.");
		document.querySelector("#pw").focus();
		check = 1;
	}else if(data ==="notvalid"){
		alert("이미 사용중인 아이디입니다.");
		document.querySelector("#id").focus();
		document.querySelector("#id").value="";
		check = -1;
	}
}
document.querySelector("#id").addEventListener("keyup",(e)=>{
	if(e.keyCode === 8){
		check = 0;
	}
})