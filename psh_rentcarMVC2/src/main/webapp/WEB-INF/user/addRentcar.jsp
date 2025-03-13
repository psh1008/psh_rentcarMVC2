<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

  <div class="inner">
  <h1 > 차량추가</h1>

<form action="${ctx}/addRentcar.do" method="post">
  <table>
  <tr>
    <td>이름</td>
    <td><input type="text" name="name" id="name" required autofocus /></td>
  </tr>
  <tr>
	<td>카테고리</td>
	<td><select name="category">
	<option value="1">소형</option>
	<option value="2">중형</option>
	<option value="3">대형</option>
	</select></td>
	</tr>
	<tr>
    <td>가격</td>
    <td><input type="text" name="price" id="price" required/></td>
  </tr>
  <tr>
    <td>승차인원</td>
    <td><input type="text" name="usepeople" id="usepeople" required/></td>
  </tr>
  <tr>
    <td>총 수량</td>
    <td><input type="text" name="total_qty" id="total_qty" required/></td>
  </tr>
  <tr>
    <td>회사정보</td>
    <td><input type="text" name="company" id="company" required/></td>
  </tr>
  <tr>
    <td>이미지</td>
    <td><input type="text" name="img" id="img" required/></td>
  </tr>
  <tr>
    <td>차량정보</td>
    <td><input type="text" name="info" id="info" required/></td>
  </tr>
  
  <tr>
    <td colspan="2">
      <button class="btn-submit" > 등록하기 </button>
      <button class="btn-cancel">취소</button>
    </td>
  </tr>
</table>
</form>
</div>

<%@ include file="../parts/footer.jsp"%>