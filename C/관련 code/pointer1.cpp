#include <stdio.h>

// 두 변수의 값을 바꾸는 함수 
void swap(int *x, int *y){
	int temp= *x;  // x가 가리키는 주소의 값 
	
	*x = *y;
	*y = temp;
}
// * 을 안쓸경우 x,y는 swap함수에만 적용되고 main 함수에는 적용이 안된다. 메모리에 저장이 안되기 때문이다. 
// 포인터를 이용하면 프로그램 전역에서 언제 어디서나 값을 바꾸며 프로그래밍 기법, 해킹까지 할 수 있다. 

int main(void){
	int x = 1;
	int y = 2;
	swap(&x, &y);
	printf("x=%d, y=%d\n",x,y);
	return 0;
}
