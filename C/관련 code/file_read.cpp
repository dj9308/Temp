#include <stdio.h>

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
