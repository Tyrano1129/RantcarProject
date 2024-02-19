/**
 * 
 */

function validDelete(qty,no,reserveSeq,ctx){
	
	fetch("deleteres.do",{
		method: "POST",
		headers: {
			"Content-Type": "application/x-www-form-urlencoded; charset=UTF-8",
		},
		body: "qty="+qty + "&no="+no + "&reserveSeq="+reserveSeq,
	})
	.then(response => response.text())
	.then((data) =>{
		if(data >= 1){
			alert("예약 취소 완료!");
			location.href =ctx+"/userReserveList.do";
		}
	})
	.catch(() => alert("오류!"));
	
}