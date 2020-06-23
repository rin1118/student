<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/board.css" rel="stylesheet"/> 
</head>
<body>
<%@include file="../homeNav.jsp" %>
<section class="main">
	<div class="pageTitle">📢 공지사항</div>
	<div class="registerForm">
		<form id="boardForm">
			<span>제목</span> 
			<input type="text" name="title" value="${title}" class="writeInfo" readOnly>
			<span>작성자</span> 
			<input type="text" name="writer" value="${writer}" class="writeInfo" readOnly>
			<span>내용</span> 
			<textarea name="content" readOnly >${content }</textarea>
			<input type="hidden" name="id" value="${id}">
			<span class="submitContainer">
				<input type="submit" value="수정" id="boardUpdateBtn" class="registerSubmit">
				<input type="submit" value="삭제" id="boardDeleteBtn" class="registerSubmit">			
			</span>
		</form>
	</div>
</section>
<script src="/resources/js/boardJS.js"></script>	
</body>
</html>