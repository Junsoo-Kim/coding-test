import java.io.*;

public class Main{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        String first = br.readLine();
        String second = br.readLine();
        String third = br.readLine();
        
        int firstInt = 0;
        int secondInt = 0;
        int thirdInt = 0;
        
        if(first.matches("[-+]?\\d*")){
        	firstInt = Integer.parseInt(first);
        	thirdInt = firstInt + 2;
        }
        
        if(second.matches("[-+]?\\d*")){
        	secondInt = Integer.parseInt(second);
        	thirdInt = secondInt + 1;
        }
        
        if(third.matches("[-+]?\\d*")){
        	thirdInt = Integer.parseInt(third);
        }
        
        if((thirdInt + 1) % 3 != 0 && (thirdInt + 1) % 5 != 0) {
        	sb.append(thirdInt + 1);
        }
        
        if((thirdInt + 1) % 3 == 0) {
        	sb.append("Fizz");
        }
        
        if((thirdInt + 1) % 5 == 0) {
        	sb.append("Buzz");
        }
        
        System.out.print(sb);
    }
}