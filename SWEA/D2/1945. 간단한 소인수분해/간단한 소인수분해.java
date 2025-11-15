import java.util.*;
import java.io.*;

class Solution{
	public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
        	int N = Integer.parseInt(br.readLine());
            int[] divisorList = {2, 3, 5, 7, 11};
            int[] resultList = new int[5];
            int i = 0;
            
            while(N != 1){
             	if(N % divisorList[i] == 0){
                       N /= divisorList[i];
                       resultList[i]++;
                } 
                else{
                     i++;  
                }
            }
            sb.append("#" + t + " " + resultList[0] + " " + resultList[1] + " " 
                      + resultList[2] + " " + resultList[3] + " " + resultList[4] + "\n");
        }
        System.out.print(sb);
    }
}