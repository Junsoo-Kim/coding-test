import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int start = 0;
        
        while(progresses.length > start){
            int cnt = 0;
            
            for(int i = 0; i < progresses.length; i++){
                progresses[i] += speeds[i];
            }
            
            for(int i = start; i < progresses.length; i++){
                if(progresses[i] >= 100){
                    cnt++;
                }
                else{
                    break;
                }
            }
            
            if(cnt != 0){
                result.add(cnt);
                start += cnt;
            }
        }
        
        int[] answer = new int[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}