<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대나무 숲 🌳</title>
<link href="/resources/css/bamboo.css" rel="stylesheet" />
</head>
<body>
<%@include file="../homeNav.jsp" %>
	<section class="main">
		<div class="pageTitle">✍ 게시글 작성</div>
		<div class="view">
			<div class="writeContainer">
				<form class="writeForm" action="/bamboo/write" method="POST">
					<input type="text" name="title" class="itemTitle" placeholder="제목">
					<div class="writerInfo">
						<input type="text" name="writer" placeholder="작성자">
						<input class="password" type="password" name="password" placeholder="비밀번호">
					</div>
					<textarea class="messageBox" name="description" placeholder="내용"></textarea>
					<input type="submit" value="확인">
				</form>
			</div>
		</div>
	</section>
</body>
<script src="/resources/js/bamboo.js"></script>
</html>