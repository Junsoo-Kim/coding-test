import java.util.*;
import java.io.*;

public class Main {
    static List<List<Integer>> adj;
    static int[] visited;
    static int[] parent;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        adj = new ArrayList<>();
        visited = new int[N+1];
        parent = new int[N+1];

        for(int i = 0; i <= N; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        dfs(1);

        for(int i = 2; i < N + 1; i++){
            sb.append(parent[i]).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int curr){
        visited[curr] = 1;

        for(int next : adj.get(curr)){
            if(visited[next] == 0){
                dfs(next);
                parent[next] = curr;
            }
        }
    }
}