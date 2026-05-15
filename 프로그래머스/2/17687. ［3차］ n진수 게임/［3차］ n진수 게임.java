class Solution {
    static String memo = "";
    
    public String solution(int n, int t, int m, int p) {
        setMemo(n, t * m);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for(int i = 0; i < memo.length(); i++){
            if(i % m == (p - 1)){
                sb.append(memo.charAt(i));
                count++;
            }
            
            if(count == t){
                break;
            }
        }
        
        String answer = sb.toString().toUpperCase();
        return answer;
    }
    
    private void setMemo(int radix, int count){
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i <= count; i++){
            sb.append(Integer.toString(i, radix));
        }
        
        memo = sb.toString();
    }
}