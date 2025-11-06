import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]) throws Exception{
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            
            String result = (num1 == num2) ? "=" : "";
            result = (num1 > num2) ? ">" : result;
            result = (num1 < num2) ? "<" : result;
            
            System.out.println("#" + t + " " + result);
        }
    }
}