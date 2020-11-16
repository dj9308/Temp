#include <stdio.h>

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
