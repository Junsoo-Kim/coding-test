import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] sizeList = new int[6];
		int shirtBundles = 0;
		int penBundles = 0;
		int pens = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 6; i++) {
			sizeList[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		
		for(int i = 0; i < 6; i++) {
			shirtBundles += Math.ceil((double) sizeList[i] / T);
		}
		
		penBundles = N / P;
		pens = N % P;
		
		sb.append(shirtBundles + "\n" + penBundles + " " + pens);
		System.out.print(sb);
	}
}