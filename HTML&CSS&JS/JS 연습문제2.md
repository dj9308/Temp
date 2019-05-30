~~~javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
var ary =[10,5,7,21,4,8,18];
var sum = 0*1;
var max = ary[0]*1;
var min = ary[0]*1;
for(var i=0;i<ary.length;i++){
	sum+=ary[i];
}
document.write("모든 원소의 합 : "+sum+"<br>");

for(var i=1;i<ary.length;i++){
	if(max<ary[i])
		max = ary[i];
	if(min>ary[i])
		min =ary[i];
}
document.write("최대값 : "+max+"<br>");
document.write("최소값 : "+min+"<br>");

/* [ 자바스크립트 실습 - 3 ]


파일명 : exercise3.html

1. 다음의 값들을 저장하는 배열을 생성한다.
   10, 5, 7,21, 4, 8, 18

2. 모든 원소 값들을 더하여 다음 형식으로 HTML 첫 번째 제목 크기로 출력한다.

      모든 원소의 합 : XX

3. 최대값과 최소값을 구해서 순서없는 리스트 형식으로 다음 형식으로 출력한다.

     - 최대값 : XX
     - 최소값 : XX

 */
</script>
</body>
</html>

~~~

![3](C:\Users\student\Desktop\3.png)