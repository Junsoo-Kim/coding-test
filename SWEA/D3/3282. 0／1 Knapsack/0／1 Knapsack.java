import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // dp[i] = 부피 합이 K 이하일 때 얻을 수 있는 최대 가치
            int[] dp = new int[K + 1];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int v = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                for (int k = K; k >= v; k--) {
                    dp[k] = Math.max(dp[k], dp[k - v] + c);
                }
            }

            sb.append("#").append(tc).append(" ").append(dp[K]).append("\n");
        }
        System.out.print(sb);
    }
}