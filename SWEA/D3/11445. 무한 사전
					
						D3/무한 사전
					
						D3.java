import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
     	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
         	String P = br.readLine();
            String Q = br.readLine();
            
            if(Q.equals(P + "a")){
             	sb.append("#" + t + " N\n");	   
            }
            else{
                sb.append("#" + t + " Y\n");
            }
        }
         	
        System.out.print(sb);
        return;
 	}
}