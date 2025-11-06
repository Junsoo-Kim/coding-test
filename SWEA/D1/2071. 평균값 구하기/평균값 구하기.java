import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
        sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] strList = sc.nextLine().split(" ");
			double sum = 0;
            
            for(int i = 0; i < strList.length; i++){
             	   sum += Integer.valueOf(strList[i]);
            }
            
         	System.out.println("#" + test_case + " " + Math.round(sum / strList.length));
		}
	}
}