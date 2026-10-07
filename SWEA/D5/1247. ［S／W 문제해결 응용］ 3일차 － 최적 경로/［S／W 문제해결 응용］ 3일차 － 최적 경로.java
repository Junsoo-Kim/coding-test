import java.io.*;
import java.util.*;

public class Solution {
	static List<Edge>[] graph;
	static List<int[]> nodes;
	static int result;
	static int N;
	static boolean[] visited;
	
	static class Edge implements Comparable<Edge>{
		int target;
		int cost;
		
		Edge(int target, int cost){
			this.target = target;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= T; t++) {
			result = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine().trim());

			nodes = new ArrayList<>();
			visited = new boolean[N + 2];
			graph = new List[N + 2];
			for(int i = 0; i < N + 2; i++) {
				graph[i] = new ArrayList<>();
			}
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N + 2; i++) {
				nodes.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
			}
			
			for(int i = 0; i < N + 2; i++) {
				for(int j = i + 1; j < N + 2; j++) {					
					int cost = Math.abs(nodes.get(i)[0] - nodes.get(j)[0]) + Math.abs(nodes.get(i)[1] - nodes.get(j)[1]);
					graph[i].add(new Edge(j, cost));
					graph[j].add(new Edge(i, cost));
				}
			}
			
			visited[0] = true;
			dfs(1, 0, 0);
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void dfs(int depth, int curr, int cost) {		
		if(depth == N + 2 && curr == 1) {
			if(result > cost) result = cost;
			return;
		}
		
		// 가지치기
		if(cost >= result) return;
		
		for(Edge e : graph[curr]) {
			if(visited[e.target]) continue;
			
			visited[e.target] = true;
			
			dfs(depth + 1, e.target, cost + e.cost);
			
			visited[e.target] = false;
		}
	}
}