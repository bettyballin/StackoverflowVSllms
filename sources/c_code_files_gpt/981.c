#include <time.h>
#include <stdio.h>

int main() {
    time_t currentTime;
    time(&currentTime);
    printf("Current time: %s\n", ctime(&currentTime));
    return 0;
}