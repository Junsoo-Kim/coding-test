import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N;
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
        	sb.setLength(0);
            sb.append("#" + t + "\n");
            N = Integer.parseInt(br.readLine());
            
            int[][] dp = new int[N][N+2];
            dp[0][1] = 1;
            
            for(int i = 1; i < N; i++){
             	for(int j = 1; j < i+2; j++){
                    // 각 행의 좌우측 끝에 0이 있다고 생각하고 더함
                    // new int[][]는 생성 시 배열 내 모든 값이 0으로 초기화
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
            
            for(int i = 0; i < N; i++){
             	for(int j = 1; j < i+2; j++){
                 	if(dp[i][j] == 0){
                     	break;   
                    }
                    sb.append(dp[i][j] + " ");
                }
                sb.append("\n");
            }
            
            System.out.print(sb);
        }
    }
}