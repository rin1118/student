<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 평가</title>
<link href="/resources/css/evaluate.css" rel="stylesheet"/> 	
</head>
<body>
	<%@include file="../homeNav.jsp"%>
	<section class="main">
		<div class="pageTitle">📖 강의 평가</div>
		<div>
			<div class="searchContainer">
				<form class="searchForm" method="get" action="/lecture/evaluate/search" >
					<select>
						<option value="l.title">강의명
						<option value="l.professor">교수명
						<option value="e.description">내용
					</select>
					<input id="category" type="hidden" name="category">
					<input type="text" name="searchValue" class="search" placeholder="검색">
					<input type="submit" name="searchBtn" class="searchBtn" value="검색">		
				</form>
			</div>
			<a href="/lecture/evaluate/write" class="writeBtn">작성</a>
			<br>
			
			<c:if test="${not empty search}">
				<c:forEach items="${search }" var="item">
					<form class="evaluateItem">
						<input type="hidden" name="e_no" value="${item.e_no}">
						<span>⏰ ${item.regDate}</span>
						<span>
							<span>💡 강의분류</span>
							<input type="text" name="category" id="category" value="${item.category}" readOnly>					
						</span>
						<span>
							<span>💡 강의명</span>
							<input type="text" name="title" value="${item.title}" readOnly> 
						</span>
						<span>
							<span>💡 교수명</span>
							<input type="text" name="professor" value="${item.professor}" readOnly> 
						</span>
						<textarea name="description" readOnly>${item.description}</textarea> 
						<input type="submit" id="submitBtn" name="updateBtn" value="수정"> 
						<input type="submit" id="submitBtn" name="deleteBtn" value="삭제">					
					</form>
				</c:forEach>
			</c:if>
			<c:if test="${empty search && empty list }">
				<span>검색 결과를 찾을 수 없습니다</span>
			</c:if>
				
				
			<c:forEach items="${list }" var="item">
				<form class="evaluateItem">
					<input type="hidden" name="e_no" value="${item.e_no}">
					<span>⏰ ${item.regDate}</span>
					<span>
						<span>💡 강의분류</span>
						<input type="text" name="category" id="category" value="${item.category}" readOnly>					
					</span>
					<span>
						<span>💡 강의명</span>
						<input type="text" name="title" value="${item.title}" readOnly> 
					</span>
					<span>
						<span>💡 교수명</span>
						<input type="text" name="professor" value="${item.professor}" readOnly> 
					</span>
					<textarea name="description" readOnly>${item.description}</textarea> 
					<c:if test="${item.m_no == member.getM_no()}">
						<input type="submit" id="submitBtn" name="updateBtn" value="수정"> 
						<input type="submit" id="submitBtn" name="deleteBtn" value="삭제">										
					</c:if>
				</form>
				<br>
			</c:forEach>
		</div>	
	</section>
</body>
<script src="/resources/js/evaluate.js"></script>
</html>