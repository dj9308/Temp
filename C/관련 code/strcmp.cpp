#include <stdio.h>
#include <string.h>

int main(void){
	char inputOne[5] = "B";
	char inputTwo[5] = "B";
	
	printf("문자열 비교 : %d\n", strcmp(inputOne,inputTwo));
	// 사전적으로 동일시 0, one이 앞에있을시 -1, Two가 앞에 있을시 1이 반환된다.
	// 사전구현, 영단어 암기장 구현시 많이 사용됨. 
	return 0;
}

