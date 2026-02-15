import java.util.*;
import java.io.*;

public class Main {
    static int[] d = {-1, 1};
    static char[][] floor;
    static int[][] visited;
    static int count = 0;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        floor = new char[N][M];
        visited = new int[N][M];

        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < M; j++){
                floor[i][j] = row.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.print(count);
    }

    static void dfs(int x, int y){
        visited[x][y] = 1;

        if(floor[x][y] == '|'){
            for(int i = 0; i < 2; i++){
                int nx = x + d[i];
                if(0 <= nx && nx < N){
                    if(visited[nx][y] == 0 && floor[nx][y] == '|'){
                        dfs(nx, y);
                    }
                }
            }
        }

        if(floor[x][y] == '-'){
            for(int i = 0; i < 2; i++){
                int ny = y + d[i];
                if(0 <= ny && ny < M){
                    if(visited[x][ny] == 0 && floor[x][ny] == '-'){
                        dfs(x, ny);
                    }
                }
            }
        }
    }
}
