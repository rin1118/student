<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link href="/resources/css/board.css" rel="stylesheet"/> 
</head>
<body>
<%@include file="../homeNav.jsp" %>
	<section class="main">		
	<div class="pageTitle">✍ 게시글 작성</div>
		<div class="registerForm">
			<form method="post" action="/board/write">
				<input type="text" name="writer" class="writeInfo"  value="${member.getName()}" readonly>
				<input type="text" name="title" class="writeInfo title" required placeholder="제목">
				<textarea name="content" placeholder="내용"></textarea>
				<input type="submit" value="확인" class="backBtn write">
			</form>
		</div>
	</section>
</body>
</html>