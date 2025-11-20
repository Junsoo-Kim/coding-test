import java.util.*;
import java.io.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 10; i++) {
			int tc = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			Queue<Integer> queue = new LinkedList<>();

			for (int j = 0; j < 8; j++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			int value = 1;
			while (true) {
				int num = queue.poll() - value;

				if (num <= 0) {
					queue.offer(0);
					break;
				}

				queue.offer(num);
				value++;

				if (value > 5)
					value = 1;
			}

			sb.append("#").append(tc);
			for (int num : queue) {
				sb.append(" ").append(num);
			}
			sb.append("\n");
		}
		System.out.print(sb);
	}
}