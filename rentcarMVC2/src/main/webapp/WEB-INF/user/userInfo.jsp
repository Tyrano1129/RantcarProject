<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<div class="container">
	<h1>가입</h1>
	<form action="userUpdate.do" method="POST">
		<table border="1">
			<tr>
				<td><label>아이디  </label></td>
				<td><input type="text" name="id" id="id" value="${vo.id}" required></td>
			</tr>
			<tr>
				<td><label>비밀번호  </label></td>
				<td colspan="3"><input type="password" name="pw" id="pw"></td>

			</tr>
			<tr>
				<td><label> 나이  </label></td>
				<td colspan="3"><input type="number" name="age" value="${vo.age}" required></td>

			</tr>
			<tr>
				<td><label> 직업  </label></td>
				<td><input type="text" name="job" value="${vo.job}"></td>
				<td><label> 취미  </label></td>
				<td><input type="text" name="hobby" value="${vo.hobby}"></td>
			</tr>
			<tr>
				<td><label> 전화번호  </label></td>
				<td colspan="3"><input type="text" name="tel"
					oninput="hypenTel(this)" maxlength="13" value="${vo.tel}"></td>
			</tr>
			<tr>
				<td><label>이메일</label></td>
				<td colspan="3">
					<input type="text" name="email" value="${vo.email}">
				</td>
			</tr>
			<tr>
				<td><label>자기소개</label></td>
				<td colspan="3"><textarea rows="10" cols="20" name="info">${vo.info}</textarea></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="button"
					value="수정하기" onclick="vildUpdataCheck(form)">
					<input type="button" value="탈퇴하기" onclick="vildDeleteCheck(form,'${ctx}')"></td>
			</tr>
		</table>
	</form>
</div>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/userjs/updata.js"></script>