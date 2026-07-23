import java.io.*;
import java.util.*;

public class J5226S4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String line = br.readLine();
		int len = line.length();
		int[] lCnt = new int[len + 1];
		int[] rCnt = new int[len + 1];
		
		lCnt[0] = 0;
		rCnt[len] = 0;
		
		for(int i = 0; i < len; i++) {
			lCnt[i + 1] = lCnt[i] + ((line.charAt(i) == 'L') ? 1 : 0);
		}
		
		for(int i = 0; i < len; i++) {
			rCnt[len - i - 1] = rCnt[len - i] + ((line.charAt(len - i - 1) == 'R') ? 1 : 0);
		}
		
		int result = 0;
		for(int i = 0; i <= len; i++) {
			result = Math.max(result, lCnt[i] + rCnt[i]);
		}
		
		sb.append(result);
		
		System.out.print(sb);
	}
}
