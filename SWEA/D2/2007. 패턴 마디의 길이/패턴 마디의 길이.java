import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            String substring = "";
            
            for(int i = 0; i < 30; i++){
            	substring += str.charAt(i);
                
                // substring 마디가 다음 마디와 동일한지 비교
                if(substring.equals(str.substring(i + 1, i + 1 + substring.length()))){
                    Boolean isNode = true;
                    // substring 마디가 끝까지 계속 동일한지 비교
                    for(int j = i + substring.length(); j < 30 - substring.length(); j+=substring.length()){
                     	if(substring.equals(str.substring(j, j + substring.length()))){
                            isNode = false;
                            break;
                        }
                    }
                    if(isNode == true){
                    	break;   
                    }
                }
            }
            System.out.println("#" + t + " " + substring.length());
        }
    }
}