import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int result = Integer.MIN_VALUE;
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
            	A[i] = Integer.parseInt(st.nextToken());
            }
            
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++) {
            	B[i] = Integer.parseInt(st.nextToken());
            }
            
            // A의 크기를 더 작게 유지
            if(N > M) {
            	int temp = N;
            	N = M;
            	M = temp;
            	
            	int[] tempArr = A;
            	A = B;
            	B = tempArr;
            }
            
            for(int i = 0; i <= M - N; i++) {
            	int sum = 0;
            	
            	for(int j = 0; j < N; j++) {
            		sum += A[j] * B[i + j];
            	}

            	result = (result > sum) ? result : sum;
            }
            
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
    }
}
