import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Map<String, Boolean> phoneHash = new HashMap<String, Boolean>();
        
        for(int i = 0; i < phone_book.length; i++){
            phoneHash.put(phone_book[i], true);
        }
        
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 1; j < phone_book[i].length(); j++){
                if(phoneHash.containsKey(phone_book[i].substring(0, j))){
                    answer = false;
                    break;
                }
            }
            
            if(!answer){break;}
        }
        
        return answer;
    }
}