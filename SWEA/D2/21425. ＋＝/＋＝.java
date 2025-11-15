import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
        	StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int result = 0;
            
            // 항상 A <= B를 유지
            if(A > B){
             	int temp = A;
                A = B;
                B = temp;
            }
            
            while(A + B <= N){
            	A += B;
                result++;
                if(A + B > N){break;}
                
                B += A;
                result++;
            }
            result++;
            
            sb.append(result + "\n");
        }
        System.out.print(sb);
    }
}