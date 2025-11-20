import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String original = br.readLine();
			char prev = '0';
			char curr;
			int result = 0;

			for (int i = 0; i < original.length(); i++) {
				curr = original.charAt(i);
				if (prev != curr) {
					prev = curr;
					result++;
				}
			}

			sb.append("#" + t + " " + result + "\n");
		}
		System.out.print(sb);
	}
}