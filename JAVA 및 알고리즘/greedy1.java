package algori;

//

//처음엔 런타임 에러가 많이 남.
//예전 타일 문제(피보나치 수열) 문제를 풀었을 때 같은 문제가 발생했던 것을 기억하여
//ArrayList가 문제가 된다는 것을 알아냄.
//ArrayList를 없애고 다시 고쳐서 돌린 결과 통과.

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lost1 = 0;
        int count = 0;
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]) {
                    lost1++;
                    lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }
        
        for(int i=0; i<lost.length; i++) {
            for(int j=0; j<reserve.length; j++) {
                if(lost[i]==reserve[j]+1 || lost[i]==reserve[j]-1) {
                    count++;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        answer = n - lost.length + lost1 + count;
        
        return answer;
    }
}
