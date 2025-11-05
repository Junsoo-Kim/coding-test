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
            String str = sc.nextLine();
            String[] strList = str.split(" ");
            int result = 0;
            
            for(int i = 0; i < strList.length; i++){
            	if(Integer.valueOf(strList[i]) % 2 == 1){
                	result += Integer.valueOf(strList[i]);
                }
            }
            
            System.out.println("#" + test_case + " " + result);
		}
      	sc.close();
	}
}