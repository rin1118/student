<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link href="/resources/css/home.css" rel="stylesheet"/> 
</head>
<body>
	<%@include file="homeNav.jsp" %>
	<section class="main">
		<div class="pageTitle">💡 로그인</div>
		<form class="loginForm" id="loginForm" method="post" action="/login">
			<input type="text" name="id" placeholder="아이디">
			<input type="password" name="password" placeholder="비밀번호">
			<c:if test="${msg == false }">
				<div id="msg">
					<span>아이디나 비밀번호를 확인해 주세요.</span>
				</div>		
			</c:if>
			<input type="submit" value="로그인">
		</form>
		<span>
			<a href="/find?value=id">🔒 아이디</a>
			<a href="/find?value=pw">비밀번호 찾기</a>		
		</span>
	</section>
	<footer class="footer">
	</footer>
</body>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/resources/js/join.js"></script>
</html>