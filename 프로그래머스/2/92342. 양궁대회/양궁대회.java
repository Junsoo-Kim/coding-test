import java.util.*;

class Solution {
    static int[] apeach;
    static int[] rion = new int[11];
    static int score = 0;
    static int[] answer = new int[]{-1};
    static int numMax;
    
    public int[] solution(int n, int[] info) {
        apeach = info;
        numMax = n;
        
        for(int i = 0; i < 11; i++){
            if(apeach[i] + 1 <= numMax){
                rion[i] = apeach[i] + 1;
                
                dfs(i);
                
                rion[i] = 0;
            }
        }
        
        return answer;
    }
    
    private void dfs(int target){
        // Math.sum(rion) 구현
        int sum = 0;
        for(int i = 0; i < 11; i++){
            sum += rion[i];
        }
        
        // 결과 갱신
        if(sum == numMax){
            int result = getScore();
            if(result > score){
                score = result;
                answer = Arrays.copyOf(rion, 11);
            }
            else if(result == score && score != 0){
                for (int i = 10; i >= 0; i--) { // 0점부터 역순으로 비교
                if (rion[i] > answer[i]) {
            answer = Arrays.copyOf(rion, 11);
            break;
        } else if (rion[i] < answer[i]) {
            break; 
        }
    }
            }
            return;
        }
        
        // 10점부터 1점까지 돌면서 넣고 백트래킹
        for(int i = 0; i < rion.length; i++){
            if(rion[i] == 0 && sum + (apeach[i] + 1) <= numMax){
                // 어피치보다 한개 더 쏘도록 하고 다음으로
                rion[i] = apeach[i] + 1;
                
                dfs(i);
                
                // 남는 화살들을 다 0점에 넣었을 때 검사
                rion[10] += numMax - (sum + 1);
                
                dfs(i);
                
                // 백트래킹
                rion[10] -= numMax - (sum + 1);
                
                rion[i] = 0;
            }
        }
    }
    
    private int getScore(){
        int num = 0;
        
        for(int i = 0; i < 11; i++){
            if(rion[i] > apeach[i]){
                num += 10 - i;
            }
            else if(rion[i] <= apeach[i] && apeach[i] != 0){
                num -= 10 - i;
            }
        }
        
        return num;
    }
}