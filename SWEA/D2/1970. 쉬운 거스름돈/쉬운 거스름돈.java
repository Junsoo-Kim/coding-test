import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            int[] unitList = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
            int[] result = new int[8];
            
            for(int i = 0; i < 8; i++){
             	result[i] = N / unitList[i];
                N %= unitList[i];
            }
            
            sb.append("#" + t + "\n");
            for(int i : result){
            	sb.append(i + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}