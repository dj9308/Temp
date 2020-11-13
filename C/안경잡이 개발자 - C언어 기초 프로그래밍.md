# 안경잡이 개발자 - C언어 기초 프로그래밍

## C 언어 기본 사항

- 컴파일러 : 컴퓨터가 알아들을 수 있는 언어로 변환시켜주는 프로그램
- Dev C ++ : C언어 및 C++의 컴파일 기능과 개발 환경을 제공하는 대표적인 IDE.
- 어셈블리어 : 기계와 일대일 대응이 되는 컴퓨터 프로그래밍의 저급 언어
- 포인터 : 특정한 데이터가 저장되어 있는 메모리의 주소 그 자체를 저장하는 변수
- C언어는 메모리 주소에 직접 접근할 수 있다. 또한 운영체제 또한 만들 수 있다.

## Dev C++

- TDM-GCC : Dev C++ 에서 기본적으로 제공하는 컴파일러 중 하나

## 기본 frame

```c
#include <stdio.h>  // 라이브러리 추가 부분
// 라이브러리를 추가해야 printf같은 함수를 사용 가능

int main(void) // main 함수이라는 것은 처음 프로그램을 시작했을 때 가장 첫 번째로 시작되는 부분 => 컴파일러가 변환시킬때 main 함수부터 실행시킴.
{
    int x = 50;
    float y = 123456789.12345678;
    print
    
	printf("변수 x의 메모리 크기는 %d이다.", sizeof(x)); // "%d" : d안에 x라는 값이 들어가는 것
	return 0; // main이 함수이기 때문에 return을 반환함.
}
```

## 입출력

- 가끔 버퍼가 프로그램 동작을 방해한다. C언어에서는 간단하게 getchar() 함수로 버퍼의 공백 문자를 받을 수 있다.
- scanf() 함수를 사용할 때 변수 이름 앞에 &를 붙여야 한다.
- 형식 지정자를 %c로 하면 엔터(enter)도 하나의 공백 문자로서 입력받을 수 있다.

```c
#include <stdio.h>

int main(void){
	int x;
	// 사용자로부터 입력 받을 때 사용 
	scanf("%d",&x); //&: 특정한 변수에 메모리 부여를 의미함. 
}
```

## 변수

- ```c
  #include<stdio.h>
  #include<limits.h> // INT_MAX 관련 라이브러리
  
  int main(){
  	int x = INT_MAX;
  	printf("int형의 최댓값 x는 %d입니다.\n",x);
  	printf("x+1인 %d입니다.\n", x+1);
  	//x+1인 -2147483648입니다. 
  	//한바퀴를 건너 뛰어 최솟값으로 돌아가버림.
  	// 이것이 overflow라는 개념 
      
      float h = 123456789.12345678;
  	// float = 4byte까지만 출력 가능함
  	double z = 123456789.12345678;
  	// double = 8byte 
      printf("h=%.2f\n", y) ; // 소수 둘때자리 실수 출력 \n : 줄바꿈 
      
      // 사착연산 관련
      int y = 20;
  	printf("x+y : %d이다. \n",x+y);
  }
  ```


## 연산자

- ```c
  #include <stdio.h>
  #define SECOND_PER_MINUTE 60; // 상수 선언 부분
  
  int main(){
  	int input = 1000;
  	int minute = input / SECOND_PER_MINUTE;
  	int second = input % SECOND_PER_MINUTE;
  	printf("%d초 %d분%d초 입니다.",input,minute,second);
  }
  
  
  int main(void){
  	int x = 50, y = 30;
  	int absoluteX = (x>0) ? x: -x;  // 삼항연산자
  	int max = (x>y) ? x: y;
  	int min = (x>y) ? y: x;
  	printf("x의 절댓값은 %d 입니다.",absoluteX);
  	printf("x와 y의 최댓값 및 최솟값은 각각 %d, %d 입니다.", max,min);
  	return 0;
  }
  ```

- ```c
  #include <stdio.h>
  #include <math.h> // math 라이브러리 pow() 거듭제곱, abs() 절대값 
  
  int main(void){
  	double x= pow(2.0,20.0);
  	printf("2의 20제곱은 %0.f입니다.\n",x); 
  	return 0;
  }
  ```

- ```c
  #include <stdio.h>
  
  int main(void){
  	int x = 50, y = 30;
  	printf("x가 y보다크고 y는 40 미만입니까? %d\n", (x>y) && (y<40) );
  	printf("x가 y보다 작거나 호은 y가 30입니까? %d\n", (x<y) || (y==30));
  	printf("x가 50이 아닙니까? %d", x!=50);
  	return 0;
  }
  
  // 1 / 1 / 0  : 참은 1, 거짓은 0으로 반환된다. 
  ```

## 조건문, 반복문

- ``` c
  while(1){  // 참은 true가 아닌 1이기 때문
      if(a==1) break;
  }
  ```




## 알게된 함수

- sizeof(변수) : 메모리를 반환
- INT_MAX : int 최대값
- scanf("%d",&d) : 입출력 관련 함수

## 알게된 점

- C의 기본적인 틀 : 라이브러리 import 방식 / main 함수
- overflow 개념
- C의 출력 방식 / %d(정수), %.2f(소수 둘째자리까지 실수), %c(char)
- 상수 선언
- 참 거짓은 각각 1, 0 정수로 반환됨
- 

## 느낀점

- 자바를 알아서 그런지 배우는데 속도가 느리진 않았다.
- 프로그래머라면 C는 기본적으로 알아야할 것이기 때문에 배우는 것.
- 어짜피 개발자 일을 몇년 하는 것이 아니라 죽을 때까지 하는 것이라면 배우는 것이 더 좋을 것 같아서 늦지 않게 공부하는 것이라 생각한다.
- 

