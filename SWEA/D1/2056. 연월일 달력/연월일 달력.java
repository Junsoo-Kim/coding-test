import java.util.*;
import java.io.*;

class Solution{
    public static void main(String args[]) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
        	String rawDate = br.readLine();
            String month = rawDate.substring(4, 6);
            String day = rawDate.substring(6, 8);
            String result = rawDate.substring(0, 4) + "/";  // year + "/"
            
            switch(Integer.parseInt(month)){
                case 4:
               	case 6:
                case 9:
                case 11:
                	result = (1 <= Integer.parseInt(day) && Integer.parseInt(day) <= 30) ? 
                        result + month + "/" + day : "-1";
                    break;
                    
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    result = (1 <= Integer.parseInt(day) && Integer.parseInt(day) <= 31) ? 
                        result + month + "/" + day : "-1";
                    break;
                    
                case 2:
                    result = (1 <= Integer.parseInt(day) && Integer.parseInt(day) <= 28) ? 
                        result + month + "/" + day : "-1";
                    break;
                    
                default:
                    result = "-1";
            }
            
            System.out.println("#" + t + " " + result);
        }
    }
}