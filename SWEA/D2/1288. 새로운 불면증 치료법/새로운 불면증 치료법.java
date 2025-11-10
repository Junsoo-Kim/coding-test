import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            sb.setLength(0);
            int N = Integer.parseInt(br.readLine());
            int result = N;
            HashSet<Character> zeroToNine = new HashSet<>();
            
            while(zeroToNine.size() < 10){
            	String currentString = Integer.toString(result);
                for(int i = 0; i < currentString.length(); i++){
                 	zeroToNine.add(currentString.charAt(i));
                }
                result += N;
            }
            result -= N; // 마지막 루프 끝나면 N이 한번 더 더해져 있어서 빼야 함
            
            sb.append("#" + t + " " + result);
            System.out.println(sb);
        }
    }
}