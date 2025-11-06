import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int P = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        if(P >= K){
         	System.out.print(P - K + 1);   
        } 
        else {
        	System.out.print(-1);    
        }
    }
}