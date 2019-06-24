package practice1;
import java.util.*;

// 느낀점 및 알게된 점 : 

// 공책에 순서 설정 및 도식화 후 코딩 작성하니 비교적 난이도와 시간소요가 내려감.

// copyOfRange 메소드를 알게되니 코드가 더 간단해짐

// 앞으로도 유용한 메소드를 기억하고 적절히 활용하면 쉽게 코딩할 수 있을거라 예상	(구조를 정확히 아는 전제 하)



class Solution {
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int index = 0 ;

        for(int a = 0 ; a < commands.length ; a++)
        {
            int i = commands[a][0];
            int j = commands[a][1];
            int k = commands[a][2];

            // i j k 을 행렬에 넣기

            int[] ary = new int[j - i + 1];
            
            

            int b = 0;
            for(int v = i - 1 ; v < j ; v++)
            	ary[b++] = array[v];

         // i부터 j 까지 자른 숫자들을 새로운 행렬에 넣음
            
            Arrays.sort(ary);
            answer[index++] = ary[k-1];
           
         // sort로 정렬 후 k번 째 있는 수를 answer 행렬에 넣기
            // k - 1 은 행렬이 0으로 시작되기 때문에.
        }


        return answer;
    }
}




//Arrays.copyOfRange(원본 배열, 복사할 시작인덱스, 복사할 끝인덱스) 사용하면?



/*
 * 
 * import java.util.Arrays;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] ary = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            
            // -1 하는 이유 : 행렬이 0부터 시작해서
            // 3번째 아규먼트에 -1을 안하는 이유 :  전달된 인덱스 바로 전까지의 배열 요소까지만 복사되어서.
            
            Arrays.sort(ary);
            answer[i] = ary[commands[i][2]-1];
        }

        return answer;
    }
}
 * */

