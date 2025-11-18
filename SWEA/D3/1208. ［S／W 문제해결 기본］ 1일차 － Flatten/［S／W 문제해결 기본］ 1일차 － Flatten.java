import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(br.readLine());
			int maxIndex = 0;
			int minIndex = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> boxHeights = new ArrayList<>();

			for (int i = 0; i < 100; i++) {
				boxHeights.add(Integer.parseInt(st.nextToken()));
			}

			while (N > 0) {
				// 최대값, 최소값 인덱스 탐색
				maxIndex = boxHeights.indexOf(Collections.max(boxHeights));
				minIndex = boxHeights.indexOf(Collections.min(boxHeights));

				// 전부 평탄화 되었을 때 종료
				if (maxIndex == minIndex) {
					break;
				}
				
				// 덤프 1회 실행
				boxHeights.set(maxIndex, boxHeights.get(maxIndex) - 1);
				boxHeights.set(minIndex, boxHeights.get(minIndex) + 1);

				N--;
			}
			sb.append("#" + tc + " ");
			sb.append((Collections.max(boxHeights) - Collections.min(boxHeights)) + "\n");
		}
		System.out.print(sb);
	}
}