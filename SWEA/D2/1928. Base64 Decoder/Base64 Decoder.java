import java.util.*;
import java.io.*;

class Solution{
    public static String decodeChar(char ch){
        if (ch == '+'){
         	return("111110");
        } else if (ch == '/'){
            return("111111");
        } else if (ch == '='){
            return("000000");
        }
        
        int temp = 0;
       	String result = "";
        
        if (65 <= (int) ch && (int) ch <= 90){
        	temp = (int) ch - 65;
        } else if (97 <= (int) ch && (int) ch <= 122){
        	temp = (int) ch - 71;
        } else if (48 <= (int) ch && (int) ch <= 57){
        	temp = (int) ch + 4;
        } 
        result = Integer.toBinaryString(temp);
        
        while(result.length() < 6){
         	result = "0" + result;   
        }
        return result;
    }
    
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
        	String encodedStr = br.readLine();
            String binaryString = "";
            String result = "";
            
            for(int i = 0; i < encodedStr.length(); i++){
                binaryString += decodeChar(encodedStr.charAt(i));
            }
            for(int i = 0; i < binaryString.length(); i += 8){
                result += (char) (Integer.parseInt(binaryString.substring(i, i + 8), 2));
            }
             
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
    }
}