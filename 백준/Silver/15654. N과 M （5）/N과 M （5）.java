import java.util.*;
import java.io.*;

public class Main{
    static int N, M;
    static int[] nums;
    static int[] seq;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        seq = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        bt(0);
    }

    static void bt(int depth){
        if(depth == M){
            StringBuilder sb = new StringBuilder();
            for(int num : seq){
                sb.append(num).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i = 0; i < N; i++){
            if(!visited[i]){
                visited[i] = true;
                seq[depth] = nums[i];

                bt(depth + 1);

                visited[i] = false;
            }
        }
    }
}