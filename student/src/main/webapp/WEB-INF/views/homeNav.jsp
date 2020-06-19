<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/css/home.css" rel="stylesheet" />
</head>
<body>
	<header class="header">
		<div class="login">
			<c:if test="${member == null }">
				<span><a href="/login">로그인 |</a></span>
				<span><a href="/join">회원가입</a></span>			
			</c:if>
			<c:if test="${member != null }">
				<span><a href="/mypage">마이페이지 |</a></span>
				<span><a href="/logout">로그아웃</a></span>
			</c:if>
		</div>
		<div>
			<a href="/">
				<span class="title">✅ 학생관리 시스템 🙋‍♀️</span>
			</a>
		</div>
		<nav>
			<ul>
				<li><a href="/board/main">공지사항</a></li>
				<li><a href="/lecture/evaluate/main">강의 평가 (학생)</a></li>
				<li><a href="/lecture/signUp">수강 신청</a></li>
				<li><a href="#">성적 확인 (학생)</a></li>
				<li><a href="/lecture/main">강의 등록 (선생님)</a></li>
				<li><a href="#">성적 관리 (선생님)</a></li>
				<li><a href="/bamboo/main">대나무숲</a></li>
			</ul>
		</nav>
	</header>
</body>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
</html>