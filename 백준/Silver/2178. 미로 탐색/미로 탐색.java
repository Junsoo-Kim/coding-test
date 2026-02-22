import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] grid;
    static int[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            String line = br.readLine();
            for(int j = 0; j < M; j++){
                grid[i][j] = (int) line.charAt(j) - 48;
            }
        }

        bfs(new int[]{0, 0});

        System.out.print(visited[N - 1][M - 1]);
    }

    static void bfs(int[] start){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[start[0]][start[1]] = 1;
        queue.offer(start);

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(grid[nx][ny] == 1 && visited[nx][ny] == 0){
                        visited[nx][ny] = visited[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}