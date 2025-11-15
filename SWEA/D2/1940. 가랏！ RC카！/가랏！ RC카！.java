import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
        	int N = Integer.parseInt(br.readLine());
            int result = 0;
            int currentSpeed = 0;
            int command = 0;
            int acc = 0;
            
            for(int i = 0; i < N; i++){
            	StringTokenizer st = new StringTokenizer(br.readLine());
             	command = Integer.parseInt(st.nextToken());
                
                if(command == 1){
                	acc = Integer.parseInt(st.nextToken());
                    currentSpeed += acc;
                }
                else if(command == 2){
                	acc = Integer.parseInt(st.nextToken());
                    currentSpeed = (currentSpeed > acc) ? currentSpeed - acc : 0;
                }
                result += currentSpeed;
            }
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
    }
}