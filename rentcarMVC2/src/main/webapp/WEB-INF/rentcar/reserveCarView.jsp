<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/view.css" />
<form  class="forms" action="${ctx}/main.do">
     <img class="image" src="img/${img}" alt="" />
      <table class="table" align="center">
        <tr class="header">
          <td colspan="2">
            <h1>차량 예약 영수증</h1>
          </td>
        </tr>
        <tr>
          <td>차량 총예약 금액</td>
          <td id="price">${totalCar}</td>
        </tr>
        <tr>
          <td>차량 총옵션 금액</td>
          <td id="price">${totalOption}</td>
        </tr>
        <tr>
          <td>차량 총 금액</td>
          <td id="price">${totalOption + totalCar}</td>
        </tr>
        <tr>
          <td class="button" colspan="2">
            <input type="submit" value="홈으로 이동" class="input" />
          </td>
        </tr>
      </table>
</form>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/carjs/view.js"></script>