/*
	유저 로그인 체크 용도
	비동기 
*/


function validCheck(form,ctx){
	let check = true;
	
	if(!form.id.value.trim()){
		alert("아이디를 입력해주세요!");
		form.id.focus();
		return false;
	}
	if(!form.pw.value.trim()){
		alert("비밀번호를 입력해주세요!");
		form.pw.focus();
		return false;
	}
	
	let id = form.id.value;
	let pw = form.pw.value;
	
	fetch("loginUser.do",{
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",	},
		body: "id="+id + "&pw="+pw,
	})
	.then(response => response.text())
	.then((data) =>{
		if(data >= 1){
			alert("로그인 성공");
			location.href = ctx+"/main.do";
		}else{
			alert("아이디 또는 비밀번호가 올바르지않습니다.");
			form.id.value = "";
			form.pw.value = "";
			form.id.focus();
			check = false;
		}
	})
	.catch(() => alert("errer"));
	return check;
}