#include<stdio.h>
#include<limits.h>

int main(){
	int x = INT_MAX;
	printf("int형의 최댓값 x는 %d입니다.\n",x);
	printf("x+1인 %d입니다.\n", x+1);
	//x+1인 -2147483648입니다. 
	//한바퀴를 건너 뛰어 최솟값으로 돌아가버림.
	// 이것이 overflow라는 개념 
}
