import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> nums = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			nums.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(nums);
		System.out.print(nums.get((nums.size() / 2))); // 결과값을 내림하기 위해 정수 타입으로 나눗셈
	}
}