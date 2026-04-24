import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        String[] inList = new String[10000];
        int[] timeList = new int[10000];
        List<Integer> resultList = new ArrayList<>();
        
        // 누적 주차 시간 계산
        for(int i = 0; i < records.length; i++){
            int carNum = Integer.parseInt(records[i].substring(6, 10));
            
            if(inList[carNum] == null){
                inList[carNum] = records[i].substring(0, 5);
            }
            else{
                String outTime = records[i].substring(0, 5);
                String inTime = inList[carNum];
                
                timeList[carNum] += getTime(inTime, outTime);
                inList[carNum] = null;
            }
        }
        
        for(int i = 0; i < 10000; i++){
            if(inList[i] != null){
                String outTime = "23:59";
                String inTime = inList[i];
                
                timeList[i] += getTime(inTime, outTime);
                inList[i] = null;
            }
            if(timeList[i] != 0){
                resultList.add(getFee(timeList[i], fees));
            }
        }
            
        int[] answer = new int[resultList.size()];
        
        for(int i = 0; i < resultList.size(); i++){
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
    
    private int getTime(String inTime, String outTime){
        int inHour = Integer.parseInt(inTime.substring(0, 2));
        int inMin = Integer.parseInt(inTime.substring(3, 5));
        int outHour = Integer.parseInt(outTime.substring(0, 2));
        int outMin = Integer.parseInt(outTime.substring(3, 5));
        return (outHour - inHour) * 60 + (outMin - inMin);
       
    }
    
    private int getFee(int time, int[] fees){
        int result = 0;
        
        result += fees[1];
        time -= fees[0];
        
        if(time <= 0){
            return result;
        }
        else{
            result += (Math.ceil((double) time / fees[2])) * fees[3];
            return result;
        }
    }
}