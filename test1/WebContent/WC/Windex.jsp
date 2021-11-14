<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  
<div class="parent">
<div class="child first">
<img src="1.jpg" alt="Menu">
</div>
<div class="child second">
VS
</div>
<div class="child third">
<img src="2.jpg" alt="Menu">
</div>	
</div>
	-->
	
	<div class="wctitle">
		<img class = "wctitle1" src="./img/wctitle.png" width=300px>
				<img src="./img/wc64.png" width=180px>
				</div>
	<table class = "wtable">
	<tr>
	<td class="first">
		<form action="WC" method="post">
            <input type="text" value="${userData}" name="userDataSum" hidden="">
            <P />
            <input type="text" value="${count}" name="count" hidden="">
            <P />
            <input type="text" value="${round}" name="round" hidden="">
            <P />
            <input type="text" value="${nextRound32}" name="nextRound32"
               hidden="">
            <P />
            <input type="text" value="${nextRound16}" name="nextRound16"
               hidden="">
            <P />
            <input type="text" value="${nextRound8}" name="nextRound8" hidden="">
            <P />
            <input type="text" value="${nextRound4}" name="nextRound4" hidden="">
            <P />
            <input type="text" value="${nextRound2}" name="nextRound2" hidden="">
            <P />
            <input type="text" value="${nextRound1}" name="nextRound1" hidden="">
            <P />
            <input value="1" name="select" hidden="">
             <button class="myBtn">
               <img class = "wcimg" alt="냉면"
                  src="./img/1.jpg">
            </button>
            
            
        </form>
	
	<!--  
	<img class="wcimg" src="1.jpg" alt="WorldCup">
	-->
	<h2 class="wcmenu" style="margin-top:10px;">냉면</h2>
	</td>
	<td class="second"><h2>VS</h2></td>
	<td class="third">
	  <form action="WC" method="post">
            <input type="text" value="${userData}" name="userDataSum" hidden="">
            <P />
            <input type="text" value="${count}" name="count" hidden="">
            <P />
            <input type="text" value="${round}" name="round" hidden="">
            <P />
            <input type="text" value="${nextRound32}" name="nextRound32"
               hidden="">
            <P />
            <input type="text" value="${nextRound16}" name="nextRound16"
               hidden="">
            <P />
            <input type="text" value="${nextRound8}" name="nextRound8" hidden="">
            <P />
            <input type="text" value="${nextRound4}" name="nextRound4" hidden="">
            <P />
            <input type="text" value="${nextRound2}" name="nextRound2" hidden="">
            <P />
            <input type="text" value="${nextRoun1}" name="nextRound1" hidden="">
            <P />
            <input value="2" name="select" hidden="">
        <button class="myBtn">
            <img class = "wcimg" alt="쌈밥"
                  src="./img/2.jpg">
            </button>
         
         </form><!--  
	<img class = "wcimg" src="2.jpg" alt="WorldCup">
         -->
	<h2 class="wcmenu" style="margin-top:10px;">쌈밥</h2>
	</td>
		</tr>
		</table>
		<p/><p/><p/>

	
</body>
</html>