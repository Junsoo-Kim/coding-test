import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        String result = (A > B) ? "A" : "B";
        result = (A == 3 && B == 1) ? "B" : result;
        result = (A == 1 && B == 3) ? "A" : result;
        
        System.out.print(result);
    }
}