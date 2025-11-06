import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int result = -1;
            int temp;
            
            for(int i = 0; i < 10; i++){
                temp = Integer.parseInt(st.nextToken());
            	result = (result < temp) ? temp : result;
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
}