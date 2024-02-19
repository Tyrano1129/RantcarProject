/*
	로그인 한사람만 예약 가능
 */

 
function vaildreserveCheck(id,ctx){
	
	if(id != ''){
		location.href = ctx+"/userReserveList.do";
	}else{
		alert("로그인 후  이용해주세요!")
		location.href = ctx+"/loginUser.do";
	}
}