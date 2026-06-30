import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int result = 0;
        
        for(int i = 0; i < N.length(); i++) {
        	result += N.charAt(i) - '0';
        }
        
        System.out.print(result);
    }
}