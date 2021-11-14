<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오늘 뭐 먹지?</title>
<link rel="stylesheet" href="CSS/index.css">


</head>
<body>

	<div class="div_header">
	<header class = "header">
		<div class = "hometitle"><img src="./img/logo.png" width="130px"></div>
		<nav>
		<div class = "footer">
		<ul>
		<li><a href="RC">랜덤</a></li>
		<li><a href="CC">선택지</a></li>
		<li><a href="WC">월드컵</a></li>
		<li><a href="NC">내주변</a></li>
		<li><a href="DBC">❤</a></li>
		</ul>
		</div>
		</nav>
		
	</header>
</div>
 <jsp:include page="${contentPage}"></jsp:include>




</body>
</html>