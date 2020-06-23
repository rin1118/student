<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 평가작성</title>
<link href="/resources/css/evaluate.css" rel="stylesheet"/> 	
</head>
<body>
	<%@include file="../homeNav.jsp"%>
	<section class="main">	
		<div class="pageTitle">📖 수강 강의목록</div>
		<table class="listItem" id="lectureBookList">
			<tr>
				<th>강의분류</th>
				<th>강의명</th>
				<th>교수명</th>
				<th></th>
			</tr>
			<c:forEach items="${bookList}" var="item">
					<form method="get" action="/lecture/evaluate/writeView">	
						<tr>
							<td>
								<input type="text" name="category"  value="${item.category }" readOnly>
							 </td>
							<td>
								<input type="text" name="title" value="${item.title }" readOnly>
							</td>
							<td>
								<input type="text" name="professor"  value="${item.professor}" readOnly> 
							</td>
							<td><input type="submit" value="평가 작성"></td>
						</tr>
						<input type="hidden" id="l_no" name="l_no" value="${item.l_no }">
					</form>
			</c:forEach>
		</table>
	</section>
</body>
<script src="/resources/js/evaluate.js"></script>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>

</html>