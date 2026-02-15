import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R;
    static int C;
    static char[][] backyard;
    static int[][] visited;
    static int lambs = 0;
    static int wolves = 0;
    static boolean escape = false;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int lambResult = 0;
        int wolfResult = 0;
        backyard = new char[R][C];
        visited = new int[R][C];

        for(int i = 0; i < R; i++){
            String row = br.readLine();
            for(int j = 0; j < C; j++){
                backyard[i][j] = row.charAt(j);
            }
        }

        for(int i = 0; i < R; i++){
            for (int j = 0; j < C; j++){
                if(visited[i][j] == 0 && backyard[i][j] != '#'){
                    dfs(i, j);

                    if(!escape){
                        if(lambs > wolves){
                            lambResult += lambs;
                        }
                        else {
                            wolfResult += wolves;
                        }
                    }

                    lambs = 0;
                    wolves = 0;
                    escape = false;
                }
            }
        }

        sb.append(lambResult).append(" ").append(wolfResult);
        System.out.print(sb);
    }

    static void dfs(int x, int y){
        visited[x][y] = 1;
        if(backyard[x][y] == 'o'){
            lambs++;
        }
        if(backyard[x][y] == 'v'){
            wolves++;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx == -1 || nx == R || ny == -1 || ny == C){
                escape = true;
            }

            if(0 < nx && nx < R && 0 < ny && ny < C){
                if(visited[nx][ny] == 0 && backyard[nx][ny] != '#'){
                    dfs(nx, ny);
                }
            }
        }
    }
}