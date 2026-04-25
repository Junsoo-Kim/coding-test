import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.add(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            if(x == maps.length - 1 && y == maps[0].length - 1){
                return maps[x][y];
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || maps.length <= nx || ny < 0 || maps[0].length <= ny){
                    continue;
                }
                
                if(maps[nx][ny] != 0 && visited[nx][ny] == false){
                    queue.add(new int[]{nx, ny});
                    maps[nx][ny] = maps[x][y] + 1;
                    visited[nx][ny] = true;
                }
            }
        }
           
        return -1;
    }
}