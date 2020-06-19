<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 평가 작성</title>
<link href="/resources/css/evaluate.css" rel="stylesheet"/> 	
</head>
<body>
	<%@include file="../homeNav.jsp"%>
	<section class="main">
		<div class="pageTitle">✍ 강의 평가 작성</div>
			<form id="form" method="post" action="/lecture/evaluate/write"  class="evaluateItem">
				<input type="hidden" name="l_no" value="${l_no}">
				<span>
					<span>💡 강의분류</span>
					<input type="text" name="category" value="${category }" readOnly>			
				</span>
				<span>
					<span>💡 강의명</span>
					 <input type="text" name="title" value="${title }" readOnly>
				</span>
				<span>
					<span>💡 교수명</span>
					<input type="text" name="professor" value="${professor}" readOnly>
				</span>
				<textarea name="description" placeholder="내용을 작성해주세요" required></textarea>
				<input type="submit" id="submitBtn" value="확인"> 		
			</form>	
	</section>
</body>
</html>