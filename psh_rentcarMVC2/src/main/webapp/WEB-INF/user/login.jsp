<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

  <div class="inner">
  <h1 > 로그인</h1>

<form action="${ctx}/login.do" method="post">
  <table>
  <tr>
    <td>아이디</td>
    <td><input type="text" name="id" required autofocus /></td>
  </tr>
  <tr>
    <td>패스워드</td>
    <td><input type="password" name="pw" required/></td>
  </tr>
  <tr>
    <td colspan="2">
      <button class="btn-submit" > 로그인 </button>
    </td>
  </tr>
</table>
</form>
</div>
<%@ include file="../parts/footer.jsp"%>