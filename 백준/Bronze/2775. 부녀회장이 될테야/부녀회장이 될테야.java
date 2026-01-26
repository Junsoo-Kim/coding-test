import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			int k = Integer.parseInt(br.readLine()) + 1;
			int n = Integer.parseInt(br.readLine());
			
			int[][] apartment = new int[k][n];
			
			for(int i = 1; i <= n; i++) {
				apartment[0][i-1] = i;
			}
			
			for(int i = 1; i < k; i++) {
				for(int j = 0; j < n; j++) {
					if(j == 0) {
						apartment[i][j] = apartment[i-1][j];
					}
					else {
						apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
					}
				}
			}
			
			sb.append(apartment[k-1][n-1] + "\n");
		}
		System.out.print(sb);
	}
}
