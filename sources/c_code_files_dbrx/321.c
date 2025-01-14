#include <stdio.h>
#include <time.h>

int main() {
    char ft[256];
    time_t timer;
    struct tm *tmp;

    // Get current time/date as epoch seconds from 1970-01-01 UTC
    timer = time(NULL);

    /* Convert and print timestamp to a readable date*/
    tmp = localtime(&timer); // Converts to locale specific time
    strftime(ft, 256, "%D - %T", tmp);

    printf("%s\n", ft); // Fixed the printf statement
    return 0; // Added return statement for main function
}