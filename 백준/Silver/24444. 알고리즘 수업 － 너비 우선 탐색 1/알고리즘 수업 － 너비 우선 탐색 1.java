import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] order;
    static int count = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        order = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 0; i < N; i++){
            Collections.sort(graph.get(i));
        }

        bfs(R);

        for(int i = 1; i <= N; i++){
            sb.append(order[i]).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;
        order[start] = count++;

        while(!queue.isEmpty()){
            int curr = queue.poll();
            order[curr] = count++;

            for(int neighbor : graph.get(curr)){
                if(!visited[neighbor]){
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
    }
}