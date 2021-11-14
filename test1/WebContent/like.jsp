<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div class = "like_body_div">
</div>
		<c:if test="${empty likes}">
			<h3 align="center" style="margin-top:200px;">찜한 메뉴가 없어요.</h3>
			</c:if>
		<c:if test="${not empty likes}">	
			<c:forEach var="l" items="${likes}">
				<div class="like_div">
					<img class="like_img" src='./img/${l.img }.jpg' width="500px">
					<div class="like_menu">
						<h2 class="like_menu_name">${l.name}</h2>
					</div>
				</div>
				</c:forEach>
			<form action="LikeMain" method="post">
			<div class ="delete-button">
				<button class = "delete_button">삭제하기</button>
				</div>
			</form>
</c:if>


</body>
</html>