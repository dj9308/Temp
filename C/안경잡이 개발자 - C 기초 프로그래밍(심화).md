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
- 한글, 중국어는 총 3byte의 크기를 차지한다.
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

- 객체 지향 프로그래밍에서 말하는 클래스의 모체가 되는 것으로 여러 개의 자료형을 묶어서 새로운 자료형을 만들 수 있는 방법.

- 여러개의 데이터를 하나로 묶어서 사용할 수 있도록 하기 위해 만들어진 C언어의 문법이다.

- 배열이 여러 개의 같은 자료형들을 하나로 묶는 것이었다면 구조체는 서로 다른 자료형들을 하나로 묶어서 한꺼번에 다루는 것이다.

- ```CQL
  #include <stdio.h>
  #include <stdlib.h>
  #include <string.h>
  
  struct student{
  	int number;
  	char name[10];
  	double grade;
  };
  
  int main(void){
  	struct student s;
  	printf("학번을 입력하세요! ");
  	scanf("%d",&s.number);
  	printf("이름을 입력하세요! ");
  	scanf("%s",s.name);  // array의 경우 그 자체로 pointer이기 때문에 &을 넣을 필요가 없다. 
  	printf("학점을 입력하세요! ");
  	scanf("%lf",&s.grade); // double의 경우 lf로 해주면된다.
  	//float의 경우 f. 
  	
  	printf("학번 : %d\n",s.number);
  	printf("이름 : %s\n",s.name);
  	printf("학점 : %0.1f\n",s.grade);
  	return 0;
  }
  ```

- ```c
  #include <stdio.h>
  #include <math.h>
  
  struct point{
  	int x;
  	int y;
  };
  
  int main(void){
  	struct point p1, p2; // struct 동시 생성
  	int xDiff, yDiff;
  	double distance;
  	
  	printf("1번 점의 좌표를 입력하세요. : ");
  	scanf("%d %d",&p1.x, &p1.y);
  	
  	printf("2번 점의 좌표를 입력하세요. : ");
  	scanf("%d %d",&p2.x, &p2.y);
  	 
  	xDiff = p1.x - p2.x;
  	yDiff = p1.y - p2.y;
  	
  	distance = sqrt(xDiff * xDiff+ yDiff * yDiff);
  	printf("두 점 사이의 거리는 %lf입니다.",distance);
  	
  	return 0;
  }
  ```

### 활용

```c
#include <stdio.h>
#include <math.h>

struct point {
	int x;
	int y;
};

struct rect {  //struct 를 struct에 넣어 관리할 수 있다.
	struct point p1;
	struct point p2;
};

int main(void){
	struct rect r;
	int w, h, area, peri;
	
	printf("왼쪽 상단의 좌표를 입력하세요.");
	scanf("%d %d", &r.p1, &r.p2); 
	
	printf("오른쪽 상단의 좌표를 입력하세요.");
	scanf("%d %d", &r.p2, &r.p2);
	
	w = abs(r.p2.x - r.p1.x);
	h = abs(r.p2.y - r.p1.y);
	
	area = w*h;
	peri = 2*w + 2*h; 
	printf("%d : %d",w,h);
	printf("사각형의 넓이는 %d이고 둘레는 %d이다.",area,peri);
	return 0;
}

```



```c
#include <stdio.h>
#include <math.h>

struct point{
	int x;
	int y;
};

void comparePoint(struct point p1, struct point p2){
	if(p1.x==p2.x && p1.y==p2.y) {
		printf("p1, p2는 같다");
	}
} // 따로 struct 관련 함수로 만들어서 관리가 가능하다. 
// 함수를 따로 놓을 경우 훨씬 더 체계적으로 구조가 이루어질 수 있다. 

int main(void){
	struct point p1, p2;
	
	p1.x = 30;
	p1.y = 10;
	
	p2.x = 30;
	p2.y = 10;
	
	comparePoint(p1,p2);
	
//	if(p1==p2){ 오류 발생 : struct는 타입이 같아도 직접 비교 불가 
// 		
//	} // 구조체 자체는 서로 비교를 못한다. 
	return 0;
}
```



