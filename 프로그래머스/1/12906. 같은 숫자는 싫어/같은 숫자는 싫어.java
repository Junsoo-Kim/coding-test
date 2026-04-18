import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(-1);
        
        for(int i = 0; i < arr.length; i++){
            if(dq.peekLast() != arr[i]){
                dq.addLast(arr[i]);
            }
        }
        dq.pollFirst(); // -1 제거
        
        int[] answer = new int[dq.size()];
        int len = dq.size();
        
        for(int i = 0; i < len; i++){
            answer[i] = dq.pollFirst();
        }
        
        return answer;
    }
}