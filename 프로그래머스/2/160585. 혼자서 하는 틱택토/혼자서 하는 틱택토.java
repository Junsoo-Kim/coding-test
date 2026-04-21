class Solution {
    public int solution(String[] board) {
        int answer = 1;
        int oCnt = 0, xCnt = 0;
        int oWinCnt = 0, xWinCnt = 0;
        
        
        oWinCnt = getOWinCnt(board);
        xWinCnt = getXWinCnt(board);
        
        for(int i = 0; i < 3; i++){
            for(int j = 0 ; j < 3; j++){
                if(board[i].charAt(j) == 'O'){
                    oCnt++;
                }
                else if(board[i].charAt(j) == 'X'){
                    xCnt++;
                }
            }
        } 
        
        // 정답이 2줄 이상인지 검사
        if(oWinCnt + xWinCnt > 1){
            // O가 2줄 동시 완성한 경우 제외
            if(oWinCnt == 2 && oCnt + xCnt == 9){
                return 1;
            }
            return 0;
        }
        
        // 정답이 0줄이면서 O개수 - X개수가 0 혹은 1이 아닌가?
        if(oWinCnt + xWinCnt == 0){
            if(oCnt - xCnt != 0 && oCnt - xCnt != 1){
                return 0;
            }
        }
        
        // O정답이 1줄이면서 O개수 - X개수가 1이 아닌가?
        if(oWinCnt == 1 && oCnt - xCnt != 1){
            return 0;
        }
        
        // X정답이 1줄이면서 O개수 - X개수가 0이 아닌가?
        if(xWinCnt == 1 && oCnt - xCnt != 0){
            return 0;
        }
        
        return 1;
    }
    
    private int getXWinCnt(String[] board){
        int winCnt = 0;
        
        // 수평 수직 체크
        for(int i = 0; i < 3; i++){
            if(board[i].equals("XXX")){
                winCnt++;
            }
            if(board[0].charAt(i) == 'X' && board[1].charAt(i) == 'X' && board[2].charAt(i) == 'X'){
                winCnt++;
            }
        }
        
        // 대각선 체크
        if(board[0].charAt(0) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(2) == 'X'){
                winCnt++;
        }
        if(board[0].charAt(2) == 'X' && board[1].charAt(1) == 'X' && board[2].charAt(0) == 'X'){
                winCnt++;
        }
        
        return winCnt;
    }
    
private int getOWinCnt(String[] board){
        int winCnt = 0;
        
        // 수평 수직 체크
        for(int i = 0; i < 3; i++){
            if(board[i].equals("OOO")){
                winCnt++;
            }
            if(board[0].charAt(i) == 'O' && board[1].charAt(i) == 'O' && board[2].charAt(i) == 'O'){
                winCnt++;
            }
        }
        
        // 대각선 체크
        if(board[0].charAt(0) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(2) == 'O'){
                winCnt++;
        }
        if(board[0].charAt(2) == 'O' && board[1].charAt(1) == 'O' && board[2].charAt(0) == 'O'){
                winCnt++;
        }
        
        return winCnt;
    }
}