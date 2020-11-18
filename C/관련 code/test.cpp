#include <stdio.h>
#include <stdlib.h>

int main(void){
	int i, x,y;
	int **pptr = (int**)malloc(8*sizeof(int*));
	
	for(i=0;i<8;i++){
		*(pptr+i) = (int*)malloc(6*sizeof(int));
		for(x = 0;x<6;x++){
			*(*(pptr+i)+x) = 6 *i +x;
		}
	}
	
	
	for(y=0;y<8;y++){
		for(x = 0;x<6;x++){					
			printf("%3d",*(*(pptr+y)+x));
		}
		printf("\n");
	}
	
	for(y=0;y<8;y++){			// 이차원 배열마다 메모리 반환,
		free(*(pptr+y));		
	}
	
	
	
	
	return 0;
}
