import java.util.*;

class Solution {
    static int result = 0;
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length + 1];
        ArrayList<Integer>[] graph = new ArrayList[words.length + 1];
        int result = 0;
        
        // begin을 포함한 wordList 초기화
        String[] wordList = new String[words.length + 1];
        wordList[0] = begin;
        for(int i = 1; i < wordList.length; i++){
            wordList[i] = words[i - 1];
        }
        
        // graph 초기화
        for(int i = 0; i < wordList.length; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < wordList.length; i++){
            for(int j = 0; j < wordList.length; j++){
                if(i == j){
                    continue;
                }
                if(isConvertable(wordList[i], wordList[j])){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        
        // 0번째(start)에서 시작해서 target까지 도달해야 함
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        visited[0] = true;
        
        while(!queue.isEmpty()){
            int[] temp = queue.poll();
            int curr = temp[0];
            int depth = temp[1];
            
            if(wordList[curr].equals(target)){
                result = depth;
                break;
            }
            
            for(int next : graph[curr]){
                if(!visited[next]){
                    queue.offer(new int[]{next, depth + 1});
                    visited[next] = true;
                }
            }
        }
        
        // 결과값 반환
        return result;
    }
    
    private boolean isConvertable(String a, String b){
        int cnt = 0;
        
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                cnt++;
            }
        }
        
        if(cnt == 1){
            return true;
        }
        else{
            return false;
        }
    }
}