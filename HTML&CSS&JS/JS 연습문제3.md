~~~javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var ary = [];
for(var i =0;i<10;i++){
	ary.push(Math.floor(Math.random()*50)+1);
}
document.write("정렬 전 : "+ary+"<br>");
var ary3 = ary.sort(function(a,b){return a-b}); 
document.write("정렬 후 : "+ary);


/* 

[ 자바스크립트 실습 - 4 ]


파일명 : exercise4.html
- 구현 내용
1. 10개의 크기를 갖는 자바스크립트 배열을 생성한다.
2. 1~50 사이의 난수 10개를 추출하여 각각의 원소에 저장한다.
3. 다음 형식으로 원소값을 출력한다.

    정렬 전 : n1,n2,n3,....

4. 원소값들을 오름차순 소팅하여 다음 형식으로 출력한다.

     정렬 후 : n1,n2,n3,.... */
</script>
</body>
</html>
~~~

