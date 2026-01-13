import java.util.*;
import java.io.*;

class Solution {
    private boolean isOnTime(int schedule, int timelog){
        int hourDiff = timelog / 100 - schedule / 100;
        int minuteDiff = timelog % 100 - schedule % 100;
        minuteDiff += hourDiff * 60;
        
        if(minuteDiff <= 10){
            return true;
        }
        else{
            return false;
        }
    }
    
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int onTimeCnt = 0;
        int n = schedules.length;
        
        // 주말의 출근시각을 -1로 변경
        if(startday == 7){
            for(int i = 0; i < n; i++){
                timelogs[i][0] = -1;
                timelogs[i][6] = -1;
            }    
        }
        else{
            for(int i = 0; i < n; i++){
                timelogs[i][6-startday] = -1;
                timelogs[i][7-startday] = -1;
            }  
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 7; j++){
                if(timelogs[i][j] == -1){
                    continue;
                }
                
                if(isOnTime(schedules[i], timelogs[i][j])){
                    onTimeCnt++;
                }
            }
            if(onTimeCnt == 5){
                answer++;
            }
            onTimeCnt = 0;
        }
        
        return answer;
    }
}