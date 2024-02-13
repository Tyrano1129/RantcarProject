<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<%-- <link rel="stylesheet" href="${ctx}/css/join.css" /> --%>
<div class="container">
	<h1>가입</h1>
	<form action="joinUser.do" method="POST">
		<table border="1">
			<tr>
				<td><label>아이디  </label></td>
				<td><input type="text" name="id" id="id"></td>
				<td><input type="button" value="중복확인" id="checkId"></td>
			</tr>
			<tr>
				<td><label>비밀번호  </label></td>
				<td colspan="3"><input type="text" name="pw" id="pw"></td>

			</tr>
			<tr>
				<td><label> 나이  </label></td>
				<td colspan="3"><input type="number" name="age"></td>
			</tr>
			<tr>
				<td><label> 직업  </label></td>
				<td><input type="text" name="job"></td>
				<td><label> 취미  </label></td>
				<td><input type="text" name="hobby"></td>
			</tr>
			<tr>
				<td><label> 전화번호  </label></td>
				<td colspan="3"><input type="text" name="tel"
					oninput="hypenTel(this)" maxlength="13"></td>
			</tr>
			<tr>
				<td><label>이메일</label></td>
				<td colspan="3">
					<input type="text" name="email">
				</td>
			</tr>
			<tr>
				<td><label>자기소개</label></td>
				<td colspan="3"><textarea rows="10" cols="20" name="info">반갑습니다.</textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="button"
					value="가입하기" onclick="vildjoinCheck(form)"></td>
			</tr>
		</table>
	</form>
</div>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/userjs/userjoin.js"></script>