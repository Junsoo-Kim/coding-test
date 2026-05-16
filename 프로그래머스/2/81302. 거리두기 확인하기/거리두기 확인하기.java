import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] board;
    static int result;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        for(int p = 0; p < 5; p++){
            System.out.println(p);
            board = new int[5][5];
            result = 1;
            
            // board 초기화
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(places[p][i].charAt(j) == 'P'){
                        board[i][j] = 2;
                    }
                    if(places[p][i].charAt(j) == 'O'){
                        board[i][j] = 1;
                    }
                    if(places[p][i].charAt(j) == 'X'){
                        board[i][j] = 0;
                    }
                }                           
            }
            
            for(int i = 0; i < 5; i++){
                for(int j = 0; j < 5; j++){
                    if(board[i][j] == 2){
                        bfs(i, j);
                    }
                }
            }
            
            answer[p] = result;
        }
        
        return answer;
    }
    
    private void bfs(int startX, int startY){
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int depth = curr[2];
            
            if(depth > 2){
                continue;
            }
            
            if(board[x][y] == 2 && depth != 0){
                result = 0;
                break;
            }
            
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5){
                    continue;
                }
                
                if(!visited[nx][ny] && board[nx][ny] != 0){
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny, depth + 1});                    
                }
            }
        }
    }
}

/*
BFS
P를 찾았으면 P로부터 depth = 2인 애까지만 넣어서 조사
X면 큐에 아예 안넣고, O면 큐에 넣고, P면 큐에 넣어서 depth <= 2면 안지킨거
이걸 모든 P에 다 해보고 안지킨 경우가 하나라도 있으면 static answer를 true로 만들어서 그 결과를 가져와서 저장하면 될듯
*/