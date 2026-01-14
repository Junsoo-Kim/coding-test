import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		int i = Integer.parseInt(br.readLine());
		
		sb.append(s.charAt(i - 1));
		System.out.print(sb);
	}
}
