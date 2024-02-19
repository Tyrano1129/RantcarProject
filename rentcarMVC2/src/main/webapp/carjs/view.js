/**
 
 */

let price = [...document.querySelectorAll("#price")];

for(let i = 0; i < price.length; i+=1){
	let temp = price[i];
	temp.toLocaleString("ko-KR");
	price[i].value = temp + "원";
}