class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length + 1][triangle.length + 1];
        dp[1][1] = triangle[0][0];
        
        for(int i = 2; i <= triangle.length; i++){
            for(int j = 1; j <= i; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i-1][j-1];
            }
        }
        
        // for(int i = 0; i <= triangle.length; i++){
        //     for(int j = 0; j <= triangle.length; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.print("\n");
        // }
        
        for(int i = 0; i <= triangle.length; i++){
            if(answer < dp[triangle.length][i]){
                answer = dp[triangle.length][i];
            }
        }
        
        return answer;
    }
}