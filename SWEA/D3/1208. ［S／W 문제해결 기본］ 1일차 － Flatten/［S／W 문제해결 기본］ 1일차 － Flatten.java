import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int t = 1; t <= 10; t++){
        	int N = Integer.parseInt(br.readLine());
        	int maxIndex = 0;
        	int minIndex = 0;
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	ArrayList<Integer> heightList = new ArrayList<>();
        	
        	for(int i = 0; i < 100; i++) {
        		heightList.add(Integer.parseInt(st.nextToken()));
        	}
        	
        	while(N > 0) {
        		maxIndex = heightList.indexOf(Collections.max(heightList));
        		minIndex = heightList.indexOf(Collections.min(heightList));
        		
        		if(maxIndex == minIndex) {break;}
        		
        		heightList.set(maxIndex, heightList.get(maxIndex) - 1);
        		heightList.set(minIndex, heightList.get(minIndex) + 1);
        		
        		N--;
        	}
        	sb.append("#" + t + " ");
        	sb.append((Collections.max(heightList) - Collections.min(heightList)) + "\n");
        }
        System.out.print(sb);
    }
}