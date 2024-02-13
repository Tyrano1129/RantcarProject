/*
	유저 업데이트 비동기
	
	
 */

 function vildUpdataCheck(form){
	const regex = /\d{2,3}-\d{3,4}-\d{4}/;
	const emailregex = /[a-z0-9]+@[a-z]+\.[a-z]{2,3}/;
	let check = true;
	if(!form.pw.value.trim()){
		alert("비밀번호를 입력해주세요!");
		form.pw.focus();
		return false;
	}
	if(!form.job.value.trim()){
		alert("직업을 입력해주세요!");
		form.job.focus();
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
	fetch("vaildPwCheck.do",{
		method: "POST",
		headers:{
			"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "pw="+form.pw.value
	})
	.then(response => response.text())
	.then((data) => {
		if(data === "notvalid"){
			alert("비밀번호를 틀렸습니다.");
			form.pw.foucs();
			form.pw.value = "";
			check = false;
		}
	})
	.catch(() => alert("errer"));
	if(!check){
		return check;
	}
	alert("수정 완료!");
	form.submit();
}


 
function vildDeleteCheck(form,ctx){
	if(!form.pw.value.trim()){
		alert("비밀번호 입력해주세요!");
		form.pw.focus();
		return false;
	}
	
	fetch("vaildPwCheck.do",{
		method: "POST",
		headers:{
			"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "pw="+form.pw.value
	})
	.then(response => response.text())
	.then((data) => {
		if(data === "notvalid"){
			alert("비밀번호를 틀렸습니다.");
			form.pw.foucs();
			form.pw.value = "";
		}else{
			deleteUser(form.id.value,ctx);
		}
	})
	.catch(() => alert("errer"));
	
}
function deleteUser(id,ctx){
	fetch("userDelete.do",{
		method:"POST",
		headers:{
			"Content-Type":"application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "id="+id,
	})
	.then(response => response.text())
	.then((data) =>{
		if(data >= 1){
			alert("탈퇴되었습니다.")
			location.href = ctx+"/main.do";
		}
	})
	.catch(() => alert("errer"));
	
}
function hypenTel(target){
	target.value= target.value
	.replace(/[^0-9]/g,'')
	.replace(/^(\d{2,3})(\d{3,4})(\d{4})$/,`$1-$2-$3`);
}