class Solution {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = -1 * Integer.MAX_VALUE;
        String[] sList = s.split(" ");
        
        for(int i = 0; i < sList.length; i++){
            int curr = Integer.valueOf(sList[i]);
            if(curr < min){min = curr;}
            if(curr > max){max = curr;}
        }
        
        String answer = min + " " + max;
        
        return answer;
    }
}