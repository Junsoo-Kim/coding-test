import java.util.*;
import java.io.*;

public class Main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int M, N;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        grid = new int[M][N];
        visited = new boolean[M][N];
        ArrayList<Integer> result = new ArrayList<>();

        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1; j < x2; j++){
                for(int k = y1; k < y2; k++){
                    visited[k][j] = true;
                }
            }
        }

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    result.add(bfs(new int[]{i, j}));
                }
            }
        }

        sb.append(result.size()).append("\n");
        Collections.sort(result);
        
        for(int num : result){
            sb.append(num).append(" ");
        }
        System.out.print(sb);
    }

    static int bfs(int[] start){
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(start);
        int count = 1;
        visited[start[0]][start[1]] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int x = curr[1];
            int y = curr[0];

            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(0 <= nx && nx < N && 0 <= ny && ny < M){
                    if(!visited[ny][nx]){
                        count++;
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        return count;
    }
}