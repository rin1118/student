<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대나무 숲 🌳</title>
<link href="/resources/css/bamboo.css" rel="stylesheet" />
</head>
<body>
<%@include file="../homeNav.jsp" %>
	<section class="main">
		<div class="pageTitle">🌳 대나무 숲</div>
		<div class="view">
			<a href="/bamboo/write" class="writeBtn">작성</a>
			<div class="searchContainer">
				<form class="searchForm" method="get" action="/bamboo/search" >
					<select>
						<option value="title">제목
						<option value="writer">작성자
						<option value="description">내용
					</select>
					<input id="category" type="hidden" name="category">
					<input type="text" name="searchValue" class="search" placeholder="검색">
					<input type="submit" name="searchBtn" class="searchBtn" value="검색">		
				</form>
			</div>
			
			<c:if test= "${search != null}">
					<c:forEach items="${search }" var="item">
					<div class="message">
						<ul class="messageItem">
							<li class="itemTitle">
								<span>${item.title}</span>
							</li>
							<li class="writeInfo">
								<span>🍀 ${item.writer }</span>
								<span>
									<fmt:formatDate value="${item.regdate}" pattern="yyyy.MM.dd" />
								</span>
							</li>
							<li class="messageBox">
								<p>${item.description }</p>
							</li>
							<li>
								<div class="favContainer">
									<input type="hidden" id="b_no" value="${item.b_no }">
									<button id="favBtn" class="favBtn" data-b_no=${item.b_no }>👍</button>
									<span id="favNum">${item.favorite}</span>
									
									<button id="notFav" class="favBtn" data-b_no=${item.b_no }>👎</button>
									<span id="notFavNum">${item.notFav }</span>
								</div>
							</li>
						</ul>
					</div>
				</c:forEach>
			</c:if>
			<c:if test="${empty search && empty list}">
				<span>검색 결과를 찾을 수 없습니다.</span>
			</c:if>
			
			<c:forEach items="${list}" var="item">
				<div class="message">
					<ul class="messageItem">
						<li class="itemTitle">
							<a href="#" class="messageUpdate" data-b_no="${item.b_no}" data-writer="${item.writer}">${item.title}</a>
						</li>
						<li class="writeInfo">
							<span>🍀 ${item.writer }</span>
							<span>
								⏰ <fmt:formatDate value="${item.regDate}" pattern="yyyy.MM.dd" />
							</span>
						</li>
						<li class="messageBox">
							<p>${item.description }</p>
						</li>
						<li>
							<div class="favContainer">
								<input type="hidden" id="b_no" value="${item.b_no }">
								<button id="favBtn" class="favBtn" data-b_no=${item.b_no }>👍</button>
								<span id="favNum">${item.favorite}</span>
								
								<button id="notFav" class="favBtn" data-b_no=${item.b_no }>👎</button>
								<span id="notFavNum">${item.notFav }</span>
							</div>
						</li>
					</ul>
				</div>
			</c:forEach>	
		</div>
	</section>
</body>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="/resources/js/bamboo.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</html>