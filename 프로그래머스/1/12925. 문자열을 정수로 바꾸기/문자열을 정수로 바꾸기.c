#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int solution(const char* s) {
    int answer = 1;
    int s_len = strlen(s);
    char* s_cp = (char*) calloc (sizeof(char), s_len);
    if(s[0] < '0' || s[0] > '9'){
        if(s[0] == '-'){answer = -1;}
        int i;
        for(i = 1; i < s_len; i++){
            s_cp[i - 1] = s[i];
        }
        s_cp[s_len-1] = '\0';
        s = s_cp;
    }
    answer *= atoi(s);
    free(s_cp);
    return answer;
}