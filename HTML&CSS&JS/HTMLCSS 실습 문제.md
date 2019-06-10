



## HTML/CSS 실습 문제

형식에 맞게 페이지를 완성하시오. 

![제목 없음](C:\Users\student\Desktop\제목 없음.png)

~~~ html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
font-weight: bold;
}

a{
text-decoration: none;
}
span.a{
margin: 50px;
}
img:hover {
opacity : 0.5;
}
span.a:hover{
font-weight: bold;
}
table,th,td{
border : 1px solid green;
border-collapse : collapse;
text-align: center;
}
th,td{

}
th{
background-color: lime;
}
article{
border: 2px solid purple;
	border-radius: 30px; 
	width: 80%;
	height : auto;
margin: 20px auto;
padding: 20px;
}
footer{
background-color: black;
color: white;
margin: 20px auto;
padding: 20px;
text-align: center;
}

</style>
</head>
<body>
<header style="background-image: linear-gradient(135deg,yellow,pink);">
<h1 style="text-align: center; text-shadow: 2px 2px 2px white; color: purple">HTML5 학습</h1><br>
<nav style="text-align: center"><a href="http://www.w3schools.com"><span class="a">W3C</span></a>
<a href="http://www.w3schools.com"><span class="a">W3SCHOOLS</span></a>
<a href="http://www.w3schools.com"><span class="a" style="color: blue;">jQuery</span></a>
</nav>
</header>

<section>
<article>
<h2 style="color: purple">나의 소개</h2><br>
<ul style="height: auto; margin-top: -20px">
<li>이름 : 설 동재</li>
<li>별명 : OMG</li>
<li>관심기술 : JAVA</li>
<li>취미 : 독서</li>
</ul>
</article>
<article>
<h2 style="color: green">올해 재미있게 읽은 책</h2><br>
<table border="1">
<tr><th>제목</th><th>장르</th></tr>
<tr><td>총균쇠</td><td>인문</td></tr>
<tr><td>정의란 무엇인가</td><td>경제</td></tr>
<tr><td>고양이</td><td>소설</td></tr>
</table>
</article>
<article >
<h2 style="color: blue">자랑하고싶은 <span style="color: purple">우리동네</span>의 아름다운 곳</h2><br>
<p >시흥갯골생태공원은 경기도 유일의 내만 갯골과 옛 염전의 정취를 느낄 수 있는 아름다운 곳입니다. 
칠면초, 나문재, 퉁퉁마디 등의 염생식물과 붉은발 농게, 방게 등 각종어류, 
양서류가 서식하고 있어 자연 생태가 온전히 보존되어 있으며 시흥갯골은 2012년 2월 국가습지보호구역으로 지정되었습니다. 시에서는 이곳을 친환경적 개발로 국가적 명소화,
세계적 관광지화를 목표로 공원조성을 완료할 계획이며 매년 ‘시흥갯골축제’가 열리는 장소이기도 합니다.</p>
<figure style="text-align: center;"><img src="../images/siheung.png" width="80%" height="auto">
<figcaption style="width: auto">시흥 갯골생태공원</figcaption>
</figure>
</article>
</section>
<aside style="text-align: center;">
   <video src="mediaexam/trailer.mp4" controls width="80%" height="auto">
  </video>  
</aside>
<footer>	
<i>이 문서는 설 동재에 의해 HTML5와 CSS3 기술을 사용하여 2019년 5월 27일에 작성하였습니다.(ver 1.0)</i>
</footer>
</body>
</html>
~~~

![1](C:\Users\student\Desktop\1.png)

![2](C:\Users\student\Desktop\2.png)