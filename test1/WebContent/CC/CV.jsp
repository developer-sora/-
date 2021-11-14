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
	<div class="rddiv">
		<form action="CC">
			<!--이부분 수정해야함-->

			<table class="cctable">


				<tr>
					<td>



						<p>
							<img width="100" src="./CC/hansik.png">
						<p>
							<button name="food" value="KoreanFood">한식</button>
					</td>

					<td valign=bottom><img width="140" src="./CC/mandoo.png">
						<p>
							<button name="food" value="ChineseFood">중식</button></td>

					<td valign=bottom><img width="120" src="./CC/susi.png">
						<p>

							<button name="food" value="JapaneseFood">일식</button></td>
				</tr>
				<tr>

					<td>
						<p>
							<img width="100" src="./CC/hamberg.png">
						<p>
							<button name="food" value="Dessert_FastFood">패스트푸드/디저트</button>
					</td>


					<td valign=bottom><h2>
							배고픈<br>당신의<br>선택은?
						</h2></td>


					<td valign=bottom><img width="100" src="./CC/asian.png">

						<p>
							<button name="food" value="Asia_Western">아시안/양식</button>
							<!-- Asia_Western.jsp--></td>
				</tr>
				<tr>

					<td valign=bottom><img width="100" src="./CC/gogi.png">

						<p>
							<button name="food" value="Pizza">고기</button>
							<!-- Pizza.jsp--></td>
					<td valign=bottom><img width="100" src="./CC/chi.png">

						<p>
							<button name="food" value="Chicken">치킨</button>
							<!--경로 : Chicken.jsp --></td>
					<td valign=bottom><img width="100" src="./CC/bunsik.png">

						<p>
							<button name="food" value="Boonyasik">분식/야식</button>
							<!--경로 : Boonyasik.jsp --></td>
				</tr>

			</table>
		</form>
	</div>




</body>
</html>