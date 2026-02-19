import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static int N;
    static int[][] grid;
    static boolean[][] visited;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        if(visited[N-1][N-1]){
            sb.append("HaruHaru");
        }
        else{
            sb.append("Hing");
        }
        System.out.print(sb);
    }

    static void dfs(int x, int y){
        visited[x][y] = true;

        if(grid[x][y] == -1 ){
            return;
        }

        for(int i = 0; i < 2; i++){
            int nx = x + dx[i] * grid[x][y];
            int ny = y + dy[i] * grid[x][y];

            if(0 <= nx && nx < N && 0 <= ny && ny < N){
                if(!visited[nx][ny]) {
                    dfs(nx, ny);
                }
            }
        }
    }
}