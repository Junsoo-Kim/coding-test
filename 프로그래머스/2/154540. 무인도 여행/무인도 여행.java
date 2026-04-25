import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int[][] grid;
    
    public int[] solution(String[] maps) {
        visited = new boolean[maps.length][maps[0].length()];
        grid = new int[maps.length][maps[0].length()];
        List<Integer> resultList = new ArrayList<>();
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(maps[i].charAt(j) != 'X'){
                    grid[i][j] = Integer.valueOf(maps[i].charAt(j) - '0');
                }
                else{
                    grid[i][j] = 0;
                }
            }
        }
        
        for(int i = 0; i < maps.length; i++){
            for(int j = 0; j < maps[0].length(); j++){
                if(visited[i][j] == false && grid[i][j] != 0){
                    resultList.add(bfs(i, j));
                }
            }
        }
        
        if(resultList.size() == 0){
            return new int[]{-1};
        }
        
        int[] answer = new int[resultList.size()];
        Collections.sort(resultList);
        
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int x, int y){
        Queue<int[]> queue = new ArrayDeque<>();
        int result = 0;
        
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        result += grid[x][y];
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if(nx < 0 || grid.length <= nx || ny < 0 || grid[0].length <= ny){
                    continue;
                }
                
                if(visited[nx][ny] == false && grid[nx][ny] != 0){
                    visited[nx][ny] = true;
                    result += grid[nx][ny];
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        
        return result;
    }
}