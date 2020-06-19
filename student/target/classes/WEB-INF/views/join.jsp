<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/css/home.css" rel="stylesheet"/> 
<title>회원가입</title>
</head>
<body>
	<%@include file="homeNav.jsp" %>
	<section class="main">
		<div class="pageTitle">✍ 회원가입</div>
		<form  id="joinForm" class="joinForm" action="/join" method="post" >
			<input type="text" name="id" placeholder="아이디" maxlength="" required>
			<input type="password" name="password" placeholder="비밀번호" required>
			<input type="text" name="name" placeholder="이름" required>
			<input type="text" name="email" placeholder="이메일" required>
			<select class="department">
					<option value="">학과를 선택해주세요
					<c:forEach items="${list }" var="item">
					<option value="${item.name}">${item.name}
				</c:forEach>
			</select>
			<input type="hidden" id="d_name" name="d_name">
			<input type="submit" value="가입">
		</form>
	</section>
	<footer class="footer"></footer>
</body>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/resources/js/join.js"></script>
</html>