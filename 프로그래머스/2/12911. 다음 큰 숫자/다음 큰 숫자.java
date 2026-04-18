class Solution {
    public int solution(int n) {
        String nBinary = Integer.toBinaryString(n);
        int nCnt = countOne(nBinary);
        
        while(true){
            n++;
            nBinary = Integer.toBinaryString(n);
            if(countOne(nBinary) == nCnt){
                break;
            }
        }
        
        return n;
    }
    
    public int countOne(String num){
        int cnt = 0;
        
        for(int i = 0; i < num.length(); i++){
            if(num.charAt(i) == '1'){
                cnt++;
            }
        }
        
        return cnt;
    }
}