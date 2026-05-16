class Solution {
    public int solution(int sticker[]) {
        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];
        
        // 스티커 개수 1개면 바로 반환
        if(sticker.length == 1){
            return sticker[0];
        }
        
        // 0을 뜯은 경우를 dp1에
        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        
        for(int i = 2; i < sticker.length - 1; i++){
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
        }
        
        // 마지막거를 뜯은 경우를 dp2에
        dp2[0] = 0;
        dp2[1] = sticker[1];
        
        for(int i = 2; i < sticker.length; i++){
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        
        //dp1과 dp2 결과를 비교
        return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }
}