import java.util.*;

class Solution {
    static ArrayList<String> list = new ArrayList<>();
    
    public int solution(String word) {
        list.add("A"); dfs("A");
        list.add("E"); dfs("E");
        list.add("I"); dfs("I");
        list.add("O"); dfs("O");
        list.add("U"); dfs("U");
        
        int answer = list.indexOf(word) + 1;
        return answer;
    }
    
    private void dfs(String curr){
        if(curr.length() == 5){
            return;
        }
        
        String[] strs = new String[]{curr + "A", curr + "E", curr + "I", curr + "O", curr + "U"};
        list.add(strs[0]); dfs(strs[0]);
        list.add(strs[1]); dfs(strs[1]);
        list.add(strs[2]); dfs(strs[2]);
        list.add(strs[3]); dfs(strs[3]);
        list.add(strs[4]); dfs(strs[4]);
    }
}