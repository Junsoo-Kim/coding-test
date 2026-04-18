import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++){
            pq.offer(Long.valueOf(scoville[i]));
        }
        
        while(true){
            if(pq.size() == 0){
                answer = -1;
                break;
            }
            long first = pq.poll();
            
            if(first >= Long.valueOf(K)){
                break;
            }
            
            if(pq.size() == 0){
                answer = -1;
                break;
            }
            long second = pq.poll();
            
            pq.offer(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}