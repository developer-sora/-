<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/index.css">
</head>
<body>

		<div class="rddiv">
		<table class="cctable">
		
		<tr>
			<td>
				<form action="KoreanFood.jsp">
				<img width="100" src="./img/1.jpg"><br></br>
					<input id="bt" type="button" value="냉면"
						onClick="location.href='https://map.kakao.com/link/search/냉면'">
						
				</form>
			</td>
			<td>
			<img width="100" src="./img/2.jpg"><br></br>
			<input id="bt" type="button" value="쌈밥"
				onClick="location.href='https://map.kakao.com/link/search/쌈밥'">
			</td>
			<td>
			<img width="100" src="./img/3.jpg"><br></br>
			<input id="bt" type="button" value="찜"
			onClick="location.href='https://map.kakao.com/link/search/찜'"></td>
		</tr>
		<tr>
			<td>
			<img width="100" src="./img/4.jpg"><br></br>
			<input id="bt" type="button" value="도시락"
			onClick="location.href='https://map.kakao.com/link/search/도시락'"></td>
			<td><img width="100" src="./CC/hansik.png">
			<p>한식</td>
			<td>
			<img width="100" src="./img/5.jpg"><br></br>
			<input id="bt" type="button" value="죽"
			onClick="location.href='https://map.kakao.com/link/search/죽'"></td>
		</tr>
		<tr>
			<td>
			<img width="100" src="./img/6.jpg"><br></br>
			<input id="bt" type="button" value="국밥"
			onClick="location.href='https://map.kakao.com/link/search/국밥'"></td>
			<td><img width="100" src="./img/7.jpg"><br></br>
			<input id="bt" type="button" value="전"
			onClick="location.href='https://map.kakao.com/link/search/전'"></td>
			<td><img width="100" src="./img/8.jpg"><br></br>
			<input id="bt" type="button" value="탕/찌개"
			onClick="location.href='https://map.kakao.com/link/search/찌개'"></td>
		</tr>
	</table>
	<br></br>
		<button id="b" onclick="location.href='CC'">아니야 안끌려!</button>
		</div>
</body>
</html>