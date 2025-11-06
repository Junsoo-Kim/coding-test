import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> numList = new ArrayList<>();
        
        for(int test_case = 1; test_case <= T; test_case++){
            numList.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numList);
        
        System.out.println(numList.get(T / 2));
	}
}