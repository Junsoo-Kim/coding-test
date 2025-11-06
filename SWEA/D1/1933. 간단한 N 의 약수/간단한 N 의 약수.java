import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int num = Integer.parseInt(br.readLine());
        double checkNum = Math.sqrt(num); 
        ArrayList<Integer> divList = new ArrayList<>();
        
        for(int i = 1; i <= checkNum; i++){
         	if(num % i == 0){
                divList.add(i);
            }
        }
        
        int length = divList.size();
        for(int i = 0; i < length; i++){
        	divList.add(num / divList.get(i));
        }
        Collections.sort(divList);
        
        for(int i = 0; i < divList.size(); i++){
         	System.out.print(divList.get(i) + " ");   
        }
    }
}