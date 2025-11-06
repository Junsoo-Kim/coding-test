import java.util.*;
import java.io.*;

class Solution{
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split("");
        int result = 0;
        
        for(int i = 0; i < nums.length; i++){
         	result += Integer.parseInt(nums[i]);   
        }
        
        System.out.println(result);
    }
}