```c
#include <stdio.h>

#define SIZE 5

struct student {
	int number;
	char name[20];
	double grade; 
	 
};

int main(void){
	struct student list[SIZE];
	int i;
	
	for(i=0;i<SIZE;i++){
		printf("학번을 입력하세요. : ");
		scanf("%d", &list[i].number); 
		printf("이름을 입력하세요. : ");
		scanf("%s", &list[i].name); // list의 주소에 접근해야하기 때문에 해당 변수가 문자열이어도 &가 쓰인다.
		printf("학번을 입력하세요. : ");
		scanf("%lf", &list[i].grade);
	}
    
	for(i=0;i<SIZE;i++){
		printf("학번 : %d, 이름 : %s, 학점 : %.1lf",list[i].number,list[i].name,list[i].grade);
	};
	return 0;
}
```

## 파일 입출력

- 파일입출력은 다양한 프로그램을 개발할 때 자주 사용되는 기능이다. 

- 예를 들면 파일 입출력을 통해 현재의 데이터를 저장하고 다시 불러오거나 할 수 있다.

- 프로그램 전반에 사용되는 다양한 데이터를 처리하고 저장하여 보관할 수 있다.

- ``` c
  #include <stdio.h>
  // 쓰기
  int main(void){
  	FILE *fp = NULL;
  	fp = fopen("output.txt","w");
  	// w = 쓰기 모드를 의미한다. r => 읽기 모드를 의미 한다. 
  	if(fp ==NULL) {
  		printf("파일 열기에 실패했습니다\n");
  	}else{
  		printf("파일 열기에 성공했습니다.\n");
  	}
  	fputc('H',fp);  //file에 한글자씩 출력 (fileputcaracter)
  	fputc('E',fp);
  	fputc('L',fp);
  	fputc('L',fp);
  	fputc('O',fp);
  	fclose(fp);  // 종료시 항상 fclose를 사용해 파일을 닫을 것. 
  	return 0;
  }
  ```

- ```c
  #include <stdio.h>
  // 읽기
  int main(void){
  	FILE *fp = NULL;
  	int c;
  	
  	fp = fopen("output.txt","r");
  	
  	if(fp == NULL){
  		printf("파일 열기에 실패했습니다.\n");
  	}else{
  		printf("파일 열기에 성공했습니다. \n");
  	}
  	
  	while((c = fgetc(fp)) != EOF){  // EOF : end of file 파일의 끝을 의미한다. 
  		putchar(c); // 콘솔 창에 char 출력 
  	}
  	fclose(fp);
  	return 0;
  }
  ```

- ```c
  #include <stdio.h>
  #include <string.h>
  // 검색
  int main(void){
  	FILE *fp;
  	char fname[256];
  	char buffer[256];
  	char word[256];
  	int line = 0;
  	
  	printf("파일 이름을 입력하세요. : ");
  	scanf("%s",fname);
  	
  	printf("탐색할 단어를 입력하세요. : ");
  	scanf("%s",word);
  	
  	if((fp = fopen(fname,"r")) == NULL){
  		fprintf(stderr,"파일 %s를 열 수 없습니다.\n",fname);  // fprintf : 파일 관련 에러 출력시 사용
  		// stderr : standard error
  		return 0;
  	}
  	
  	while(fgets(buffer,256,fp)){
  		line++;
  		if(strstr(buffer, word)){ // word가 해당 buffer에 담겨있으면 true 반환한다. 
  			printf("라인 %d: 단어 %s가 발견되었습니다. \n",line,word); 
  		}	
  	}
  	fclose(fp);
  	return 0;
  }
  ```

- 



## 알게된 함수

- <string.h>
  - gets();
  - strcpy();
  - strcmp();
  - strlen();
- <math.h>
  - abs();
- 입출력 관련
  - fopen(이름, w/r);
  - fputc(char);
  - EOF
  - putchar(char);
  - fprintf(stderr);
  - strstr(문장, 단어);

## 알게된 것

- array는 일종의 포인터이기 때문에 &을 넣을 필요가 없다.(String)
- double : %lf, float : %f
- struct를 struct안에 넣어 따로 관리할 수 있다.
- struct를 parameter로 넣을 수 있다.
- struct 자체는 비교연산자에 사용할 수 없다.
- list에 접근할 경우 변수가 String이어도 &를 써야한다.
- struct point list[size] 일 경우, 표현은 list[i].grade 형식이 된다.