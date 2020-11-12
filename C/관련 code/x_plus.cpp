#include <stdio.h>

int main(void){
	int x = 50, y = 30;
	printf("x가 y보다크고 y는 40 미만입니까? %d\n", (x>y) && (y<40) );
	printf("x가 y보다 작거나 호은 y가 30입니까? %d\n", (x<y) || (y==30));
	printf("x가 50이 아닙니까? %d", x!=50);
	return 0;
}

// 1 / 1 / 0  : 참은 1, 거짓은 0으로 반환된다. 
