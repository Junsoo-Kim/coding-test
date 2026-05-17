class Solution {
    public int solution(int n, int[] money) {
        int[] dp = new int[n + 1];
        
        dp[0] = 1;
        
        for(int m : money){
            for(int i = 1; i <= n; i++){
                if(i - m >= 0){
                    dp[i] += dp[i - m];
                }
            }
        }
        
        return dp[n];
    }
}

/*
dp[i] = dp[i] + dp[i-a] + dp[i-b] + ...
i일때 a b c 다 돌면서
i a일떄
dp[i] += dp[i - a];

*/