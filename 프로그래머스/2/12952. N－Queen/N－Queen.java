class Solution {
    static boolean[][] grid;
    static int count = 0;
    int n;
    
    public int solution(int n) {
        this.n = n;
        grid = new boolean[n][n];
        
        backtrack(0);
        
        return count;
    }
    
    private void backtrack(int row){
        if(row == n){
            count++;
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(isSafe(row, i)){
                grid[row][i] = true;
                backtrack(row + 1);
                grid[row][i] = false;
            }
        }
    }
    
    private boolean isSafe(int row, int col){
        for(int i = 0; i < row; i++){
            if(grid[i][col]){
                return false;
            }
        }
        
        // 왼쪽 위 대각선 체크
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j]) return false;
        }
        
        // 오른쪽 위 대각선 체크
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (grid[i][j]) return false;
        }
        
        return true;
    }
}