import java.io.*;
import java.util.*;

public class Solution {
	static int N;
	static List<Edge>[] graph;
	static double tax;
	static double result;
	
	static class Edge implements Comparable<Edge>{
		int target;
		double cost;
		
		Edge(int target, double cost){
			this.target = target;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Edge e) {
			return Double.compare(this.cost, e.cost);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			result = 0;
			
			int[][] islands = new int[N][2];
			String[] xpos = br.readLine().trim().split(" ");
			String[] ypos = br.readLine().trim().split(" ");
			for(int i = 0; i < N; i++) {
				islands[i][0] = Integer.parseInt(xpos[i]);
				islands[i][1] = Integer.parseInt(ypos[i]);
			}
			
			tax = Double.parseDouble(br.readLine().trim());
			
			graph = new List[N];
			for(int i = 0; i < N; i++) {
				graph[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					double length = Math.pow(islands[i][0] - islands[j][0], 2);
					length += Math.pow(islands[i][1] - islands[j][1], 2);
					length *= tax;
					
					graph[i].add(new Edge(j, length));
					graph[j].add(new Edge(i, length));
				}
			}
			
			prim(0);
			
			sb.append("#").append(t).append(" ").append(Math.round(result)).append("\n");
		}
		System.out.print(sb);
	}
	
	private static void prim(int start) {
		boolean[] visited = new boolean[N + 1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		result = 0;
		int visitedCnt = 0;
		
		pq.offer(new Edge(start, 0));
		
		while(!pq.isEmpty()) {
			Edge curr = pq.poll();
			
			if(visited[curr.target]) continue;
			
			visited[curr.target] = true;
			result += curr.cost;
			visitedCnt++;
			
			if(visitedCnt == N) break;
			
			for(Edge next : graph[curr.target]) {
				if(!visited[next.target]) pq.offer(next);
			}
		}
	}
}