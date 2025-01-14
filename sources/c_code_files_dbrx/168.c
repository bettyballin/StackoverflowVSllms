#include <stdio.h>
#include <string.h>
#include <time.h>
#include <stdbool.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

// Convert a date string in the format "YYYY-MM-DD HH:MM:SS" to Unix timestamp
time_t strToTimeStamp(const char *dateString, const char* fmt){
    struct tm t;
    memset(&t, 0, sizeof(struct tm));
    // Parse datetime
    strptime(dateString,fmt,&t);
    time_t timestamp = mktime(&t);
    return timestamp;
}

int main(){
    const char* dateTimeString = "2023-11-09 23:57:38";
    const char* format = "%Y-%m-%d %H:%M:%S";
    time_t timestamp = strToTimeStamp(dateTimeString,format);
    printf("Timestamp: %ld\n", (long)timestamp);
    return 0;
}