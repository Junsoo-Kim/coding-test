import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        while(true){
            int cnt = 0;
            for(int i = 0; i < citations.length; i++){
                if(citations[i] >= answer){cnt++;}
            }
            
            if(cnt >= answer){
                answer++;
            }
            else{
                answer--;
                break;
            }
        }
        
        return answer;
    }
}