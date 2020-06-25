<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/resources/css/home.css" rel="stylesheet"/> 
<title>마이페이지</title>
</head>
<body>
	<%@include file="homeNav.jsp" %>
	<section class="main">
		<div class="pageTitle">💡 마이페이지</div>
		<form  id="mypageForm" class="joinForm" action="/mypage" method="post" >
			<input type="text" name="id" placeholder="아이디" maxlength="" value="${member.getId() }" readonly>
			<input type="text" name="name" placeholder="이름"  value="${member.getName() }" readonly>
			<input type="text" name="email" placeholder="이메일"  value="${member.getEmail() }"readonly>
			<input type="text" value="${member.getD_name() }" readonly>
			<input type="hidden" id="d_name" name="d_name">
			<input type="submit" id="mypageSubBtn" value="확인">
			<a href="/changePw" class="pwChage">🔒 비밀번호 변경하기</a>
			<button id="memberDropBtn">회원 탈퇴</button> 			
		</form>
	</section>
	<footer class="footer"></footer>
</body>
<script src="/resources/js/join.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
</html>