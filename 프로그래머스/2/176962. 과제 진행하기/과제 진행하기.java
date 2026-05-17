import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        ArrayList<Integer> result = new ArrayList<>();
        ArrayList<int[]> planList = new ArrayList<>();
        
        for(String[] plan : plans){
            int playtime = Integer.parseInt(plan[2]);
            int hour = Integer.parseInt(plan[1].substring(0, 2));
            int minute = Integer.parseInt(plan[1].substring(3, 5));
            int start = hour * 60 + minute;
            planList.add(new int[]{start, playtime});
        }
        
        // 현재 진행중 초기화
        int currPlan = -1;
        int currPlay = -1;
        
        for(int i = 0; i <= 1440; i++){
            // 과제들을 돌면서
            for(int j = 0; j < planList.size(); j++){
                int[] plan = planList.get(j);
                // 지금 시작하는 과제가 있다면
                if(plan[0] == i){
                    // 현재 진행중인 과제가 완료 상태면 결과에 추가(갱신은 뒤에서 일괄)
                    if(currPlay == 0){
                        result.add(currPlan);
                    }
                    // 현재 진행중인 과제가 있다면 스택에 넘긴 후
                    if(currPlay > 0){
                        stack.push(new int[]{currPlan, currPlay});
                    }
                    // 현재 진행중인 과제 갱신
                    currPlan = j;
                    currPlay = plan[1];
                }
            }
            
            // 현재 진행중인 작업량이 0이면(과제 완료했으면) 결과에 추가
            if(currPlay == 0){
                result.add(currPlan);
                // 멈춘 과제가 있다면 멈춘 과제로 갱신
                if(!stack.isEmpty()){
                    int[] pause = stack.pop();
                    currPlan = pause[0];
                    currPlay = pause[1];
                }
                // 멈춘 과제가 없다면 빈칸으로 갱신
                else{
                    currPlan = -1;
                    currPlay = -1;
                }
            }
            
            // 과제 진행량 1 추가
            currPlay--;
        }
        
        if(currPlan != -1){
            stack.push(new int[]{currPlan, currPlay});
        }
        
        // 만약 24시가 넘었는데도 중단된 과제가 존재할 때 처리
        while(!stack.isEmpty()){
            int[] pause = stack.pop();
            result.add(pause[0]);
        }
        
        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = plans[result.get(i)][0];
        }
        return answer;
    }
}
/*
멈춘 과제들은 스택으로 쌓아놔야 함
스택에 과제의 인덱스와 남은 시간을 int[] 배열로 저장

시간을 문자열에서 분 단위의 int로 변경하고 -> time
playtime도 int로 변경해서 두개를 int[] 배열로 저장. 해당 배열의 인덱스가 과제의 인덱스

0부터 1440까지 for문으로 돌면서

1. 현재 진행중인 작업량이 0이면
- 결과 배열에 해당 과제의 인덱스를 저장
- 과제 인덱스, 작업량을 초기화

현재 진행중인 작업량이 음수면
- 진행하고 있는 작업이 없다는거임
- 스택에서 작업 꺼내와서 진행 시작

2. time == i면
- 현재 진행중인 과제 인덱스가 -1일때,
 - 과제 인덱스, 작업량을 갱신
- 현재 진행중인 과제 인덱스가 존재할 때
 - 현재 진행중인 과제 인덱스와 작업량을 int[]배열로 묶어서 stack에 저장 후
 - 과제 인덱스, 작업량을 갱신

2-1. time != i면
- 현재 진행중인 작업량에 -1
*/