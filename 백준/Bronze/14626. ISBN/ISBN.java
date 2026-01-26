import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String isbn = br.readLine();
		int sum = 0;
		int check = Character.getNumericValue(isbn.charAt(isbn.length()- 1));
		boolean isMissingOdd = false;
		
		for(int i = 0; i < isbn.length() - 1; i++) {
			if(isbn.charAt(i) == '*') {
				if(i % 2 == 0) {
					isMissingOdd = true;
				}
				continue;
			}
			
			if(i % 2 == 0) {
				sum += Character.getNumericValue(isbn.charAt(i));
			}
			else {
				sum += 3 * Character.getNumericValue(isbn.charAt(i));
			}
		}
		
		for(int i = 0; i < 10; i++) {
			if(isMissingOdd) {
				sum += i;
				if((10 - sum % 10) % 10 == check) {
					sb.append(i);
					break;
				}
				sum -= i;
			}
			else {
				sum += 3 * i;
				if((10 - sum % 10) % 10 == check) {
					sb.append(i);
					break;
				}
				sum -= 3 * i;
			}
		}
		
		System.out.print(sb);
	}
}