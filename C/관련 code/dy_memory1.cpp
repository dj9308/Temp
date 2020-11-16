#include <stdio.h>
#include <stdlib.h>  // 동적 메모리 사용 관련 라이브러리

int main(void){
	int *pi; // Pointer Integer
	pi = (int *)malloc(sizeof(int)); // malloc : 메모리를 할당하라.
	// malloc(sizeof(int)) : int형의 크기만큼 메모리를 할당하라. 
	// (int *) 포인터로 형변환
	if(pi ==NULL){
		printf("동적 메모리 할당에 실패했습니다.\n");
		exit(1); // 프로그램 종료 
	} 
	
	*pi = 100;
	printf("%d\n", *pi);
	// 동적 메모리 사용 이후에 무조건 메모리를 반환한다.
	free(pi); 
	return 0;
} 

