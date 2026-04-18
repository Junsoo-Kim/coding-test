class Solution {
    public int[] solution(String s) {
        int cnt = 0, zero = 0;
        
        while(!s.equals("1")){
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) == '0'){
                    s = s.substring(0, i).concat((s.substring(i + 1, s.length())));
                    i--; 
                    zero++;
                }
            }
            
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        
        int[] answer = {cnt, zero};
        
        return answer;
    }
}