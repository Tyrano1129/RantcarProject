<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/car.css" />
<c:if test="${car.totalQty == 0}">
	<form action="${ctx}/main.do">
		<h1>${car.name}차는더이상 재고 수량이 없습니다.</h1>
		<input type="submit" value="홈으로..." width="100" height="100">
	</form>
</c:if>
<c:if test="${car.totalQty != 0}">
	<hr>
	<form class="carinfoto" action="${ctx}/carOption.do" method="post">
		<div class="carinfoto_container">
			<div class="imgs">
				<img class="img" src="img/${car.img}" />
				<c:if test="${logId != null }">
					<input type="hidden" name="img" value="${car.img}">
					<input type="hidden" name="no" value="${car.no}">
					<input type="submit" value="옵션 선택후 렌트 예약 하기">
				</c:if>
			</div>
			<table class="carinfo">
				<tr>
					<td>차량이름</td>
					<td>${car.name}</td>
				</tr>
				<tr>
					<td>총 승차인원</td>
					<td>${car.usepeople}</td>
				</tr>
				<tr>
					<td>차량수량</td>
					<td><select name="qty">
							<c:forEach var="i" begin="1" end="${car.totalQty}">
								<option value="${i}">${i}</option>
							</c:forEach>
					</select></td>
				</tr>
				<tr>
					<td>차량분류</td>
					<td><c:if test="${car.category == 1}">소형</c:if> <c:if
							test="${car.category == 2}">중형</c:if> <c:if
							test="${car.category == 3}">대형</c:if> <c:if
							test="${car.category == 4}">신형</c:if></td>
				</tr>
				<tr>
					<td>제조회사</td>
					<td>${car.company}</td>
				</tr>
			</table>
		<h1>${car.info}</h1>
		</div>
	</form>
</c:if>
<%@include file="/WEB-INF/parts/footer.jsp"%>