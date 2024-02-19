/**
 * 
 */

let input = document.querySelector("#fileimg");
let button = document.querySelector("#up");
input.addEventListener("change",()=>{
	let maxSize = 5 * 1024 * 1024;
	
	if(input.size == 0 || input.size > maxSize){
		return;
	}
	
	let form = document.querySelector(".fils");
	let formData = new FormData(form);
	
	fetch("imgupload.do",{
		method: "POST",
		body: formData,
	})
	.then(response => response.text())
	.then(data =>{
		if(data ==="fail"){
			alert("이미지 업로드 실패");
		}else{
			alert("이미지 업로드 성공");
			let src = "img/"+data;
			document.querySelector("#image").src = src;
			document.querySelector("#imgurl").value = data;
			document.querySelector("#image").classList.remove("defalut");
		}
	})
	.catch(() => alert("애러..."));
});
function vaildCheckInsert(form){
	if(!form.name.value.trim()){
		alert("차 이름 입력해주세요");
		form.name.focus();
		return false;
	}
	if(!form.price.value.trim()){
		alert("가격 입력해주세요");
		form.price.focus();
		return false;
	}
	if(!form.usepeople.value.trim()){
		alert("승차 인원 입력해주세요");
		form.usepeople.focus();
		return false;
	}
	if(!form.totalQty.value.trim()){
		alert("총 수량 입력해주세요");
		form.name.focus();
		return false;
	}
	if(!form.company.value.trim()){
		alert("회사 정보 입력해주세요");
		form.company.focus();
		return false;
	}
	if(!form.info.value.trim()){
		alert("차 정보 입력해주세요");
		form.info.focus();
		return false;
	}
	
	if(document.querySelector(".defalut")){
		alert("이미지 올려 주세요");
		return false;
	}
	
	form.submit();
}
