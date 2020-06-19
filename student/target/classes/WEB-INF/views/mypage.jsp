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
			<input type="password" id="password" name="password" placeholder="기존 비밀번호"  required>
			<input type="password" id="passwordChk" name="passwordChk" placeholder="변경할 비밀번호 " required>
			<input type="text" name="name" placeholder="이름"  value="${member.getName() }" required>
			<input type="text" name="email" placeholder="이메일"  value="${member.getEmail() }"required>
			<select class="department">
					<option value="${member.getD_name() }">${member.getD_name() }
					<c:forEach items="${list }" var="item">
					<option value="${item.name}">${item.name}
				</c:forEach>
			</select>
			<input type="hidden" id="d_name" name="d_name">
			<input type="submit" value="확인">
		</form>
	</section>
	<footer class="footer"></footer>
</body>
<script src="/resources/js/join.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
</html>