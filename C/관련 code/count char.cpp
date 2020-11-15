#include <stdio.h>

int main(void){
	char input[1001];
	gets(input); // input이라는 char 배열안에 사용자가 입력하는 문자열이 enter가 칠때 들어가는 것 
	int count = 0;
	while(input[count]!='\0'){ // null
		count++;
	}
	printf("%d\n",count);
	printf("%s",input);
	return 0;
}
