import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int testNum = Integer.parseInt(br.readLine());
			int[][] nums = new int[100][100];
			ArrayList<Integer> sums = new ArrayList<>();
			int sum;
			
			for(int i = 0; i < 100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					nums[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 각 행의 합
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += nums[i][j];
				}
				sums.add(sum);
			}
			
			// 각 열의 합
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += nums[j][i];
				}
				sums.add(sum);
			}
			
			// 대각선의 합
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += nums[i][i];
			}
			sums.add(sum);
			
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += nums[99 - i][i];
			}
			sums.add(sum);
			
			sb.append("#" + testNum + " " + Collections.max(sums) + "\n");
		}
		System.out.print(sb);
	}
}