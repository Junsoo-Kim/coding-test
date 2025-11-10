import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int result = (N % 2 == 0) ? -1 * (N / 2)  : -1 * (N / 2) + N;
            
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
    }
}