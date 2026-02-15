import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> adj;
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        visited = new int[N+1];

        for(int i = 0; i <= N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 1; i <= N; i++){
            Collections.sort(adj.get(i));
        }

        dfs(R);

        for(int i = 1; i <= N; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int now){
        visited[now] = count++;

        for(int next : adj.get(now)){
            if(visited[next] == 0){
                dfs(next);
            }
        }
    }
}
