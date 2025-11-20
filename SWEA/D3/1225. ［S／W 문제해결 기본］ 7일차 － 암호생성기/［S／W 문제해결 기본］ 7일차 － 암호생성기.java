import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			int testNum = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();
			int currentNum = 0;

			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			while (true) {
				for (int i = 1; i <= 5; i++) {
					currentNum = queue.poll() - i;
					// 현재 값이 0이면 루프 종료
					if (currentNum <= 0) {
						currentNum = 0;
						queue.offer(currentNum);
						break;
					} else {
						queue.offer(currentNum);
					}
				}

				if (currentNum == 0) {
					break;
				}
			}

			sb.append("#" + testNum + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}