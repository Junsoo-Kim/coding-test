class Solution {
    static int nNum;
    
    public int solution(int n) {
        if(n == 0 || n == 1){return n;}
        
        nNum = n;
        int answer = fibonacci(0, 1, 2) % 1234567;
        
        return answer;
    }
    
    static int fibonacci(int a, int b, int cnt){
        if(cnt == nNum){
            return (a + b) % 1234567;
        }
        else{
            return fibonacci(b, (a + b) % 1234567, cnt + 1);
        }
    }
}