<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 관리</title>
<link href="/resources/css/lecture.css" rel="stylesheet"/> 
</head>
<body>
	<%@include file="../homeNav.jsp"%>
	<section class="main">
		<div class="pageTitle">📕 강의 목록</div>
		<a href="/lecture/register" class="writeBtn">등록</a>
		<table class="listItem">  
			<th>강의번호</th>
			<th>분류</th>
			<th>강의명</th>
			<th>내용</th>
			<th>교수명</th>
			<th></th>
			<c:forEach items="${list}" var="item">
					<tr>
						<td>${item.l_no}</td>
						<td>${item.category}</td>
						<td>${item.title}</td>
						<td>${item.description}</td>
						<td>${item.professor}</td>
						<td>
							<a href="/lecture/update?id=${item.l_no}" class="updateBtn">수정</a>
						</td>
					</tr>
			</c:forEach>
		</table>
	</section>
</body>
</html>