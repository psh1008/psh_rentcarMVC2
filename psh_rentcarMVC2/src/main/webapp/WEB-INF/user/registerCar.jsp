<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<div class="inner">

	<form action="${ctx}/carSelect.do">
		<h1>${car.name}</h1>
		<div class="reserveCar-Photo">
			<img src="${ctx}/img/${car.img}" width="600" height="500">
		</div>
		<table>
			<tr height="100">
				<td align="center" colspan="3"><font size="6" color="gray">
						옵션 선택</font></td>
			</tr>
			<tr>
				<td width="250" align="center">대여기간</td>
				<td width="250" align="center"><select name="dday">
						<option value="1">1일</option>
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
						<option value="6">6일</option>
						<option value="7">7일</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">대여일</td>
				<td width="250" align="center"><input type="date" name="rday" id="today"
					size="15"></td>
			</tr>
			<script>
				document.getElementById("today").value= new Date().toISOString().substring(0,10);
			</script>
			
			<tr>
				<td width="250" align="center">보험적용</td>
				<td width="250" align="center"><select name="usein">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">Wifi 적용</td>
				<td width="250" align="center"><select name="usewifi">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">네비게이션 적용</td>
				<td width="250" align="center"><select name="usenavi">
						<option value="1">적용(무료)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			<tr>
				<td width="250" align="center">베이비시트 적용</td>
				<td width="250" align="center"><select name="useseat">
						<option value="1">적용(1일 1만원)</option>
						<option value="2">비적용</option>
				</select></td>
			</tr>
			 <input type="hidden" name="num" value="${num}" />
			 <input type="hidden" name="qty" value="${qty}" />
			 <input type="hidden" name="price" value="${car.price}" />
			 <input type="hidden" name="img" value="${car.img}" />
			 
			<tr>
				<td align="center" colspan="2">
				<input type="submit" value="차량예약하기" />
				</td>
			</tr>

		</table>
	</form>
</div>
<%@ include file="../parts/footer.jsp"%>