import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            int result = 1;
            int[][] sudoku = new int[9][9];
            for(int i = 0; i < 9; i++){
         		StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++){
                	sudoku[i][j] = Integer.parseInt(st.nextToken());	
                }
            }
            
            
            // 가로줄 체크
            for(int i = 0; i < 9; i++){
                int sum = 0;
            	HashSet<Integer> sudokuSet = new HashSet<>();
                for(int j = 0; j < 9; j++){
                    sum += sudoku[i][j];
                    sudokuSet.add(sudoku[i][j]);
                }
                if(sudokuSet.size() != 9 || sum != 45){
                 	result = 0;
                    break;
                }
            }
            
            // 세로줄 체크
            for(int i = 0; i < 9; i++){
                int sum = 0;
            	HashSet<Integer> sudokuSet = new HashSet<>();
                for(int j = 0; j < 9; j++){
                    sum += sudoku[j][i];
                    sudokuSet.add(sudoku[j][i]);
                }
                if(sudokuSet.size() != 9 || sum != 45){
                 	result = 0;
                    break;
                }
            }
            
            // 3 x 3 격자 체크
            for(int i = 0; i < 9; i+=3){
                for(int j = 0; j < 9; j+=3){
                    int sum = 0;
            		HashSet<Integer> sudokuSet = new HashSet<>();
                    sum += sudoku[i][j] + sudoku[i][j + 1] + sudoku[i][j + 2]
                        + sudoku[i + 1][j] + sudoku[i + 1][j + 1] + sudoku[i + 1][j + 2]
                        + sudoku[i + 2][j] + sudoku[i + 2][j + 1] + sudoku[i + 2][j + 2];
                    sudokuSet.add(sudoku[i][j]);
                    sudokuSet.add(sudoku[i][j + 1]);
                    sudokuSet.add(sudoku[i][j + 2]);
                    sudokuSet.add(sudoku[i + 1][j]);
                    sudokuSet.add(sudoku[i + 1][j + 1]);
                    sudokuSet.add(sudoku[i + 1][j + 2]);
                    sudokuSet.add(sudoku[i + 2][j]);
                    sudokuSet.add(sudoku[i + 2][j + 1]);
                    sudokuSet.add(sudoku[i + 2][j + 2]);
                    
                    if(sudokuSet.size() != 9 || sum != 45){
                 		result = 0;
                    	break;
                	}
                }   
            }
            System.out.println("#" + t + " " + result);
        }
        br.close();
    }
}