<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<div class="inner">
    <div class="page-center">
            <h2 class="reservation-title">회원리스트</h2>
		<table border="1">
			<tr height="40">
				<td width="150" align="center"> 회원번호 </td>
				<td width="150" align="center"> 이름 </td>
				<td width="150" align="center"> 아이디 </td>
				<td width="150" align="center"> 비밀번호 </td>
				<td width="150" align="center"> 이메일 </td>
				<td width="150" align="center"> 핸드폰번호 </td>
				<td width="90" align="center"> 삭제 </td>
			</tr>
                <c:forEach var="user" items="${list}">
                    <tr class="user-row">
                    	<td>${user.num}</td>
                    	<td>${user.name}</td>
                    	<td>${user.userid}</td>
                    	<td>${user.pwd}</td>
                    	<td>${user.email}</td>
                    	<td>${user.phone}</td>
                        <td><button class="action-btn delete-btn" onclick="location.href='${ctx}/deleteUser.do?num=${user.num}'">회원삭제</button></td>
                    </tr>
                </c:forEach>
            </table>
    </div>
</div>

<%@ include file="../parts/footer.jsp"%>