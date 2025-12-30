import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int nLine = (int) Math.ceil((double) n / w);
        int numLine = (int) Math.ceil((double) num / w);
        int answer = nLine - numLine + 1;
        
        if((nLine - numLine) % 2 == 1){
            num = 2 * w * numLine + 1 - num;
            numLine++;
        }
        
        if(num + w * (nLine - numLine) > n){
                answer--;
        }
        
        return answer;
    }
}