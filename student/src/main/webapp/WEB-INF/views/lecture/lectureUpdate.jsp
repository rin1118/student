<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 수정</title>
<link href="/resources/css/lecture.css" rel="stylesheet" />
</head>
<body>
<%@include file="../homeNav.jsp" %>
	<section class="main">
		<div class="pageTitle">✍  강의 수정</div>
		<div class="registerForm">
			<form id="lectureForm">
					<input type="submit" id="deleteBtn" class="button del" value="삭제">	
					<select name="category">
					<option value="전공">전공
					<option value="전선">전선
					<option value="교양">교양
				</select>
				강의명 
				<input type="text" name="title" value="${title }" class="lectureInfo" required>
				교수명 
				<input type="text" name="professor" value="${professor}" class="lectureInfo" readOnly>
				강의 내용 
				<textarea name="description">${description}</textarea>
				<input type="hidden" name="l_no" value="${id }">
				<span class="btnContainer">
					<button id="backBtn" class="button cancel">취소</button> 
					<input type="submit" id="updateBtn" class="button submit" value="확인">						
				</span>
			</form>
		</div>	
	</section>
</body>
<script src="/resources/js/lecture.js"></script>
</html>