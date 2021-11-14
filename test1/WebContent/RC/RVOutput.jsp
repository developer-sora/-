<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="showImage()">
<form action = "LikeMain">
<input type="text" name="likename" value="${menuRandom}" hidden="">
<input type="text" name="likeimg" value="${menuRandomImg}" hidden="">
<div class="like-button">
<button class = "like_button"><span style="color:black;font-size:18px;">찜하기</span>❤</button>
</div>
</form>

<div class = "rddiv2">
<img class = "rdimgOutput" src="./img/${menuRandomImg}.jpg">
<div class="rd-result">
<p class = "rd_result">${menuRandom}</p>
</div>
<div class="rd-button">
<button class = "rd_button" style="margin-top:120px;" onclick="window.open('https://map.kakao.com/link/search/${menuRandom}')">검색</button><p>
<button class = "rd_button" style="margin-top:20px;" onclick="history.back()">다시하기</button>
</div>
</div>

</body>
</html>