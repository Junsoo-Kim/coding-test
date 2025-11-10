import java.util.*;
import java.io.*;

class Solution{
 	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            double[][] studentList = new double[N][2];
            double result = 0;
            
            // 전체 학생 총점 구하기
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
             	studentList[i][0] = (float) i + 1;
                studentList[i][1] = Integer.parseInt(st.nextToken()) * 0.35 
                    + Integer.parseInt(st.nextToken()) * 0.45 
                    + Integer.parseInt(st.nextToken()) * 0.20;
            }

            Arrays.sort(studentList, (a, b) -> Double.compare(a[1], b[1]));
            
            // K 학생 등급 찾기
            for(int i = 0; i < N; i++){
             	if(studentList[i][0] == K){
                    result = Math.ceil((double) (i + 1) / (N / 10));
                    break;
                }
            }
            sb.append("#" + t + " " + getGrade(result) + "\n");
        }
        System.out.print(sb);
    }
    
   private static String getGrade(double score){       
    if(score == 10.0){
        return "A+";    
    }
    else if(score == 9.0){
        return "A0";
    }
    else if(score == 8.0){
        return "A-";
    }
    else if(score == 7.0){
        return "B+";
    }
    else if(score == 6.0){
        return "B0";
    }
    else if(score == 5.0){
        return "B-";
    }
    else if(score == 4.0){
        return "C+";
    }
    else if(score == 3.0){
        return "C0";
    }
    else if(score == 2.0){
        return "C-";
    }
    else if(score == 1.0){
        return "D0";
    }
    else{
        return "";
    }
   }
}