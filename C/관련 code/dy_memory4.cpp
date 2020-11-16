#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct Book{
	int number;
	char title[100];
};

void showBook(struct Book *p, int n){
	int i;
	for(i=0;i<n;i++){
		printf("번호 %d : %s\n", (p+i)->number,(p+i)->title);
	}
} 

int main(void){
	struct Book *p;
	p = (struct Book *)malloc(2*sizeof(struct Book)); // struct 배열 생성 
	if(p==NULL){
		printf("동적 메모리 할당에 실패했습니다.\n");
		exit(1);
	}
	
	p->number=1;  // 화살표로 해당 변수에 접근할 수 있다.
	strcpy(p->title, "C Programming");
	
	(p+1) -> number=2;  // struct Book 배열의 2번째에 삽입 
	strcpy((p+1)->title,"Data Structure"); 
	
	showBook(p,2);
	free(p);
	return 0;
}
