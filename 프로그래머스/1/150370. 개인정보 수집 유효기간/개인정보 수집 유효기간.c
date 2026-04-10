#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char term;
    int year;
    int month;
    int day;
} Privacy;

int is_expired(int year, int month, int day, Privacy p, int* terms_lens){
    int result = (year - p.year) * 28 * 12;
    result += (month - p.month) * 28;
    result += day - p.day;
    
    if(terms_lens[p.term - 'A'] * 28 <= result){
        return 1;
    }
    else{
        return 0;
    }
}

int* solution(const char* today, const char* terms[], size_t terms_len, const char* privacies[], size_t privacies_len) {
    int year, month, day;
    sscanf(today, "%d.%d.%d", &year, &month, &day);
    
    int terms_lens[26] = {0, };
    for(int i = 0; i < terms_len; i++){
        char type;
        int len;
        sscanf(terms[i], "%c %d", &type, &len);
        terms_lens[type - 'A'] = len;
    }
    
    Privacy* p_list = (Privacy*) calloc (privacies_len, sizeof(Privacy));
    for(int i = 0 ; i < privacies_len; i++){
        sscanf(privacies[i], "%d.%d.%d %c", &p_list[i].year, &p_list[i].month, &p_list[i].day, &p_list[i].term);
    }
    
    int* result = (int*)malloc(sizeof(int) * privacies_len);
    int count = 0;

    for(int i = 0; i < privacies_len; i++) {
        if(is_expired(year, month, day, p_list[i], terms_lens)) {
            result[count++] = i + 1;
        }
    }
    
    return result;
}