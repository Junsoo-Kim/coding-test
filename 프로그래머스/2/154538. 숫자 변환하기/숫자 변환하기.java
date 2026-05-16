import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if(x == y){
            return 0;
        }
        
        int answer = -1;
        boolean[] visited = new boolean[1000001];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x * 2, 1});
        queue.offer(new int[]{x * 3, 1});
        queue.offer(new int[]{x + n, 1});
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int num = curr[0];
            int depth = curr[1];
            
            if(num > y){
                continue;
            }
            if(num == y){
                answer = depth;
                break;
            }
            
            if(!visited[num]){
                visited[num] = true;
                queue.offer(new int[]{num * 2, depth + 1});
                queue.offer(new int[]{num * 3, depth + 1});
                queue.offer(new int[]{num + n, depth + 1});
            }            
        }
        
        return answer;
    }
}