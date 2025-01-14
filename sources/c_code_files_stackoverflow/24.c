#include <stdio.h>
#include <time.h>

int main() {
    struct tm tm;
    time_t epoch;
    char timestamp[] = "2023-04-01 12:00:00"; // Example timestamp

    if (strptime(timestamp, "%Y-%m-%d %H:%M:%S", &tm) != NULL) {
        epoch = mktime(&tm);
        printf("Epoch timestamp: %ld\n", epoch);
    } else {
        printf("Failed to parse timestamp.\n");
    }

    return 0;
}