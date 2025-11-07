import java.util.*;
import java.io.*;

class Solution{    
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
        	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            ArrayList<Integer> posibleList = new ArrayList<>();
            int result = 0;
            
            // 퍼즐 입력 받기
            int[][] puzzle = new int[N][N];
            for(int i = 0; i < N; i++){
            	st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){
                	puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                	// 현재 위치가 빈칸일 때
                    if(puzzle[i][j] == 1){
                        // 왼쪽의 인덱스가 0 이상 N - 1 이하이면서 오른쪽의 인덱스가 N 이하이면서 왼쪽이 0이면서 오른쪽이 1일때
                        // 또는 왼쪽의 인덱스가 -1이면서 오른쪽이 1일때
                        // 가로 자리가 성립
                        if((j >= 1 && j < N - 1 && puzzle[i][j - 1]  == 0 && puzzle[i][j + 1] == 1) ||
                           (j == 0 && puzzle[i][j + 1] == 1)){
                        	int length = 0;
                            // 가로 방향으로 1일때까지 length 측정
                            for(int k = 0; j + k < N; k++){
                                if(puzzle[i][j+k] == 1){
                                        length++;
                                }
                                else{
                                        break;
                                }
                            }
                            posibleList.add(length);
                        }
                        
                        // 위쪽의 인덱스가 0 이상 N - 1 이하이면서 위가 0이면서 아래가 1일 때
                        // 또는 위쪽의 인덱스가 -1이면서 아래가 1일때
                         // 세로 자리가 성립
                        if((i >= 1 && i < N - 1 && puzzle[i - 1][j]  == 0 && puzzle[i + 1][j] == 1) ||
                           (i == 0 && puzzle[i + 1][j] == 1)){
                        	int length = 0;
                            // 세로 방향으로 1일때까지 length 측정
                            for(int k = 0; i + k < N; k++){
                            	if(puzzle[i + k][j] == 1){
                                        length++;
                                }
                                else{
                                        break;
                                }
                            }
                            posibleList.add(length);
                        }
                    }
                }
            }
            
            // posibleList에 add된 length가 K인 경우 result++; 
            for(int i = 0; i < posibleList.size(); i++){
             	if(posibleList.get(i) == K){
                	result++;   
                }
            }
            
            System.out.println("#" + t + " " + result);
        }
        br.close();
    }
}