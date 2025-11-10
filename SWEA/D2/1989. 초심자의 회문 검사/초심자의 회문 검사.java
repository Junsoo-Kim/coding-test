import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
         	String str = br.readLine();
            int result = 1;
            
            for(int i = 0; i < str.length() / 2; i++){
             	   result = (str.charAt(i) != str.charAt(str.length() - i - 1)) ? 0 : result; 
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
}