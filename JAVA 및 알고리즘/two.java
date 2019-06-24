
package practice;
// 주의 : 알코올이 첨가된 답안지이니 상세한 이유는 묻지 마시오.

// 재귀함수의 정의와 용도를 제대로 알고 문제를 푸니 비교적 수월하게 문제를  풀 수 있었던 것 같다.
// 알 것 같은 것 : 재귀함수의 내용물 전체가 불러온 함수 전체에 붙여진다.
// 





class network {

    public int solution(int n, int[][] computers) {

        int answer = 0;

        for(int i=0;i<n;i++){
                repeat(computers,i);
                answer++;
        }


        return answer;
    }

    private static void repeat(int[][] computers, int i) {


        for(int j=0;j<computers.length;j++){
            if(computers[i][j]==1 && i!=j){
                repeat(computers,j);
            }
        }
    }
}

