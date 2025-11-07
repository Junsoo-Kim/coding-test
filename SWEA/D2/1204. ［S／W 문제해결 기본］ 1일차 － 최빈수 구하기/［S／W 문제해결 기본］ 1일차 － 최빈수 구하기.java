import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            // 변수 선언 및 초기화
            int testNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        	ArrayList<Integer> numList = new ArrayList<>();
            int mode = -1;
            int modeCount = -1;
            int currentNum = -1;
            int currentCount = -1;
            
			// 리스트에 값 추가 => O(n)
            for(int i = 0; i < 1000; i++){
             	numList.add(Integer.parseInt(st.nextToken()));   
            }
            
            // 정렬 => O(nlogn)
            Collections.sort(numList);
            
            // 리스트 1번 순회하면서 최빈값과 카운트 갱신 => O(n)
            for(int i = 0; i < 1000; i++){
                // 현재 값이 이전값과 다른 경우
                // currentNum과 currentCount를 초기화
                if(numList.get(i) != currentNum){
                 	currentNum = numList.get(i);
                    currentCount = 0;
                }
                currentCount++;
              	
                // currentCount가 modeCount와 같거나 큰 경우
                // 뒤에 등장한 currentNum은 무조건 mode보다 같거나 큼
                // modeCount와 mode를 갱신
                if(currentCount >= modeCount){
                 	modeCount = currentCount;
                    mode = currentNum;
                }
            }
            
            System.out.println("#" + testNum + " " + mode);
        }
    }
}