import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int dest;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dest = destination;
        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] road : roads){
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        
        for(int i = 0; i < sources.length; i++){
            visited = new int[n + 1];
            answer[i] = bfs(sources[i]);
        }
        
        return answer;
    }
    
    private int bfs(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = 1;
        
        while(!queue.isEmpty()){
            int curr = queue.poll();
            
            if(curr == dest){
                return visited[dest] - 1;
            }
            
            for(int next : graph[curr]){
                if(visited[next] == 0){
                    queue.offer(next);
                    visited[next] = visited[curr] + 1;
                }   
            }
        }
        
        return -1;
    }
}