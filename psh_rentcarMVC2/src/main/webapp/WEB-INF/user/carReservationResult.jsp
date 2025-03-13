<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<div class="inner">
	<form action="${ctx}/main.do">
	<div class="reserveCar-Photo">
			<img src="${ctx}/img/${img}" width="600" height="500">
		</div>
		<table>
		<tr>
		<td>
		<h1>차량 총예약 금액 ${totalRs}원</h1> <!-- qty * price * dday-->
		</td>
		</tr>
		<tr>
		<td>
		<h1>차량 총옵션 금액 ${totalOp}원</h1><!-- qty * dday * ((usein + usewifi + usenavi + useseat)*1000)-->
		</td>
		</tr>
		<tr>
		<td>
		<h1>차량 총 금액 ${totalPrice}원 </h1>
		</td>
		</tr>
		<tr>
				<td align="center" colspan="2">
				<input type="submit" value="메인으로 가기"/>
				</td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../parts/footer.jsp"%>