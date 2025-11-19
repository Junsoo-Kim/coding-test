import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] farm = new int[N][N];
			int sum = 0;
			int cnt;

			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = (int) row.charAt(j) - '0';
				}
			}

			// 위쪽 절반 계산
			cnt = 1;
			for (int i = N / 2 - 1; i >= 0; i--) {
				for (int j = 0 + cnt; j < N - cnt; j++) {
					sum += farm[i][j];
				}
				cnt++;
			}

			// 아래쪽 절반 계산
			cnt = 1;
			for (int i = N / 2 + 1; i < N; i++) {
				for (int j = 0 + cnt; j < N - cnt; j++) {
					sum += farm[i][j];
				}
				cnt++;
			}

			// 중간 행 계산
			for (int i = 0; i < N; i++) {
				sum += farm[N / 2][i];
			}

			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.print(sb);
	}
}