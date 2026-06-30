import java.io.*;
import java.util.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        String result = (A < B) ? "B" : "A";
        
        if(A == 3 && B == 1) {
        	result = "B";
        }
        else if(A == 1 && B == 3) {
        	result = "A";
        }
        
        System.out.print(result); 
 	}
}