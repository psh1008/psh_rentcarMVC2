<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시현 렌트카</title>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<body></body>

	<header>
		<div class="container">
			<nav>
				<div class="logo">
					<a href="/psh_rentcarMVC2/main.do"><img src="img/rent_logo.jpg"
						alt="logo" width="100" height="100"></a>
				</div>
				<div class="banner">
					<a href="/psh_rentcarMVC2/rentcarList.do">차량리스트</a>
					<c:if test="${log eq null}">
						<a href="/psh_rentcarMVC2/join.do">회원가입</a>
						<a href="/psh_rentcarMVC2/login.do">로그인</a>
					</c:if>
					<c:if test="${log eq -1}">
						<a href="/psh_rentcarMVC2/userList.do">회원리스트</a>
						<a href="/psh_rentcarMVC2/addRentcar.do">차량추가</a>
					</c:if>
					<c:if test="${log ne null}">
						<a href="/psh_rentcarMVC2/logout.do">로그아웃</a>
						<a href="/psh_rentcarMVC2/reservationList.do">예약확인</a>
						<a href="/psh_rentcarMVC2//userInfo.do">내정보</a>
					</c:if>
				</div>
				<div class="search">
					<input type="text" value="차량검색"> <input type="submit"
						value="🔍">
				</div>
			</nav>

		</div>
	</header>