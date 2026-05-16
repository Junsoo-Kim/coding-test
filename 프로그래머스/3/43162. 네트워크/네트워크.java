import java.util.*;

class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        int cnt = 0;
        
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < computers.length; i++){
            for(int j = 0; j < computers[0].length; j++){
                if(computers[i][j] == 1 && i != j){
                    graph[i].add(j);
                }
            }
        }
        
        for(int i = 0; i < computers.length; i++){
            if(!visited[i]){
                bfs(i);
                cnt++;
            }
        }
        
        return cnt;
    }
    
    private void bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            for(int next : graph[curr]){
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}