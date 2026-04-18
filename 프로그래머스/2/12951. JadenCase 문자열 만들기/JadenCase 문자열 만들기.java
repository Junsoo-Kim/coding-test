import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        
        for(int i = 0; i < chars.length; i++){
            if(i == 0){
                chars[i] = Character.toUpperCase(chars[i]);
            }
            else if(s.charAt(i - 1) == ' '){
                chars[i] = Character.toUpperCase(chars[i]);
            }
        }
        
        String answer = new String(chars);
        
        return answer;
    }
}