import java.util.ArrayList;

//arraylist MASTER BABY


class Solution {
    public int[] solution(int brown, int red) {
    	int x = 0;
		int y =0;
		ArrayList<Integer> ary = new ArrayList<Integer>();
        int[] answer = new int[2];
        
       int sum = brown+red;
       for(int i=3;i<sum;i++) {
    	   if(sum%i==0)
    		   ary.add(i);
       }
       for(int i=0;i<ary.size();i++) {
    	  x = ary.get(i);
    	  y = sum/x;
    	  System.out.print(x+","+y+" ");
    	  
    	  if(x>=3 && y >=3 && x>=y && (x-2)*(y-2)==red) {
    		  answer[0]=x;
    		  answer[1]=y;
    	  }
       }
        
        return answer;
    }
}