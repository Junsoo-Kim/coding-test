import java.util.*;
import java.io.*;

class Solution{
	public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        for(int i = num; i > 0; i--){
        	System.out.print(i + " ");
        }
        System.out.println(0);
    }
}