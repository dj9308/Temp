import java.util.ArrayList;

// 굳이 식을 먼저 생각할 필요 없다.
// 효율성에서 막힘

class Solution {
    public long solution(int N) {
    	ArrayList<Integer> ary = new ArrayList<Integer>();
    	int x;
        int y;
        
        ary.add(1);	// N=1
        ary.add(1);	// N=2
        
        if(N==1) {
        	x=1; y=1;
        }else if(N==2) {
        	x=ary.get(0); y=ary.get(1);
        }
        
        for(int i=2;i<N;i++) {
        	ary.add(ary.get(i-2)+ary.get(i-1));
        }//N=3 부터
        x = ary.get(N-1)+ary.get(N-2);
        y = ary.get(N-1);
    	long answer = 2*x+2*y;
        return answer;
    }
}