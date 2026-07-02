import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            sb.append("#" + t + "\n");
            
            int N = Integer.parseInt(br.readLine());
            
            // result 초기화
            String[] result = new String[N];
            for(int i = 0; i < N; i++) {
            	result[i] = "";
            }
            
            // board 초기화
            int[][] board = new int[N][N];
            for(int i = 0; i < N; i++) {
            	StringTokenizer st = new StringTokenizer(br.readLine());
            	for(int j = 0; j < N; j++) {
            		board[i][j] = Integer.parseInt(st.nextToken());
            	}
            }
            
            // 90도 회전
            board = spin90Degree(board);
            for(int i = 0; i < N; i++) {
            	String temp = "";
            	for(int j = 0; j < N; j++) {
            		temp += board[i][j];
            	}
            	result[i] = result[i] + temp + " ";
            }
            
            // 180도 회전
            board = spin90Degree(board);
            for(int i = 0; i < N; i++) {
            	String temp = "";
            	for(int j = 0; j < N; j++) {
            		temp += board[i][j];
            	}
            	result[i] = result[i] + temp + " ";
            }
            
            // 270도 회전
            board = spin90Degree(board);
            for(int i = 0; i < N; i++) {
            	String temp = "";
            	for(int j = 0; j < N; j++) {
            		temp += board[i][j];
            	}
            	result[i] = result[i] + temp + " ";
            }
            
            for(int i = 0; i < N; i++) {
            	sb.append(result[i] + "\n");
            }
        }
        
        System.out.print(sb);
    }
 	
 	private static int[][] spin90Degree(int[][] board){
 		int[][] newBoard = new int[board.length][board.length];
 		
 		for(int i = 0; i < board.length; i++) {
 			for(int j = 0; j < board.length; j++) {
 				// nx = y, ny = (N - 1) - x
 				newBoard[j][(board.length - 1) - i] = board[i][j];
 			}
 		}
 		
 		return newBoard;
 	}
}