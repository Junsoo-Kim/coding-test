import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] buildings = new int[N][256];
            int cnt = 0;
            
            for(int i = 0; i < N; i++){
                int height = Integer.parseInt(st.nextToken());
                for(int j = 0; j <= height; j++){
                 	buildings[i][j] = 1;   
                }
            }
            
            for(int i = 2; i < N - 2; i++){
             	for(int j = 1; j < 256; j++){
                 	   if(buildings[i][j] == 1){
                           if(buildings[i-2][j] == 0 && buildings[i-1][j] == 0 && 
                              buildings[i+1][j] == 0 && buildings[i+2][j] == 0){
                               cnt++;
                           }
                       } else{
                           break;
                       }
                }
            }
            sb.append("#" + t + " " + cnt + "\n");
        }
    System.out.print(sb);
    }
}