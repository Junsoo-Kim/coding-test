import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] seq;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        seq = new int[M];
        visited = new boolean[N];

        bt(0);
    }

    static void bt(int depth){
        if(depth == M){
            // 내림차순 제외
            if(isDescending()){
                return;
            }

            StringBuilder sb = new StringBuilder();
            for(int num : seq){
                sb.append(num + 1).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 0; i < N; i++){
            visited[i] = true;
            seq[depth] = i;

            bt(depth + 1);

            visited[i] = false;
        }
    }

    static boolean isDescending(){
        boolean result = false;

        for(int i = 1; i < M; i++){
            if(seq[i-1] > seq[i]){
                result = true;
            }
        }

        return result;
    }
}