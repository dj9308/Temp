#include <stdio.h>
#include <string.h>

int print(int *x, int *y){
	int temp= *x;
	*x=*y;
	*y=temp;
}

int main(void){
	int x=1;
	int y=2;
	print(&x,&y);
	return 0;
}


