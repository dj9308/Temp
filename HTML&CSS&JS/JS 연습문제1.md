~~~javascript
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
</style>
</head>
<body>
	<script type="text/javascript">
		var ans;
		var num1 = window.prompt("첫번째 숫자를 입력하세요.");
		if (isNaN(num1) || num1 == '' || num1 == null)
			document.writeln("숫자를 입력해 주세요!!!!");
		num1 *= 1;
		var num2 = window.prompt("두번째 숫자를 입력하세요.");
		if (isNaN(num2) || num2 == '' || num2 == null)
			document.writeln("숫자를 입력해 주세요!!!!");
		num2 *= 1;
		var giho = window.prompt("연산자를 입력하세요.");
		if (giho != '+' && giho != '-' && giho != '*' && giho != '/'
				&& giho != '%' || giho == '' || giho == null) {
			document
					.writeln("<h2 style=\"color: red\">+, -, *, /, % 만 입력 가능</h2>");
		} else {
			switch (giho) {
			case '+':
				ans = num1 + num2;
				break;
			case '-':
				ans = num1 - num2;
				break;
			case '*':
				ans = num1 * num2;
				break;
			case '/':
				ans = num1 / num2;
				break;
			case '%':
				ans = num1 % num2;
				break;
			}
			document.writeln("<h2 style=\"color: blue\">" + num1 + "와 " + num2
					+ "의 " + giho + "연산 결과는 " + ans + "입니다.</h2>");
		}
		/* 
		
[ 자바스크립트 실습 - 2 ]

파일명 : exercise2.html

- 구현 내용
두 개의 숫자와 한 개의 연산자를 prompt() 함수를 세 번 수행시켜서 입력받는다.
(연산자는 +, -, *, /, % 로 제한)
입력된 두 개의 숫자에 대하여 입력된 연산자로 연산하고 그 결과를 다음과 같이
출력한다.(<h2> 태그, 파란색)

     X 와 Y 의 Z 연산 결과는 W 입니다.

만일 입력된 연산자가 위의 5개 연산자가 아니면 
"+, -, *, /, % 만 입력 가능" 이라는 <h2> 태그와 함께
빨간색으로 메세지를 출력한다.
*/
	</script>
	
</body>
</html>
~~~

![2](C:\Users\student\Desktop\2.png)