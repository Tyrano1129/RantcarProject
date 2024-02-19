<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/join.css" />
<div class="join-wrapper">
	<h2>회원가입</h2>
	<form action="joinUser.do" method="POST" id="join-form">
		<div class="id">
			<input type="text" id="id" name="id" placeholder=" 아이디" /> 
			<input type="button" value="중복확인" id="checkId" />
		</div>
		<input type="password" name="pw" placeholder=" 비밀번호" id="pw" />
		<div class="ajh">
			<input type="number" name="age" placeholder="나이" /> 
			<input type="text" name="job" placeholder="직업" /> 
			<input type="text" name="hobby" placeholder="취미" />
		</div>
		<input type="text" name="tel" placeholder=" 전화번호" oninput="hypenTel(this)" maxlength="13" /> 
		<input type="email" name="email" placeholder=" 이메일" />
		<textarea name="info" cols="40" rows="10" placeholder=" 자기소개해주세요!" style="resize: none"></textarea>
		<input type="button" value="가입하기" onclick="vildjoinCheck(form)" />
	</form>
</div>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/userjs/userjoin.js"></script>