import java.io.*;
import java.util.*;

public class Main{
    static List<List<Integer>> arr;
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>();
        visited = new int[N + 1];

        for(int i = 0; i < N + 1; i++){
            arr.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            arr.get(u).add(v);
            arr.get(v).add(u);
        }

        for(int i = 0; i < N + 1; i++){
            Collections.sort(arr.get(i), Collections.reverseOrder());
        }

        dfs(R);

        for(int i = 1; i < N + 1; i++){
            sb.append(visited[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int curr){
        visited[curr] = count++;

        for(int next : arr.get(curr)){
            if(visited[next] == 0){
                dfs(next);
            }
        }
    }
}