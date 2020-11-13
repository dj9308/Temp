#include <stdio.h>

// 반복함수를 잉요해서 숫자 피라미드를 출력한다.

int print(int a){
	int i,j;
	for(int i=0;i<a;i++){
		for(int j=0;j<=i;j++){
			printf("%d ", j+1);
		}
		printf("\n");
	}
}

int main(void){
	int a;
	scanf("%d",&a);
	print(a);
	return 0;
} 
