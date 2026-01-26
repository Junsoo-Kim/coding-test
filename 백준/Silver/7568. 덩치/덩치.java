import java.util.*;
import java.io.*;

public class Main{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[][] sizeArr = new int[N][2];
        int[] sizeRank = new int[N];
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	sizeArr[i][0] = Integer.parseInt(st.nextToken());
        	sizeArr[i][1] = Integer.parseInt(st.nextToken());
        	sizeRank[i] = 1;
        }
        
        for(int i = 0; i < N; i++) {
        	for(int j = 0; j < N; j++) {
        		if(sizeArr[i][0] < sizeArr[j][0] && sizeArr[i][1] < sizeArr[j][1]) {
        			sizeRank[i]++;
        		}
        	}
        }
        
        for(int i = 0; i < N; i++) {
        	sb.append(sizeRank[i] + " ");
        }
        
        System.out.print(sb);
    }
}