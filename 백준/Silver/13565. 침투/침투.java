import java.util.*;
import java.io.*;

public class Main {
    static int[][] grid;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        grid = new int[M][N];
        visited = new int[M][N];

        for(int i = 0; i < M; i++){
            String line = br.readLine();
            for(int j = 0; j < N; j++){
                grid[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for(int i = 0; i < N; i++){
            if(grid[0][i] == 0){
                dfs(0, i);
            }
        }

        for(int i = 0; i < N; i++) {
            if (visited[M - 1][i] == 1) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }

    static void dfs(int x, int y){
        visited[x][y] = 1;

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < M && ny >= 0 && ny < N){
                if(visited[nx][ny] == 0 && grid[nx][ny] == 0){
                    dfs(nx, ny);
                }
            }
        }
    }
}