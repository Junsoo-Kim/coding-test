import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		ArrayList<String> encodedNum = new ArrayList<>(Arrays.asList("0001101", "0011001", "0010011", "0111101",
				"0100011", "0110001", "0101111", "0111011", "0110111", "0001011"));

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			String password = "";
			int[] decodedNums = new int[8];

			for (int i = 0; i < N; i++) {
				String row = br.readLine();

				if (!password.equals("")) {
					continue;
				}

				for (int j = 0; j < M; j++) {
					// 1을 찾으면 거기부터 56개를 저장
					// 만약 인덱스가 오버된다면 최대치까지만 가져옴
					if (row.charAt(j) == '1') {
						if (row.length() >= j + 56) {
							password = row.substring(j, j + 56);
						} else {
							password = row.substring(j, M);
						}
						break;
					}
				}
			}

			// password 전처리
			// 모든 코드는 항상 1로 끝나니까 뒤에 있는 0 제거
			while (password.charAt(password.length() - 1) == '0') {
				password = password.substring(0, password.length() - 1);
			}

			// 길이가 56이 안되는 경우 앞에 0 추가
			while (password.length() < 56) {
				password = "0" + password;
			}

			// 7개씩 8개로 잘라서 숫자로 변환
			for (int i = 0; i < 8; i++) {
				decodedNums[i] = encodedNum.indexOf(password.substring(i * 7, (i + 1) * 7));
			}

			sb.append("#" + t + " " + verify(decodedNums) + "\n");

		}
		System.out.print(sb);
	}

	public static int verify(int[] decodedNums) {
		int oddSum = decodedNums[0] + decodedNums[2] + decodedNums[4] + decodedNums[6];
		int evenSum = decodedNums[1] + decodedNums[3] + decodedNums[5] + decodedNums[7];

		if ((oddSum * 3 + evenSum) % 10 == 0) {
			return oddSum + evenSum;
		} else {
			return 0;
		}
	}
}