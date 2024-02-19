<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp" %>
<link rel="stylesheet" href="${ctx}/css/main.css" />
<div class="myslider">
	<c:forEach var="list" items="${list}">
      <div class="imges">
        <img src="img/${list.img}" id="imgcar"/>
        <p>${list.name}</p>
      </div>
    </c:forEach>
</div>
<%@include file="/WEB-INF/parts/footer.jsp" %>
<script defer src="${ctx}/carjs/slider.js">
</script>