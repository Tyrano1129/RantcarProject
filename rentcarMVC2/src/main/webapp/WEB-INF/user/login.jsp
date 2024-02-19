<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/parts/header.jsp" %>
<link rel="stylesheet" href="${ctx}/css/login.css" />
<div class="login-wrapper">
      <h2>Login</h2>
      <form action="loginUser.do" id="login-form" method="post">
        <input type="text" name="id" placeholder="UserID" />
        <input type="password" name="pw" placeholder="Password" />
        <input type="button" value="로그인" onclick="validCheck(form,'${ctx}')" />
        <input type="button" value="가입하기" onclick="location.href='${ctx}/joinUser.do'" />
      </form>
</div>
<%@ include file="/WEB-INF/parts/footer.jsp" %>
<script defer src="${ctx}/userjs/userlogin.js"></script>