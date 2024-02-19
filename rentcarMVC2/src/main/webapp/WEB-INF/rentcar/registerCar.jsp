<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/parts/header.jsp"%>
<link rel="stylesheet" href="${ctx}/css/adminpage.css">
    <h1>관리자 페이지</h1>
    <form action="${ctx}/carInsert.do" class="insert" method="post">
      <table border="1" class="inserttable">
        <tr class="head">
          <td colspan="2" align="center">
            <h2>자동차 추가 등록</h2>
          </td>
        </tr>
        <tr>
          <td><label>자동차 이름</label></td>
          <td><input type="text" name="name" /></td>
        </tr>
        <tr>
          <td>
            <label>자동차 카테고리</label>
          </td>
          <td>
            <select name="categroy">
              <option value="1">소형</option>
              <option value="2">중형</option>
              <option value="3">대형</option>
            </select>
          </td>
        </tr>
        <tr>
          <td><label>자동차 렌트가격</label></td>
          <td><input type="number" name="price" /></td>
        </tr>
        <tr>
          <td><label>승차 인원</label></td>
          <td><input type="number" size="16" name="usepeople" /></td>
        </tr>
        <tr>
          <td><label>렌트카 총 수량</label></td>
          <td><input type="number" name="totalQty" /></td>
        </tr>
        <tr>
          <td><label>차량 회사 정보</label></td>
          <td><input type="text" name="company" /></td>
        </tr>
        <tr>
          <td><label>차량 이미지</label></td>
          <td>
            <img
              src="https://upload.wikimedia.org/wikipedia/commons/1/14/No_Image_Available.jpg"
              id="image"
              class="defalut"
            />
          	<input type="hidden" name="imgurl" id="imgurl">
          </td>
        </tr>
        <tr>
          <td><label>차량 정보</label></td>
          <td><textarea name="info" cols="30" rows="10"></textarea></td>
        </tr>
        <tr>
          <td colspan="2"><input type="button" value="올리기" id="up" onclick="vaildCheckInsert(form)"></td>
        </tr>
      </table>
    </form>
	<form class="fils" method="post" enctype="multipart/form-data">
		<input type="file" accept="image/*" name="fileimg" id="fileimg" />
	</form>
<%@include file="/WEB-INF/parts/footer.jsp"%>
<script defer src="${ctx}/carjs/uploadfile.js"></script>