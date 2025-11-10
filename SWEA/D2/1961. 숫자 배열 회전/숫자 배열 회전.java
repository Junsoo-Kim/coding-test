import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            sb.setLength(0);
            sb.append("#" + t + "\n");
            int N = Integer.parseInt(br.readLine());
            int[][][] result = new int [4][N][N];
            
            // result[0]은 입력값
            for(int i = 0; i < N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
             	for(int j = 0; j < N; j++){
                	result[0][i][j] = Integer.parseInt(st.nextToken());   
                }
            }
            
            // 가로 줄을 돌면서 열은 고정시키고 행은 y가 x로 바뀜
            for(int i = 1; i < 4; i++){ // 페이지
             	for(int j = 0; j < N; j++){ // 행
                	for(int k = 0; k < N; k++){ // 열
                        result[i][k][N-1-j] = result[i-1][j][k];
                    }
                }
            }
            
        	// 1페이지 1행 -> 2페이지 1행 -> 3페이지 1행 -> 1페이지 2행 ...
            for(int i = 0; i < N; i++){ // 행
             	for(int j = 1; j < 4; j++){ // 페이지
                 	for(int k = 0; k < N; k++){ // 열
                    	sb.append(result[j][i][k]);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
            
            System.out.print(sb);
        }
    }
}