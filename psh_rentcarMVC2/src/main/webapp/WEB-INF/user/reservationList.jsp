<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<div class="inner">
    <div class="page-center">
        <c:if test="${reservList eq null}">
            <h2 class="no-reservation">예약내역이 없습니다!</h2>
        </c:if>
        <c:if test="${reservList ne null}">
            <h2 class="reservation-title">예약확인</h2>
		<table border="1">
			<tr height="40">
				<td width="150" align="center"> 예약번호 </td>
				<td width="150" align="center"> 이미지 </td>
				<td width="150" align="center"> 이름 </td>
				<td width="150" align="center"> 대여일 </td>
				<td width="60" align="center"> 대여기간 </td>
				<td width="100" align="center"> 금액 </td>
				<td width="60" align="center"> 수량 </td>
				<td width="60" align="center"> 보험 </td>
				<td width="60" align="center"> wifi </td>
				<td width="60" align="center"> 베이비시트 </td>
				<td width="60" align="center"> 네비게이션 </td>
				<td width="90" align="center"> 삭제 </td>
			</tr>
                <c:forEach var="reserv" items="${reservList}">
                    <tr class="reservation-row">
                    	<td>${reserv.reserveSeq}</td>
                        <td>
                        <div class="reserveCar-Photo">
						<img src="${ctx}/img/${reserv.img}" width="150" height="100">
						</div>	
                        </td>
                        <td>${reserv.name}</td>
                        <td>${reserv.rday}</td>
                        <td>${reserv.dday} 일</td>
                        <td>${reserv.price}</td>
                        <td>${reserv.qty}</td>
                        <td>${reserv.usein == 1 ? '적용' : '미적용'}</td>
                        <td>${reserv.usewifi == 1 ? '적용' : '미적용'}</td>
                        <td>${reserv.useseat == 1 ? '적용' : '미적용'}</td>
                        <td>${reserv.usenavi == 1 ? '적용' : '미적용'}</td>
                        <td><button class="action-btn delete-btn" onclick="location.href='${ctx}/deleteReservation.do?reserveSeq=${reserv.reserveSeq}'">예약취소</button></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
    </div>
</div>

<%@ include file="../parts/footer.jsp"%>