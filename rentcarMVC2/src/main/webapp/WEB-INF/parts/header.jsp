<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${ pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<!-- slick.js -->
<script type="text/javascript"
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css" />
<link rel="stylesheet" type="text/css"
	href="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick-theme.css" />
<script type="text/javascript"
	src="//cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
<script defer src="${ctx}/carjs/reserve.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table >
			<tr height="70" >
				<td colspan="3"><a href="${ctx}/main.do"
					style="text-decoration: none"> <img alt=""
						src="img/rent_logo.jpg" height="120">
				</a></td>
				<td align="center" width="200"><c:if test="${logId == null }">
					GUEST
					<button onclick="location.href='${ctx}/loginUser.do'">로그인
						</button>
					</c:if> <c:if test="${logId != null }">
						<a href="${ctx}/userInfo.do" style="text-decoration: none">${logId}</a>
						<button onclick="location.href='${ctx}/logoutUser.do'">
							로그아웃</button>
					</c:if></td>
			</tr>
			<tr height="50" align="center">
				<td align="center" width="200" bgcolor="pink"><font
					color="white" size="5"><a href="${ctx}/carList.do"
						style="text-decoration: none">예 약 하 기</a></font></td>
				<td align="center" width="200" bgcolor="pink"><font
					color="white" size="5"><a href="#none"
						onclick="vaildreserveCheck('${logId}','${ctx}')"
						style="text-decoration: none">예 약 확 인</a></font></td>
				<c:if test="${logId == 'admin'}">
				<td align="center" width="200" bgcolor="pink"><font
					color="white" size="5"><a href="${ctx}/registerCar.do"
						style="text-decoration: none">차량새로등록</a></font></td>
				</c:if>
			</tr>
		</table>