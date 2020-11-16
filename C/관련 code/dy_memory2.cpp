#include <stdio.h>
#include <stdlib.h>

int main(void){
	char *pc = NULL;
	int i =0;
	pc = (char *)malloc(100 * sizeof(char));
	//100개의 char를 넣을수있는 문자열 포인터 메모리 생성
	
	if(pc == NULL){
		printf("동적 메모리 할당에 실패했습니다.");
		exit(1);
	} 
	//pc가 가리키는 포인터를 1씩 증가시키며 알파벳 소문자를 삽입한다.
	for(i=0;i<26;i++){  // 총 알파벳의 갯수 : 26 
		*(pc+i) = 'a'+i; // pc(배열)의 메모리가 올라갈때마다 알파벳 생성. 
	} 
	*(pc+i)=0;  // z 바로 다음 문자에 0 삽입
	// 아스키 커ㅗ드에서 0은 NULL을 뜻한다.
	
	printf("%s\n",pc);
	// a부터 출력후 NULL값을 만날때까지 문자열 출력
	free(pc); 
	return 0;
}
