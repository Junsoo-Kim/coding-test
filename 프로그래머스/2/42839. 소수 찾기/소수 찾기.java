import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    static String[] nums;
    static boolean[] visited;
    
    public int solution(String numbers) {
        // 에라토스테네스의 체 메모이제이션
        boolean[] isPrime = new boolean[10000000];
        Arrays.fill(isPrime, true);
        isPrime[0] = false; isPrime[1] = false;
        
        for(int i = 2; i * i < 10000000; i++){
            if(isPrime[i]){
                for(int j = i * i; j < 10000000; j += i){
                    isPrime[j] = false;
                }
            }
        }
        
        // nums 초기화
        String[] n = new String[numbers.length()];
        for(int i = 0; i < numbers.length(); i++){
            n[i] = numbers.substring(i, i + 1);
        }
        nums = n;
        visited = new boolean[nums.length];
        
        // nums 1개씩 백트래킹
        for(int i = 0; i < nums.length; i++){
            int numInt = Integer.parseInt(nums[i]);
            set.add(numInt);
            visited[i] = true;
            
            dfs(nums[i]);
            
            visited[i] = false;
        }
        
        // 완성된 결과를 돌며 소수 판별
        int answer = 0;
        for(int curr : set){
            if(isPrime[curr]){
                answer++;
                System.out.println(curr);
            }
        }
        
        System.out.println(set);
        
        return answer;
    }
    
    private void dfs(String curr){  
        // nums를 돌면서 안붙인걸 뒤로 하나씩 붙일거임
        for(int i = 0; i < nums.length; i++){
            // 기존에 붙이지 않은 조각인지 검사
            if(!visited[i]){
                String next = curr + nums[i];
                int nextInt = Integer.parseInt(next);
                
                set.add(nextInt);
                visited[i] = true;
            
                dfs(next);
            
                visited[i] = false;
            }
        }
    }
}