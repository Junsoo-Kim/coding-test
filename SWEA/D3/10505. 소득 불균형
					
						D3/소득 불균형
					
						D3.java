import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> moneys = new ArrayList<>();
			double average = 0;
			
			for(int i = 0; i < N; i++) {
				moneys.add(Integer.parseInt(st.nextToken()));
				average += moneys.get(i);
			}
			Collections.sort(moneys);
			average /= N;
			
			int start = 0;
			int end = moneys.size() - 1;
			int result = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(moneys.get(mid) <= average) {
					result = Math.max(mid + 1, result);
					start = mid + 1;
				}
				else {
					end = mid - 1;
				}
			}
			
			sb.append("#" + t + " " + (result) + "\n");
		}
		System.out.print(sb);
		return;
	}
}
