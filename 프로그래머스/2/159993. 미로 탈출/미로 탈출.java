import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] grid;
    static String[] maps;
    
    public int solution(String[] maps_input) {
        maps = maps_input;
        grid = new int[maps.length][maps[0].length()];
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'X'){
                    grid[i][j] = -1;
                } 
            }
        }
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    bfs(i, j, 'L');
                }
            }
        }
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) == 'L' && grid[i][j] > 0){
                    return bfs(i, j, 'E');
                }
            }
        }
        
        return -1;
    }
    
    private int bfs(int x, int y, char end){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{x, y});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx < 0 || grid.length <= nx || ny < 0 || grid[0].length <= ny){
                    continue;
                }
                
                if(!visited[nx][ny] && grid[nx][ny] != -1){
                    grid[nx][ny] = grid[current[0]][current[1]] + 1;
                    queue.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    
                    if(maps[nx].charAt(ny) == end){
                        return grid[nx][ny];
                    }
                }
            }
        }
        
        return -1;
    }
}