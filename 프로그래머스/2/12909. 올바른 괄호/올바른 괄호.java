class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int left = 0;
        int right = 0;
        
        if(s.charAt(0) == ')'){
            return false;
        }
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                left++;
            }
            else{
                right++;
            }
            
            if(left - right < 0){
                answer = false;
                break;
            }
        }
        
        if(left != right){
            answer = false;
        }

        return answer;
    }
}