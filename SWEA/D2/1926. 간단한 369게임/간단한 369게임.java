import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 1; i <= N; i++){
            int num = i;
            int cnt = 0;
            String str = "";
            
            // 100의 자리 체크
            if(num >= 100){
                if(num % 300 < 100){
                	cnt++;    
                }
                else{
                    str += Integer.toString(num / 100);
                }
            }
            num = num % 100;
            
            // 10의 자리 체크
            if(num >= 10){
                if(num % 30 < 10 ){
                 	cnt++;
                }
                else{
                 	str += Integer.toString(num / 10);
                }
            }
            num = num % 10;
            // x00 ~ x09의 경우 10의 자리 체크 예외 처리
            if(i >= 100 && i % 100 < 10){
            	str += "0";
            }
            
            
            // 1의 자리 체크
            if(num % 3 == 0 && num != 0){
                cnt++;
            }
            else{
             	str += Integer.toString(num);
            }
            
            // cnt가 0이면 숫자 출력
            if(cnt == 0){
                sb.append(str + " ");
            }
            // cnt가 1 이상이면 -를 개수에 맞게 출력
            else{
                for(int j = 0; j < cnt; j++){
                 	sb.append("-");   
                }
                sb.append(" ");
            }
        }
        System.out.print(sb);
        br.close();
    }
}