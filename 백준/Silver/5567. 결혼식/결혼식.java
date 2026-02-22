import java.util.*;
import java.io.*;

public class Main{
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int result = -1;
        visited = new int[n + 1];
        graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        for(int i = 1; i <= n; i++){
            if(visited[i] == 1){result++;}
        }

        System.out.print(result);
    }

    static void bfs(int start){
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited[start] = 1;
        queue.offer(start);

        int curr = queue.poll();

        for(int next : graph.get(curr)){
            if(visited[next] == 0){
                visited[next] = 1;
                queue.offer(next);
            }
        }

        int friendNum = queue.size();

        for(int i = 0; i < friendNum; i++){
            curr = queue.poll();

            for(int next : graph.get(curr)){
                if(visited[next] == 0){
                    visited[next] = 1;
                }
            }
        }
    }
}