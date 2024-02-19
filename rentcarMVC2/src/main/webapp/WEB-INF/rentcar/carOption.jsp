<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/car.css" />
<form class="carinfoto" action="${ctx}/reserveCarView.do" method="post">
      <div class="container">
        <div class="imgs">
          <img class="img" src="img/${img}" />
        </div>
        <table class="carinfo">
          <tr>
            <td>대여기간</td>
            <td>
           		<select name="dday">
           		<c:forEach var="i" begin="1" end="7">
           			<option value="${i}">${i}일</option>
           		</c:forEach>
           		</select>
            </td>
          </tr>
          <tr>
            <td>대여일</td>
            <td>
           	 	<input type="date" name="rday" id="today" min="${today}" size="15" value="${today}">
            </td>
          </tr>
          <tr>
            <td>보험적용</td>
           	<td><select name="usein">
            	<option value="1">적용(1일 1만원)</option>
            	<option value="2">비적용</option>
            </select>
            </td>
          </tr>
          <tr>
            <td>Wifi 적용</td>
            <td>
            	<select name="usewifi">
            		<option value="1">적용(무료)</option>
            		<option value="2">비적용</option>
            	</select>
            </td>
          </tr>
          <tr>
            <td>네비게이션 적용</td>
            <td>
            	<select name="usenavi">
            		<option value="1">적용(무료)</option>
            		<option value="2">비적용</option>
            	</select>
            </td>
          </tr>
          <tr>
            <td>베이비시트 적용</td>
            <td>
            	<select name="useseat">
            		<option value="1">적용(1일 1만원)</option>
            		<option value="2">비적용</option>
            	</select>
            </td>
          </tr>
          <tr>
          	<td align="center">
          		<input type="hidden" name="qty" value="${qty}">
          		<input type="hidden" name="num" value="${no}">
          		<input type="submit" value="차량예약하기">
          	</td>
          </tr>
        </table>
      </div>
</form>
<%@include file="/WEB-INF/parts/footer.jsp"%>