<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

  <div class="inner">
  <h1 > 회원수정</h1>

<form action="${ctx}/updateUser.do" method="post">
  <table>
	<td>이메일</td>
	<td><input type="text" name="email" id="email" required /></td>
	</tr>
	<tr>
	<td>전화번호</td>
	<td><input type="text" name="phone" id="phone" required /></td>
	</tr>
  <tr>
    <td colspan="2">
     	<input type="submit" value="수정하기"/>
    </td>
  </tr>
</table>
</form>
</div>
<%@ include file="../parts/footer.jsp"%>