class Solution {
    int[] dp = new int[60001];
    int temp = memoDP();
    
    public int solution(int n) {
        return dp[n];
    }
    
    private int memoDP(){
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3; i <= 60000; i++){
            dp[i] = (dp[i - 2] + dp[i - 1]) % 1000000007;
        }
        
        return 1;
    }
}