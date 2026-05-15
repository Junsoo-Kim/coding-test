import java.util.*;

class Solution {
    static boolean[][] visited;
    static int[][] board;
    static int n;
    
    public int[] solution(int num) {
        n = num;
        visited = new boolean[n + 1][n + 1];
        board = new int[n + 1][n + 1];
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(i < j){
                    board[i][j] = -1;
                }
            }
        }
        
        int start = 1;
        int x = 1, y = 1;
        while(true){
            int next = runAround(start, x, y);
            if(start == next){
                break;
            }
            else{
                start = next;
                x += 2;
                y += 1;
            }
        }
        
        List<Integer> answerList = new ArrayList<>();
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < n + 1; j++){
                if(board[i][j] > 0){
                    answerList.add(board[i][j]);
                }
            }
        }
        
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
    
    private int runAround(int start, int x, int y){
        int cnt = start;
        
        for(; x < n + 1; x++){
            if(!visited[x][y] && board[x][y] != -1){
                board[x][y] = cnt;
                visited[x][y] = true;
                cnt++;
            }
            else{
                break;
            }
        }
        x--;
        y++;
        
        for(; y < n + 1; y++){
            if(!visited[x][y] && board[x][y] != -1){
                board[x][y] = cnt;
                visited[x][y] = true;
                cnt++;
            }
            else{
                break;
            }
        }
        y--;
        y--;
        x--;
        
        for(; x > 0 && y > 0; x--, y--){
            if(!visited[x][y] && board[x][y] != -1){
                board[x][y] = cnt;
                visited[x][y] = true;
                cnt++;
            }
            else{
                break;
            }
        }
        
        return cnt;
    }
}