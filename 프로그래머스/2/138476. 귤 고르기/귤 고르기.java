import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t, 0) + 1);
        }
        
        ArrayList<Integer> cntList = new ArrayList<>(map.values());
        cntList.sort(Comparator.reverseOrder());
        
        int tCount = 0;
        int result = 0;
        for(int cnt : cntList){
            tCount += cnt;
            result++;
            if(tCount >= k){
                break;
            }
        }
        
        return result;
    }
}