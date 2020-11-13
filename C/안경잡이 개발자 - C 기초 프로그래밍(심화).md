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

