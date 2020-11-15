#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct student{
	int number;
	char name[10];
	double grade;
};

int main(void){
	struct student s;
	s.number = 20201116;
	strcpy(s.name,"홍길동"); // 배열이기 때문에 strcpy를 사용해 안정적으로 입력 
	s.grade = 4.5;
	printf("학번 : %d\n",s.number);
	printf("이름 : %s\n",s.name);
	printf("학점 : %0.1f\n",s.grade);
	return 0;
}
