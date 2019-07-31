package algori;

import java.util.ArrayList;

public class print {
	
	class Solution {
	    public int solution(int n, int[][] edge) {
	        int answer = 0;
	        int count =0;
	        ArrayList<Integer> two = new ArrayList<Integer>();
	        for(int i=0;i<edge.length;i++) {		//첫 가지
	        	if(edge[i][1]==1) {
	        		two.add(edge[i][1]);
	        	}
	        }
	        count++;
	        if(two.size()!=0) {
		        for(int i=0;i<edge.length;i++) {   // 다음 간선
		        	for(int j=0;i<two.size();i++) { 
		        	if(edge[i][1]==two.get(j) ) {
		        		
		        	}
		        }
		        
		    }	
	        }else {
	        	answer=0;
	        }
	        return answer;
	}
	public static void main(String[] args) {


	}

}
