import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int k;
    static int[] cards;
    static boolean[] visited;
    static int[] result;
    static HashSet<Integer> intList = new HashSet<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cards = new int[n];
        visited = new boolean[n];
        result = new int[k];

        for(int i = 0; i < n; i++){
            cards[i] = Integer.parseInt(br.readLine());
        }

        dfs(0);

        System.out.print(intList.toArray().length);
    }

    static void dfs(int depth){
        if(depth == k){
            String numResult = "";

            for(int num : result){
                numResult = numResult.concat(String.valueOf(num));
            }

            intList.add(Integer.parseInt(numResult));
            return;
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                result[depth] = cards[i];

                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }
}