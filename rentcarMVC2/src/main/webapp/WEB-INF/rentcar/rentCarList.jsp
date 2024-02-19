<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<div>
<c:if test="${list ne null }">
	<table>
		<tr height="60">
			<td align="center" colspan="3">
			<c:if test="${category eq null}">
				<font size="6" color="gray">전체 자동차 리스트</font>
			</c:if>
			<c:if test="${category ne null}">
				<font size="6" color="gray">${category}자동차 리스트</font>
			</c:if>
			</td>
		</tr>
		<c:forEach var="list" items="${list}" varStatus="loop">
		<c:if test="${loop.index % 3 == 0}">
			<tr height="220">
		</c:if>
			<td width="333" align="center">
			<a href="${ctx}/rentCartInfo.do?num=${list.no}">
				<img alt="" src="img/${list.img}" width="300" height="200" class="imges">
			</a>
			<p>${list.name}</p>
			<font size="3" color="gray"><b>${list.name}</b></font>
			</td>

		<c:if test="${loop.index % 3 == 2 or loop.last}">
			</tr>
		</c:if>
		</c:forEach>
	</table>
	<hr size="3" color="red">
	<form action="${ctx}/carList.do" method="post">
		<font size="3" color="gray"><b>차량 검색 하기</b></font>&nbsp;&nbsp;
		<select name="category">
			<option value="1">소형</option>
			<option value="2">중형</option>
			<option value="3">대형</option>
			<option value="4">신형</option>
		</select>
		<input type="submit" value="검색"/>&nbsp;
	<input type="button" onclick="location.href='${ctx}/carList.do'" value="전체 검색">
	</form>
</c:if>
</div>
<%@include file="/WEB-INF/parts/footer.jsp"%>
