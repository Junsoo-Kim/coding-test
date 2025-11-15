import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> numList = new ArrayList<>();
            
            for(int i = 0; i < N; i++){
            	numList.add(Integer.parseInt(st.nextToken()));   
            }
            Collections.sort(numList);
            
            sb.append("#" + t + " ");
            for(int i : numList){
            	sb.append(i + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}