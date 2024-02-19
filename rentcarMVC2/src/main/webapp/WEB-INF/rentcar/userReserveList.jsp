<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/userresList.css">
<div align="center">
		<table>
			<tr height="100">
				<td align="center" colspan="11"> 
					<font size="6" color="gray"> 차량 예약 완료 화면 </font> 
				</td>
			</tr>
		</table>
		<table class="userreslist">
			<tr class="title">
	        <td class="w150 t_line r_line" align="center">이미지</td>
	        <td class="w150 t_line r_line" align="center">이름</td>
	        <td class="w150 t_line r_line" align="center">대여일</td>
	        <td class="w60 t_line r_line" align="center">대여기간</td>
	        <td class="w60 t_line r_line" align="center">수량</td>
	        <td class="w60 t_line r_line" align="center">보험</td>
	        <td class="w60 t_line r_line" align="center">wifi</td>
	        <td class="w60 t_line r_line" align="center">베이비시트</td>
	        <td class="w60 t_line r_line" align="center">네비게이션</td>
	        <td class="w100 t_line r_line" align="center">총 금액</td>
	        <td class="w90 t_line" align="center">삭제</td>
     	 </tr>
		
<c:if test="${list ne null}"> 	
		<c:forEach var="list" items="${list}">
			<tr class="list">	
				<td class="w150 t_line r_line" align="center">
					<img src="img/${list.img}"  width="120" height="70" class="cursor">
				</td>
				<td class="w150 t_line r_line" align="center">${list.name}</td>
				<td class="w150 t_line r_line" align="center">${list.rday}</td>
				<td class="w60 t_line r_line" align="center">${list.dday}일</td>
				<td class="w60 t_line r_line" align="center">${list.qty}대</td>
				<td class="w60 t_line r_line" align="center"><c:if test="${list.usein == 1}">적용</c:if>
				<c:if test="${list.usein == 2}">미적용</c:if></td>
				<td class="w60 t_line r_line" align="center"><c:if test="${list.usewifi == 1}">적용</c:if>
				<c:if test="${list.usewifi == 2}">미적용</c:if></td>
				<td class="w60 t_line r_line" align="center"><c:if test="${list.useseat == 1}">적용</c:if>
				<c:if test="${list.useseat == 2}">미적용</c:if></td>
				<td class="w60 t_line r_line" align="center"><c:if test="${list.usenavi == 1}">적용</c:if>
				<c:if test="${list.usenavi == 2}">미적용</c:if></td>
				<td class="w100 t_line r_line" align="center">${list.price}원</td>
				<td class="w90 t_line" align="center">
				<button onclick="validDelete(${list.qty},${list.no},${list.reserveSeq},'${ctx}')">삭제</button>
				</td>
			</tr>
		</c:forEach>
</c:if>		
		</table>
	</div>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/carjs/userreservedelete.js"></script>