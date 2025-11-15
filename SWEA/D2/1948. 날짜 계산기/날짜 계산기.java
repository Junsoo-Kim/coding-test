import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        int[] dateList = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());
            int result = 0;
            
            // 시작월의 첫번째 날 ~ 종료월의 마지막 날까지만 계산
            for(int i = startMonth; i < endMonth + 1; i++){
             	result += dateList[i];
            }
            
            // 시작일 반영
            result -= startDay - 1;
            // 종료일 반영
            result -= dateList[endMonth] - endDay;
            
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
    }
}