import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long result = 0;
            int max = -1;
            int min = 10001;
            int temp;
            
            for(int i = 0; i < 10; i++){
             	temp = Integer.parseInt(st.nextToken());
                result += temp;
                max = (max < temp) ? temp : max;
                min = (min > temp) ? temp : min;
            }
            result = Math.round((float) (result - max - min) / 8.0);
            
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
    }
}