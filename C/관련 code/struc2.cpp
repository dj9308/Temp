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
	printf("학번을 입력하세요! ");
	scanf("%d",&s.number);
	printf("이름을 입력하세요! ");
	scanf("%s",s.name);  // array의 경우 그 자체로 pointer이기 때문에 &을 넣을 필요가 없다. 
	printf("학점을 입력하세요! ");
	scanf("%lf",&s.grade); // double의 경우 lf로 해주면된다.
	//float의 경우 f. 
	
	printf("학번 : %d\n",s.number);
	printf("이름 : %s\n",s.name);
	printf("학점 : %0.1f\n",s.grade);
	return 0;
}
