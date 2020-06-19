<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강신청</title>
<link href="/resources/css/lectureBook.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../homeNav.jsp"%>
	<section class="main">
		<div id="signUp">
			<div class="pageTitle">✅ 수강신청</div>
			<c:forEach items="${lectureList}" var="item">
				<form action="/lecture/signUp" method="post" id="BookForm${item.l_no }"  class="listItem">
					<span>강의분류 :</span> 
					<input type="text" name="category" value="${item.category }" readOnly>
					<span>강의명 :</span> 
					<input type="text" name="title" value="${item.title }" readOnly>
					<span>교수명 :</span> 
					<input type="text" name="professor" value="${item.professor}" readOnly>
					<input type="hidden" id ="l_no" name="l_no" value="${item.l_no }">
					<input type="submit" value="신청" id="submitBtn">
				</form>
			</c:forEach>
		</div>
		<div>
				<div class="pageTitle">💡 강의 신청내역</div>
				<div id="result">
					<c:forEach items="${bookList}" var="item">	
						<form action="/lecture/signUpCancel" method="post" id="BookForm${item.l_no }"  class="listItem">
							강의분류: <input type="text" name="category" value="${item.category }" readOnly>
							강의명 : <input type="text" name="title" value="${item.title }" readOnly>
							교수명 : <input type="text" name="professor" value="${item.professor}" readOnly>
							<input type="hidden" id ="l_no" name="l_no" value="${item.l_no }">
							<input type="submit" value="삭제" id="deleteBtn">
						</form>	
					</c:forEach>	
				</div>
		</div>
	</section>
</body>
<script src="/resources/js/lectureBook.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
</html>