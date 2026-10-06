import java.io.*;
import java.util.*;

public class Solution {
	static int V;
	static long result;
	static List<Edge> edges;
	static int[] parent;
	
	static class Edge implements Comparable<Edge>{
		int u;
		int v;
		int cost;
		
		Edge(int u, int v, int cost){
			this.u = u;
			this.v = v;
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
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			edges = new ArrayList<>();
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine().trim());
				int u = Integer.parseInt(st.nextToken());
				int v = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				edges.add(new Edge(u, v, cost));
			}
			
			kruskal();
			
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void makeSet() {
		parent = new int[V + 1];
		for(int i = 1; i <= V; i++) parent[i] = i;
	}
	
	private static int find(int x) {
		if(x == parent[x]) return x;
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int u, int v) {
		int rootU = find(u);
		int rootV = find(v);
		
		if(rootU != rootV) {
			parent[rootU] = rootV;
		}
	}
	
	private static void kruskal() {
		makeSet();
		Collections.sort(edges);
		
		result = 0;
		int visitedCnt = 0;
		
		for(Edge e : edges) {
			if(find(e.u) != find(e.v)) {
				union(e.u, e.v);
				visitedCnt++;
				result += e.cost;
				
				if(visitedCnt == V - 1) break;
			}
		}
	}
}