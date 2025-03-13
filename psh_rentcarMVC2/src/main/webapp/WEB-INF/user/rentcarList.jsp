<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<div class="inner">
    <!-- 카테고리 선택 폼 추가 -->
    <form action="${ctx}/carListByCategory.do" method="post">
        <label for="category">카테고리 선택: </label>
        <select name="category" id="category">
            <option value="1">소형</option>
            <option value="2">중형</option>
            <option value="3">대형</option>
        </select>
        <input type="submit" value="선택" />
    </form>

    <c:set var="i" value="0" />
    <c:set var="j" value="3" />
    <table>
        <tr>
            <td align="center" colspan="3">
                <font size="6" color="gray">전체 렌트카 보기</font>
            </td>
        </tr>
        <c:forEach var="rl" items="${list}">
            <c:if test="${i%j eq 0}">
                <tr>
            </c:if>
            <td>
                <a href="${ctx}/carReserveInfo.do?num=${rl.num}">
                    <img class="rentcar" src="${ctx}/img/${rl.img}" width="400" height="300">
                </a>
            </td>
            <td>${rl.name}</td>
            <c:if test="${i%j eq j-1}">
                </tr>
            </c:if>
            <c:set var="i" value="${i+1}" />
        </c:forEach>
    </table>
</div>
<%@ include file="../parts/footer.jsp"%>