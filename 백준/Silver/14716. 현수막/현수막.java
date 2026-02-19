import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[][] grid;
    static boolean[][] visited;
    static int M;
    static int N;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i = 0; i < 8; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 <= nx && nx < M && 0 <= ny && ny < N){
                if(!visited[nx][ny] && grid[nx][ny] == 1){
                    dfs(nx, ny);
                }
            }
        }

    }
}