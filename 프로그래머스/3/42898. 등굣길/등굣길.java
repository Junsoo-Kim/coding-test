class Solution {
    public int solution(int m, int n, int[][] puddles) {
        // 물에 잠긴 지역 초기화
        int[][] grid = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                for(int[] puddle: puddles){
                    if(puddle[0] == i && puddle[1] == j){
                        grid[i][j] = 1;
                    }
                }
            }
        }
        
        // dp 메모이제이션
        int[][] dp = new int[m + 1][n + 1];
        dp[1][1] = 1;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(i == 1 && j == 1){
                    continue;
                }
                if(grid[i][j] == 1){
                    continue;
                }
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        
        // for(int i = 1; i <= m; i++){
        //     for(int j = 1; j <= n; j++){
        //         System.out.print(dp[i][j]);
        //     }
        //     System.out.print("\n");
        // }
    
        return dp[m][n];
    }
}

/*
dp[i][j] : i행 j열까지 도달할수 있는 경우의 수
dp[i][j] = dp[i-1][j] + dp[i][j-1]
dp[1][2] = 1, dp[2][1] = 1 
*/