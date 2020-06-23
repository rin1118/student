<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
<link href="/resources/css/board.css" rel="stylesheet"/> 	
</head>
<body>
<%@include file="../homeNav.jsp" %>

<section class="main">
	<div class="pageTitle">📢 공지사항</div>
	<c:if test="${member.role == 'admin'}">
		<a href="/board/write" class="writeBtn">작성</a>
	</c:if>
	<table class="listItem">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
		<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.b_no}</td>
					<td>
						<a href="/board/detail?id=${item.b_no}">${item.title}</a>
					</td>
					<td>${item.writer}</td>
					<td>${item.regdate}</td>
				</tr>
		</c:forEach>
	</table>
</section>
<br><br>
<script src="/resources/js/boardJS.js"></script>
</body> 
</html>