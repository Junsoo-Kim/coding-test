#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char * solution(const char* phone_number){
    int phone_num_len = strlen(phone_number);
    char* answer = (char*) calloc (sizeof(char), phone_num_len + 1);
    int i = 0;
    for(i; i < phone_num_len; i++){
        if(i >= phone_num_len - 4){
            answer[i] = phone_number[i];
        }
        else{
            answer[i] = '*';
        }
    }
    return answer;
}