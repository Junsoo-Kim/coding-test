import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String arg[]) throws Exception{
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int max = -1;
            int[][] flyList = new int[N][N];
            for (int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
             	for(int j = 0; j < N; j++){
                 	   flyList[i][j] = Integer.parseInt(st.nextToken());
                }
            }
                    
            // 파리채 M x M이 들어갈 수 있는 모든 좌표 순회
            for (int i = 0; i < N - M + 1; i++){
             	for(int j = 0; j < N - M + 1; j++){
                 	// 파리채 안에 잡힌 파리 수 합 구하기
                    int sum = 0;
                    for(int k = 0; k < M; k++){
                        for(int l = 0; l < M; l++){
                            sum += flyList[i + k][l + j];
                        }
                    }
                    max = (max < sum) ? sum : max;
                }
            }
            System.out.println("#" + t + " " + max);
        }
        br.close();
    }
}