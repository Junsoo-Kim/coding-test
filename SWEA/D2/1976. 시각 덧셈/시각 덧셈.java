import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startHour = Integer.parseInt(st.nextToken());
            int startMinute = Integer.parseInt(st.nextToken());
            int endHour = Integer.parseInt(st.nextToken());
            int endMinute = Integer.parseInt(st.nextToken());
            int resultHour = startHour + endHour;
            int resultMinute = startMinute + endMinute;
            
            if(resultMinute >= 60){
            	resultMinute -= 60;
                resultHour++;
            }
            if(resultHour > 12){
                resultHour -= 12;
            }
            
            sb.append("#" + t + " " + resultHour + " " + resultMinute + "\n");
        }
        System.out.print(sb);
    }
}