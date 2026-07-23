import java.io.*;
import java.util.*;

public class J1072S5{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		List<Integer> nums = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		// 누적합 배열 (0 ~ i - 1)
		List<Integer> prefixSum = new ArrayList<>();
		prefixSum.add(0);
		
		for(int i = 1; i <= n; i++) {
			prefixSum.add(prefixSum.get(i - 1) + nums.get(i - 1));
		}
		
		// 구간 합 계산
		int result = Integer.MIN_VALUE;
		for(int i = 0; i <= n - m; i++) {
			result = Math.max(result, prefixSum.get(i + m) - prefixSum.get(i));
		}
		
		sb.append(result);
		
		System.out.print(sb);
	}
}
