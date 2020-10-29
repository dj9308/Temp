import java.util.*;
// 문제를 풀기전 hash에 관련된 정보 및 


class Solution {
    public int[] solution(String[] genres, int[] plays) {

        //고유번호 = key값 / 장르 
    	//플레이횟수 = value값
        HashMap<Integer, Integer> pMap = new HashMap<Integer, Integer>();
        HashMap<Integer, String> gMap = new HashMap<Integer, String>();
        for(int i = 0; i < genres.length; i++){
            pMap.put(i, plays[i]);
            gMap.put(i, genres[i]);
        }

        //HashSet으로 장르 분류
        HashSet<String> gSet = new HashSet<String>();

        for(int i = 0; i < genres.length; i++){
            gSet.add(genres[i]);
        }

        //장르별 총 플레이 더한 것
        HashMap<Integer, String> coPlay = new HashMap<Integer, String>();
        for(String x : gSet){
            int count = 0;
            for(int i = 0; i < gMap.size(); i++){
                if(gMap.get(i).equals(x)){
                    count+= pMap.get(i);
                }
            }
            coPlay.put(count, x);
        }

        //Treemap을 이용한 장르분류 플레이 횟수별 정렬하기
        //treemap은 아무렇게나 key값을 넣어도 출력하는 것은 key값 순서대로 출력되기 때문에 Treemap을 선택함
        TreeMap sort = new TreeMap(coPlay);
        String[] sortGenre = new String[gSet.size()];
        int index = 0;
        
        //여기서 오류가 뜨길래 생각해본 결과 treemap은 기본적으로 object이기 때문에 toString으로 형변환해줘야함
        for(Object o : sort.keySet()){
            sortGenre[index] = sort.get(o).toString();
            index++;
        }

        //장르별 많이 플레이 된 노래의 고유번호 찾기
        ArrayList<Integer> burnho = new ArrayList<Integer>();
        for(int i = sortGenre.length-1; i >= 0; i--){
            int count = 0;
            
            // keyset = key값을 다 가져옴
            for(int p1 : gMap.keySet()){
                if(sortGenre[i].equals(gMap.get(p1))){
                    count++;
                }
            }

            int[] temp = new int[count];
            int k = 0;
            for(int p2 : gMap.keySet()){
                if(sortGenre[i].equals(gMap.get(p2))){
                    temp[k] = pMap.get(p2);
                    k++;
                }
            }

                Arrays.sort(temp);

                for(int j = temp.length - 1; j >= temp.length - 2; j--){
                    for(int p : pMap.keySet()){
                        if(temp[j] == pMap.get(p)){
                            burnho.add(p);
                            pMap.put(p, 0);
                            break;
                        }
                    }
                                
            }

        }

        int[] answer = new int[burnho.size()];

        for(int i = 0; i < burnho.size(); i++){
            answer[i] = burnho.get(i);
        }

        return answer;
    }
}