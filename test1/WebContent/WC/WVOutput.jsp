<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="index.css">

</head>

<body>

		<div class="wcwin_title">
		<img src="./img/wcwin.png" width=200px>
		</div>
		<form action = "LikeMain">
<input type="text" name="likename" value="${MenuL}" hidden="">
<input type="text" name="likeimg" value="${countImg1}" hidden="">
<div class="like-button2">
<button class = "like_button"><span style="color:black;font-size:20px;">찜하기</span>❤</button>
</div>
</form>	
	<table class = "wcwin_table">
		
		<tr><td class = "wcwin_first">
		<div class = "wcwin_div">
		<img name="select" class="wcwin_img" alt="읍네" src="./img/${countImg1}.jpg">
		<div class = "wcwin_text_div">
		<p class = "wcwin_text">${MenuL}</p>
		</div>
		</div>
		<div class="wc_button_div">
			<button class="wc_button" onclick="location.href='WC'">다시하기</button>
			<button class="wc_button" onclick="window.open('https://map.kakao.com/link/search/${MenuL}')">검색하기</button>
			</div></td></tr>
</table>

</body>
</html>

