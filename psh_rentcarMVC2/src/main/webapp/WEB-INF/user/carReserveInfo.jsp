<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../parts/header.jsp"%>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/style.css">

<div class="inner">
	<form action="${ctx}/registerCar.do">
		<h1>${car.name}</h1>
		<div class="reserveCar-Photo">
			<img src="${ctx}/img/${car.img}" width="600" height="500">
		</div>
		<table class="car-info">
			<tr>
				<th>차량이름</th>
				<td>${car.name}</td>
			</tr>
			<tr>
				<th>승차인원</th>
				<td>${car.usepeople}</td>
			</tr>
			<tr>
				<th>차량수량</th>
				<td><select name="qty" id="qtyVal">
						<c:forEach var="carCnt" begin="1" end="${car.total_qty}">
							<option value="${carCnt}">${carCnt}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>차량분류</th>
				<td><c:if test="${car.category eq 1}">
						<c:out value="소형" />
					</c:if> <c:if test="${car.category eq 2}">
						<c:out value="중형" />
					</c:if> <c:if test="${car.category eq 3}">
						<c:out value="대형" />
					</c:if></td>
			</tr>
			<tr>
				<th>대여가격</th>
				<td>${car.price}원</td>
			</tr>
			<tr>
				<th>제조회사</th>
				<td>${car.company}</td>
			</tr>
			<tr>
				<c:if test="${car.total_qty eq 0}">
					<h1>현재 차량수량이 없습니다 죄송합니다</h1>
				</c:if>
				<td colspan="2"><c:if
						test="${car.total_qty ne 0 and log ne null}">
						<input type="hidden" name="num" value="${car.num}" />
						<input type="hidden" name="price" value="${car.price}" />
						<input type="hidden" name="img" value="${car.img}" />
						<button class="reserve-Btn">옵션선택</button>
					</c:if> <c:if test="${log eq -1}">
						<button type="button" class="update-Btn"
							onclick="location.href='${ctx}/updateRentCar.do?num=${car.num}'">차량정보수정</button>
						<button type="button" class="remove-Btn"
							onclick="location.href='${ctx}/deleteRentCar.do?num=${car.num}'">차량삭제</button>
					</c:if></td>
			</tr>
		</table>
	</form>
</div>
<%@ include file="../parts/footer.jsp"%>