<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의 등록</title>
<link href="/resources/css/lecture.css" rel="stylesheet" />
</head>
<body>
	<%@include file="../homeNav.jsp"%>
	<section class="main">
		<div class="pageTitle">✍ 강의 등록</div>
		<div class="registerForm">
			<form method="post" action="/lecture/register">
				<select name="category">
					<option value="전공">전공
					<option value="전선">전선
					<option value="교양">교양
				</select>
				<input class="lectureInfo" type="text" name="title" placeholder="강의명" required>
				<input class="lectureInfo" type="text" name="professor" placeholder="교수명" required>
				<textarea name="description" placeholder="강의 설명"></textarea>
				<input type="submit" value="등록" class="registerSubmit">
			</form>
		</div>
	</section>
</body>
</html>