#include <stdio.h>
#include <string.h>

int main(void){
	char input[11]="I Love You";
	char result[5]="Love";
	strcpy(result,input); // result 문자 안에 input 카피 가능
	// strcpy string pointer 조작 관련 함수 
	printf("문자열 복사 : %s\n",result);
	return 0; 
}
