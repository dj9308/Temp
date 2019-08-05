package example;

public class bfs1 {

	public static void main(String[] args) {
		int [] numbers = {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers,target));
	}


	    public static int solution(int[] numbers, int target) {
	        int answer = 0;
	        int num =0;
	        for(int i =0;i<numbers.length;i++) {
	        	num+=numbers[i];
	        }
	        if(num - numbers[0]*2==target) {
        		answer++;
        	}
	        
	        for(int i =1;i<=numbers.length;i++) {
	        	boolean check = false;
	        	if(i<numbers.length) {
        			check=true;
        		}
	        	if(num - repeat(i,check)*2==target) {
	        		answer++;
	        	}
	        }
	        return answer;
	}
	    public static int repeat(int n, boolean check) {
	    	if(check==true) {
	    		return repeat(n+1,check); 
	    	}else
	    		return 0;
	    	
	    }
	
}
