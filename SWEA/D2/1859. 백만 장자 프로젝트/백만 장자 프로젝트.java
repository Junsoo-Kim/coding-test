import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            // 변수 정의 및 초기화 
            int N = Integer.parseInt(br.readLine());
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            ArrayList<Integer> priceList = new ArrayList<>();
            for(int i = 0; i < N; i++){
            	priceList.add(Integer.parseInt(st.nextToken()));
            }
            Long result = 0l;
            int start = 0;
            
            // priceList에서 아이템을 계속 제거하며 결과값 찾기
            while(start < N){
            	// priceList에서 최대값과 인덱스 찾기
                // 같은 값이 있으면 가장 뒤의 인덱스로
                int max = -1;
    			int maxIndex = -1;
    			for(int i = start; i < N; i++){
        			if(priceList.get(i) >= max){
                		max = priceList.get(i);
            			maxIndex = i;
        			}
    			}
                       
                // 최대값 이전의 물건은 전부 최대값 가격으로 판매
                for(int i = start; i < maxIndex; i++){
                	result += max - priceList.get(i);
                }
                
                // 최대값과 그 이전의 물건들을 리스트에서 전부 제거
                // 실제로 요소를 제거하지 말고 제거한 것처럼 취급하도록
                start = maxIndex + 1;
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
}