# 안경잡이 개발자 - C 기초 프로그래밍(심화)

## 반복함수와 재귀함수

- 반복함수 : for, while 문법을 이용해 특정한 처리를 반복하는 함수

- 재귀함수 : 자신의 함수 내부에서 자기자신을 호출함으로서 재귀적으로 문제를 해결하는 함수.

  - 경우에 따라서 간결하고 직관적인 코드로 문제를 해결할 수 있게 해준다.
  - 하지만 때에 따라서 심각한 비효율성을 낳을 수 있기 때문에 알고리즘을 작성할 때 유의할 필요가 있다.

- ```c
  #include <stdio.h>
  
  void print(int count){
  	if(count ==0){
  		return;  // 값 출력 없이 그냥 나가려면 return 만 쓰면 됨.
  	}
  	else{
  		printf("문자열을 출력합니다.\n");
  		print(count-1);
  	}
  }
  
  int main(void){
  	int number;
  	printf("문자열을 몇번 출력할까요? ");
  	scanf("%d", &number);
  	print(number);
  	return 0;
  }
  ```

- ### 조합

  - 서로 다른 n개의 물건에서 순서를 생각하지 않고 r개를 택할 때의 경우의 수
  - nCr로 표현한다.
  - r이 0이거나 n이면 1이며, 식은 nCr(n-1,r-1) + nCr(n-1,r)과 같다.

```c
#include <stdio.h>

int nCr(int n, int r){
	if(r ==0|| r==n){
		return 1;
	}else{
        // 수학 관련식을 재귀함수로 응용해서 구현할 수 있다.
		return nCr(n-1,r-1) + nCr(n-1,r);
	}
} 

int main(void){
	int n, r;
	scanf("%d %d",&n,&r);
	printf("%d",nCr(n,r));	
} 
```

## 포인터

- 특정 데이터에 저장된 메모리의 주소를 저장하는 변수이다.

- 다른 곳의 주소 그 자체를 가리키기 때문에 이를 응용해 다른 연산을 할 수 있다.

- 프로그램의 어떤 위치에서 시행되더라도 특정한 주소를 그대로 이용하기 때문에 값이 즉시 변경된다는 특징을 가지고 있다.

- 변수 저장시 변수의 값을 CRUD할 때 RAM의 특정한 위치에서 적용된다. 포인터의 경우, 메모리의 위치를 가리키는 것.

- int *y = &x : &는 변수 x의 주소를 의미한다. *y는 포인터를 뜻한다. 즉, x의 주소를 가리키는 하나의 또다른 변수가 된다.

- int x = 70,  int *y = &x;이라고 한다면 x = *y, &x = y; 라고 할 수 있다.

- ```c
  #include <stdio.h>
  
  // 두 변수의 값을 바꾸는 함수 
  void swap(int *x, int *y){
  	int temp= *x;  // x가 가리키는 주소의 값 
  	
  	*x = *y;
  	*y = temp;
  }
  // * 을 안쓸경우 x,y는 swap함수에만 적용되고 main 함수에는 적용이 안된다. 메모리에 저장이 안되기 때문이다. 
  // 포인터를 이용하면 프로그램 전역에서 언제 어디서나 값을 바꾸며 프로그래밍 기법, 해킹까지 할 수 있다. 
  
  int main(void){
  	int x = 1;
  	int y = 2;
  	swap(&x, &y);
  	printf("x=%d, y=%d\n",x,y);
  	return 0;
  }
  ```

- ```c
  #include <stdio.h>
  
  int main(void){
  	int i =10;
  	int *p;
  	p = &i;  //여기서 p는 *p를 뜻함. *를 생략했다고 하면 쉬울 듯
      // 포인터 p가 가리키는것이 i가 됨. i==p  ->1
  	printf("*i= %d\n", &i);
  	*p = 20; // 포인터 값과 해당 변수의 값은 같은건 같다. 
  	printf("*i= %d\n", i);
  	return 0;
  }
  ```


## 문자열

- 다양한 문자 표현을 나타내기 위해 사용한다.
- 내부적으로 무자열은 char 자료 타입의 배열로 이루어져 있으며 이것은 포인터와 같다고 할 수 있다.
- 결과적으로 다양한 문자열을 활용해보고 다룰 수 있는 능력이 필요하다.
- 영어 문자 같은 경우, 한 문자당 1byte의 크기를 차지한다.
- 한글, 중국어는 총 2byte의 크기를 차지한다.
- 즉, 10개의 문자(10byte)가 들어갈 수 있는 array가 생성되면(10개의 포인터) 영어는 10개, 한글은 5글자만 들어갈 수 있다.
- array의 값을 불러오게 되면 해당 위치의 메모리 주소값(array)를 불러온다. 즉, 포인터와 같다.
- array[1] =7 / &array[1] = 10002

```c
#include <stdio.h>
#include <string.h>	// 문자열 관련 라이브러리	

int main(void){
	char input[11];
    gets(input);
    // 문자열 scan 입력시 배열에 넣어주는 함수
    
	char result[5]="Love";
	strcpy(result,input); // result 문자 안에 input 카피 함수
	// strcpy string pointer 조작 관련 함수 
    
    printf("문자열 비교 : %d\n", strcmp(input,result));
    	// 사전적으로 동일시 0, one이 앞에있을시 -1, Two가 앞에 있을시 1이 반환된다.
	// 사전구현, 영단어 암기장 구현시 많이 사용됨. 
    
    printf("문자열의 길이: %d\n", strlen(input));
    // 문자열 길이 반환
    
	printf("문자열 복사 : %s\n",result);
	return 0; 
}
```

## 구조체(Struct)

- 



## 알게된 함수

- gets();
- strcpy();
- strcmp();
- strlen();