import java.util.*;
import java.io.*;

public class Main{
    static int k;
    static boolean[] signs;
    static boolean[] visited;
    static ArrayList<String> results;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String min = "9999999999";
        String max = "0";

        k = Integer.parseInt(br.readLine());
        signs = new boolean[k];
        visited = new boolean[10];
        results = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < k; i++){
            String sign = st.nextToken();
            signs[i] = sign.equals("<");
        }

        for(int i = 0; i < 10; i++){
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(i);
            visited[i] = true;
            bt(1, curr);
            visited[i] = false;
        }

        for (String result : results) {
            if(Long.parseLong(result) < Long.parseLong(min)){
                min = result;
            }
            if(Long.parseLong(result) > Long.parseLong(max)){
                max = result;
            }
        }

        sb.append(max).append("\n").append(min);
        System.out.print(sb);
    }

    static void bt(int depth, ArrayList<Integer> curr){
        int before = curr.get(curr.size() - 1);

        if(depth == k + 1){
            String result = "";
            for(int num : curr){
                result = result.concat(String.valueOf(num));
            }

            results.add(result);
            return;
        }

        for(int i = 0; i < 10; i++){
            if(!visited[i] && signs[depth - 1] && before < i){
                visited[i] = true;
                curr.add(i);

                bt(depth + 1, curr);

                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
            else if(!visited[i] && !signs[depth - 1] && before > i){
                visited[i] = true;
                curr.add(i);

                bt(depth + 1, curr);

                visited[i] = false;
                curr.remove(curr.size() - 1);
            }
        }
    }
}
