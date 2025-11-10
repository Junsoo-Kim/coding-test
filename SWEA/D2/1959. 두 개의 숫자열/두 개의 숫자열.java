import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = -10001;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            
            // Ai와 Bj 선언 및 초기화
            int[] aList = new int[N];
            int[] bList = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                aList[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                bList[i] = Integer.parseInt(st.nextToken());
            }
            
            // 항상 N을 M보다 작게 해서 N과 aList를 단위로 사용
           	if(N > M){
            	int temp = N;
                N = M;
                M = temp;
                
                int[] tempList = aList;
                aList = bList;
                bList = tempList;
            }
            
            // aList를 단위로 해서 bList를 한칸씩 이동시키며 합 구하기
            for(int i = 0; i <= M - N; i++){
                int currentSum = 0;
             	for(int j = 0; j < N; j++){
                	currentSum += aList[j] * bList[i + j]; 
                }
                result = (result < currentSum) ? currentSum : result;
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
}