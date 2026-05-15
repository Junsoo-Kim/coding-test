import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0 ,-1, 1};
    static boolean[][] visited;
    static int[][] board;
    
    public int solution(String[] game) {
        visited = new boolean[game.length][game[0].length()];
        board = new int[game.length][game[0].length()];
        int x = -1, y = -1;
        
        for(int i = 0; i < game.length; i++){
            for(int j = 0; j < game[0].length(); j++){
                if(game[i].charAt(j) == 'D'){
                    board[i][j] = -1;
                }
                if(game[i].charAt(j) == 'G'){
                    board[i][j] = 1;
                }
                if(game[i].charAt(j) == 'R'){
                    x = i;
                    y = j;
                }
            }
        }        
        int answer = bfs(x, y);
        return answer;
    }
    
    private int bfs(int startX, int startY){
        Queue<int[]> queue = new ArrayDeque<>();
        int answer = -1;
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int cnt = current[2];
            
            if(board[x][y] == 1){
                answer = cnt;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                // nx, ny 초기화(끝까지 도달하거나 벽을 만날때까지)
                int nx = x + dx[i];
                int ny = y + dy[i];
                while(true){
                    if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length){
                        nx = nx - dx[i];
                        ny = ny - dy[i];
                        break;
                    }
                    
                    if(board[nx][ny] == -1){
                        nx = nx - dx[i];
                        ny = ny - dy[i];
                        break;
                    }
                    
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }
                
                // 인덱스 초과 예외처리
                if(nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length){
                    continue;
                }
                
                if(board[nx][ny] != -1 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, cnt + 1});
                }
            }
        }
        
        return answer;
    }
}