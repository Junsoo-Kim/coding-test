import java.util.*;
import java.io.*;

class Main{
    static int k;
    static int[] nums;
    static int[] lotto;
    static boolean[] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            nums = new int[k];
            lotto = new int[6];
            visited = new boolean[k];

            if(k == 0){
                break;
            }

            for(int i = 0; i < k; i++){
                nums[i] = Integer.parseInt(st.nextToken());
            }

            bt(0);
            System.out.println();
        }
    }

    static void bt(int depth){
        if(depth == 6){
            StringBuilder sb = new StringBuilder();

            for(int num : lotto){
                sb.append(num).append(" ");
            }
            System.out.println(sb);

            return;
        }

        for(int i = 0; i < k; i++){
            if(!visited[i]){
                if(depth == 0){
                    visited[i] = true;
                    lotto[depth] = nums[i];

                    bt(depth + 1);

                    visited[i] = false;
                }
                else if(lotto[depth - 1] < nums[i]){
                    visited[i] = true;
                    lotto[depth] = nums[i];

                    bt(depth + 1);

                    visited[i] = false;
                }
            }
        }
    }
}