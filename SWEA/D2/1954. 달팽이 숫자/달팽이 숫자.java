import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
         	int N = Integer.parseInt(br.readLine());
            int size = N;
            int[][] numList = new int[N][N];
            
            // 상 하 좌 우 좌표값의 한계값
            int currentNum = 1;
            int upperLimit = -1;
            int lowerLimit = N;
            int leftLimit = -1;
            int rightLimit = N;
                
            // 우 방향으로 이동 N만큼 먼저 해야함
            for(int i = 0; i < rightLimit; i++){
                numList[0][i] = currentNum;
                currentNum++;
            }
            N--;
            
            while(true){
                if(N == 0){break;}
                // 하 방향으로 이동
                upperLimit++;
                for(int i = upperLimit + 1; i < lowerLimit; i++){
                    numList[i][rightLimit - 1] = currentNum;
                    currentNum++;
                }
                
                // 좌 방향으로 이동
                rightLimit--;
                for(int i = rightLimit - 1; i > leftLimit; i--){
                    numList[lowerLimit - 1][i] = currentNum;
                    currentNum++;
                }
                N--;
                  
                if(N == 0){break;}
                // 상 방향으로 이동
                lowerLimit--;
                for(int i = lowerLimit - 1; i > upperLimit; i--){
                    numList[i][leftLimit + 1] = currentNum;
                    currentNum++;
                }
                
                // 우 방향으로 이동
                leftLimit++;
                for(int i = leftLimit + 1; i < rightLimit; i++){
                    numList[upperLimit + 1][i] = currentNum;
                	currentNum++;
                }  
                
                N--; 
            }
            
            System.out.println("#" + t);
            for(int i = 0; i < size; i++){
             	for(int j = 0; j < size; j++){
                    System.out.print(numList[i][j] + " ");
                }
                System.out.println();
            }
        }
    }        
}