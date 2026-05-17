import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            pq.offer(work);
        }
        
        for(int i = 0; i < n; i++){
            int max = pq.poll();
            if(max > 0){
                pq.offer(max - 1);
            }
            else{
               pq.offer(0); 
            }
        }
        
        while(!pq.isEmpty()){
            answer += Math.pow(pq.poll(), 2);
        }
        
        return answer;
    }
}