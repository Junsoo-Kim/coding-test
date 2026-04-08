#include <stdio.h>

int solution(long num) {
    int answer = 0;
    
    while(1){
        if(num == 1 || answer == 500){break;}
        
        if(num % 2 == 0){num /= 2; answer++;}
        else{num = (num * 3) + 1; answer++;}
    }
    
    if(answer == 500){answer = -1;}    
    
    return answer;
}