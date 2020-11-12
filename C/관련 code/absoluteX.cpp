#include <stdio.h>

int main(void){
	int x = 50, y = 30;
	int absoluteX = (x>0) ? x: -x;
	int max = (x>y) ? x: y;
	int min = (x>y) ? y: x;
	printf("x의 절댓값은 %d 입니다.",absoluteX);
	printf("x와 y의 최댓값 및 최솟값은 각각 %d, %d 입니다.", max,min);
	return 0;
}
