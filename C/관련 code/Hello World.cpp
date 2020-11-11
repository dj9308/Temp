#include <stdio.h>

int main(void)
{
	int x = 50;
    float y = 123456789.12345678;
	// float = 4byte까지만 출력 가능함
	double z = 123456789.12345678;
	// double = 8byte 
    printf("x = %d\n", x); // %d : int형 출력
	printf("y=%.2f\n", y) ; // 소수 둘때자리 실수 출력 \n : 줄바꿈  
}
