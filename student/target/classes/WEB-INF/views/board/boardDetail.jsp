<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	<div class="registerForm">
		<form id="boardForm">
			<c:if test="${member.getRole() == 'admin' }">
				<span class="submitContainer">
					<input type="submit" value="수정" id="boardUpdateBtn" class="registerSubmit">
					<input type="submit" value="삭제" id="boardDeleteBtn" class="registerSubmit">			
				</span>			
			</c:if>
			<div class="pageTitle">${title}</div>
			<input type="text" name="title" value="${title}" class="writeInfo title" readOnly>
			<textarea name="content" readOnly >${content }</textarea>
			<input type="hidden" name="id" value="${id}">
			<button class="backBtn" id="backBtn">목록</button>
		</form>
	</div>
</section>
<script src="/resources/js/boardJS.js"></script>	
</body>
</html>