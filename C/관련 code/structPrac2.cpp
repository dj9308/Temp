#include <stdio.h>
#include <math.h>

struct point{
	int x;
	int y;
};

void comparePoint(struct point p1, struct point p2){
	if(p1.x==p2.x && p1.y==p2.y) {
		printf("p1, p2는 같다");
	}
} // 따로 struct 관련 함수로 만들어서 관리가 가능하다. 
// 함수를 따로 놓을 경우 훨씬 더 체계적으로 구조가 이루어질 수 있다. 

int main(void){
	struct point p1, p2;
	
	p1.x = 30;
	p1.y = 10;
	
	p2.x = 30;
	p2.y = 10;
	
	comparePoint(p1,p2);
	
//	if(p1==p2){ 오류 발생 : struct는 타입이 같아도 직접 비교 불가 
// 		
//	} // 구조체 자체는 서로 비교를 못한다. 
	return 0;
}
