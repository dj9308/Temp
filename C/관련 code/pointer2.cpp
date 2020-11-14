#include <stdio.h>

int main(void){
	int i =10;
	int *p;
	p = &i;  // 포인터 p가 가리키는것이 i가 됨.
	// i==p  ->1
	printf("*i= %d\n", *p);
	*p = 20; // 포인터 값과 해당 변수의 값은 같은건 같다. 
	printf("*i= %d\n", p);
	return 0;
}
