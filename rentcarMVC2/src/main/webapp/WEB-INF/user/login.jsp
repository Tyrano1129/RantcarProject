<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/parts/header.jsp" %>
<form action="loginUser.do">
<table border="1">
	<tr height="100">
		<td align="center" colspan="2"><font size="6" color="gray">
				로그인 </font></td>
	</tr>
	<tr height="40">
		<td width="120" align="center">아이디</td>
		<td width="180"><input type="text" name="id" size="15" /></td>
	</tr>
	<tr height="40">
		<td width="120" align="center">패스워드</td>
		<td width="180"><input type="password" name="pw" size="15" /></td>
	</tr>
	<tr height="40">
		<td align="center" colspan="2">
			<input type="button" value="로그인" onclick="validCheck(form,'${ctx}')" />
			<input type="button" value="가입하기" onclick="location.href='${ctx}/joinUser.do'" />
		</td>
	</tr>
</table>
</form>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<script defer src="${ctx}/userjs/userlogin.js"></script>