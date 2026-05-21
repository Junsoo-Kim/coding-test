import java.util.*;
import java.io.*;

public class Solution {
	static String mString;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			mString = Integer.toBinaryString(M);
			
			int start = 0;
			int end = mString.length() - 1;
			int result = 0;
			
			while(start <= end) {
				int mid = (start + end) / 2;
				
				if(isValid(mid)) {
					result = Math.max(result, (mString.length()) - mid);
					end = mid - 1;
				}
				else {
					start = mid + 1;
				}
			}
			
			if(result >= N) {
				sb.append("#" + t + " ON\n");
			}
			else {
				sb.append("#" + t + " OFF\n");
			}
		}
		
		System.out.print(sb);
		
		return;
	}

	private static boolean isValid(int mid) {
		for(int i = mid; i < mString.length(); i++) {
			if(mString.charAt(i) == '0') {
				return false;
			}
		}
		
		return true;
	}
}
