package practice;

import java.util.*;

package practice;

import java.util.*;


class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        int ary[]= new int[numbers.length];
        for(int i =0;i<numbers.length;i++) {
        	if(numbers[i]/1000!=0) {
        		ary[i]=	numbers[i]/1000;
        	}else {
        	if(numbers[i]/100!=0) {
        		ary[i]=	numbers[i]/100;
        	}else {
        		if(numbers[i]/10!=0) {
        			ary[i]=	numbers[i]/10;
        		}else {
        			ary[i]=numbers[i];
        		}
        	}
        	}
        	Arrays.sort(ary, );
        	for(i=0;i<numbers.length;i++) {
        		for(int j =1;j<ary.length;j++) {
                	if(numbers[i]<numbers[j])
            	}	
        	}
        	
        }
        return answer;
    }
}

/*
class Solution1 {
    public String solution(int[] numbers) {
    	        String answer = "";
    	        
    	        //int 배열을 String 배열로 변환
    	        String[] arr = new String[numbers.length];
    	        for (int i = 0; i < numbers.length; i++) {
    	            arr[i] = (String.valueOf(numbers[i]));
    	        }
    	        Arrays.sort(arr,new cmp());
    	        for(int j =0;j<arr.length;j++) {
    	        	answer += arr[j];
    	        }
    	        return answer;
    }
}
class cmp implements Comparator<String>{
	public int compare(String a, String b){
		return (b+a).compareTo(a+b);
	}
}
public class exam2 {

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		int numbers[] = {3, 0, 6, 1, 5};
		System.out.println(sol.solution(numbers));
	}

}
*/