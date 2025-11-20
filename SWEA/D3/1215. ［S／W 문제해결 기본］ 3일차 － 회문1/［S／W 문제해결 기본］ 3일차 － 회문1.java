import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int length = Integer.parseInt(br.readLine());
			String[][] board = new String[8][8];
			int result = 0;
			String tempStr = "";

			for (int i = 0; i < 8; i++) {
				String row = br.readLine();
				for (int j = 0; j < 8; j++) {
					board[i][j] = Character.toString(row.charAt(j));
				}
			}

			// 행 체크
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j + length <= 8; j++) {
					tempStr = "";
					for (int k = 0; k < length; k++) {
						tempStr += board[i][j + k];
					}

					if (checkPalindrome(tempStr)) {
						result++;
					}
				}
			}

			// 열 체크
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j + length <= 8; j++) {
					tempStr = "";
					for (int k = 0; k < length; k++) {
						tempStr += board[j + k][i];
					}

					if (checkPalindrome(tempStr)) {
						result++;
					}
				}
			}

			sb.append("#" + t + " " + result + "\n");
		}
		System.out.print(sb);
	}

	static boolean checkPalindrome(String str) {
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
}