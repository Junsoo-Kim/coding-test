import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            String result = "";
            
            // 줄바꿈 없는 결과 텍스트 생성
            for(int i = 0; i < N; i++){
            	StringTokenizer st = new StringTokenizer(br.readLine());
                String C = st.nextToken();
                int K = Integer.parseInt(st.nextToken());
                
                for(int j = 0; j < K; j++){
                	result += C;   
                }
            }
            
            // 결과에 줄바꿈 추가해서 sb에 append
            sb.append("#" + t + "\n");
            for(int i = 1; i < result.length() + 1; i++){
            	sb.append(result.charAt(i - 1));
                if(i % 10 == 0){
                 	sb.append("\n");   
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}