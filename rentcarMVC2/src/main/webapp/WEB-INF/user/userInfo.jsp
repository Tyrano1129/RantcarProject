<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/join.css" />
<div class="join-wrapper">
	<h2>회원정보</h2>
	<form action="joinUser.do" method="POST" id="join-form">
		<div class="id">
			<input type="text" id="id" name="id" value="${vo.id}" required/> 
		</div>
		<input type="password" name="pw" placeholder=" 비밀번호" id="pw" />
		<div class="ajh">
			<input type="number" name="age" value="${vo.age}" required/> 
			<input type="text" name="job" value="${vo.job}" placeholder="직업" /> 
			<input type="text" name="hobby" value="${vo.hobby}" placeholder="취미" />
		</div>
		<input type="text" name="tel" placeholder=" 전화번호" oninput="hypenTel(this)" maxlength="13" value="${vo.tel}" /> 
		<input type="email" name="email" value="${vo.email}" placeholder=" 이메일" />
		<textarea name="info" cols="40" rows="10" placeholder="자기소개해주세요!" style="resize: none">${vo.info}</textarea>
		<input type="button" value="수정하기" onclick="vildUpdataCheck(form)" />
		<input type="button" value="탈퇴하기" onclick="vildDeleteCheck(form,'${ctx}')">
	</form>
</div>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/userjs/updata.js"></script>