import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        int result = 1;
        
        for(int _ = 0; _ <= num; _++){
        	System.out.print(result + " ");
            result *= 2;
        }
    }
}