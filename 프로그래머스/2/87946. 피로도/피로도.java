class Solution {
    static boolean[] visited;
    static int cnt = 0;
    static int result = 0;
    int tired;
    int[][] dungeonList;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        this.dungeonList = dungeons;
        
        for(int i = 0; i < dungeonList.length; i++){
            cnt = 1;
            this.tired = k - dungeonList[i][1];
            visited[i] = true;
            dfs(i);
            visited[i] = false;
        }  
        
        return result;
    }
    
    private void dfs(int dNum){      
        // 기록 갱신
        if(result < cnt){
            result = cnt;
        }
        
        // 다음 던전 찾아서 방문하고 백트래킹
        for(int i = 0; i < dungeonList.length; i++){
            if(!visited[i] && dungeonList[i][0] <= tired){
                cnt++;
                tired -= dungeonList[i][1];
                visited[i] = true;
                
                dfs(i);
                
                cnt--;
                tired += dungeonList[i][1];
                visited[i] = false;
            }
        }
    }
}