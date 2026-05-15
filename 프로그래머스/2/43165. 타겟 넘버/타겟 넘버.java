class Solution {
    static int[] nums;
    static int t;
    static int cnt = 0;
    
    public int solution(int[] numbers, int target) {
        nums = numbers;
        t = target;
        
        dfs(0, 0);
        
        return cnt;
    }
    
    private void dfs(int depth, int value){
        if(depth == nums.length){
            if(value == t){
                cnt++;
            }
            return;
        }
        
        dfs(depth + 1, value + nums[depth]);
        dfs(depth + 1, value - nums[depth]);
    }
}