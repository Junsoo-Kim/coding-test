#include <stdio.h>
#include <stdlib.h>

char* solution(int n){
    char* answer = (char*) calloc (3 * n + 1, sizeof(char));
    int i = 1;
    for(i = 1; i <= n; i++){
        if(i % 2 == 1){strcat(answer, "수");}
        else{strcat(answer, "박");}
    }
    answer[3 * n] = '\0';
    return answer;
}