import java.util.*;

class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        visited = new boolean[102][102];
        
        for (int[] rec : rectangle) {
            int x1 = rec[0] * 2;
            int y1 = rec[1] * 2;
            int x2 = rec[2] * 2;
            int y2 = rec[3] * 2;
            
            for (int i = x1; i <= x2; i++) {
                for (int j = y1; j <= y2; j++) {
                    // 사각형의 내부인 경우
                    if (i > x1 && i < x2 && j > y1 && j < y2) {
                        map[i][j] = -1; 
                    } 
                    // 테두리인 경우 (이미 다른 사각형의 내부(-1)가 아닐 때만 1로 채움)
                    else if (map[i][j] != -1) {
                        map[i][j] = 1; 
                    }
                }
            }
        }
        
        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);
    }
    
    private int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, 0});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int depth = curr[2];
            
            if (x == targetX && y == targetY) {
                return depth / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102) {
                    if (map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny, depth + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return 0;
    }
}