# include <stdio.h>

int main(void){
//	윤년 :  4년마다, 그렇지만 100년 단위일 때 윤년에 해당되지 않도록
//  400년 단위일 때는 어떤 상황이던 윤년 적용
	int year = 2016;
	if(year %4 ==0 && year %100 !=0 || year % 400 == 0) {
		printf("%d년은 윤년입니다.", year);	
	}else{
		printf("%d년은 윤년이 아닙니다.", year);
	}
}
