import java.io.*;
import java.util.*;

public class Solution {
	static int[][] board;
	static int D, W, K;
	static int result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			result = K;
			
			board = new int[D][W];
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			if(isOK()) {
				sb.append(0).append("\n");
				continue;
			}
			
			dfs(0, 0);
			
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
	
	private static boolean isOK() {
		for(int i = 0; i < W; i++) {
			int maxCnt = 0;
			int cnt = 1;
			int curr = board[0][i];
			
			for(int j = 1; j < D; j++) {
				if(board[j][i] == curr) {
					cnt++;
				}
				else {
					if(maxCnt < cnt) maxCnt = cnt;
					cnt = 1;
					curr = board[j][i];
				}
			}
			if(maxCnt < cnt) maxCnt = cnt;
			
			if(maxCnt < K) {
				return false;
			}
		}
		return true;
	}
	
	private static void useMed(int row, int feature) {
		for(int i = 0; i < W; i++) {
			board[row][i] = feature;
		}
	}
	
	private static void dfs(int row, int count) {
		if(count >= result) return;
		
		if(row == D) {
			if(isOK()) {
				result = count;
			}
			return;
		}
		
		dfs(row + 1, count);
		
		int[] temp = new int[W];
		System.arraycopy(board[row], 0, temp, 0, W);
		
		useMed(row, 0);
		if(isOK()) {
			if(count + 1 < result) result = count + 1;
		} else {
			dfs(row + 1, count + 1);
		}
		
		useMed(row, 1);
		if(isOK()) {
			if(count + 1 < result) result = count + 1;
		} else {
			dfs(row + 1, count + 1);
		}
		
		board[row] = temp;
	}
}