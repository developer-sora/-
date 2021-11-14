<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"> 
var imgArray = new Array(); 
imgArray[0]="./img/22.jpg"; 
imgArray[1]="./img/9.jpg"; 
imgArray[2]="./img/1.jpg";
imgArray[3]="./img/63.jpg";
imgArray[4]="./img/40.jpg";
imgArray[5]="./img/44.jpg";

function showImage(){ 
var imgNum = Math.round(Math.random()*5);
var objImg = document.getElementById("rdimg"); 
objImg.src = imgArray[imgNum]; 
setTimeout(showImage,500); 
} 
</script>

</head>

<body onload="showImage()">
<form action="RC" method="post">
<div class = "rddiv">
<img id = "rdimg">
<div class="rd-text">
<p class = "rd_text">오늘 먹을 메뉴는...</p>
</div>
<div class="rd-button">
<button class = "rd_button">고르기</button>
</div>
</div>
</form>
</body>
</html>