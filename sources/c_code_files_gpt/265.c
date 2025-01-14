#include <stdio.h>
#include <time.h>
#include <string.h>

int main() {
    const char *datetime_str = "2023-10-05 14:48:00";
    struct tm tm;
    time_t epoch_time;

    // Initialize the struct tm to zero
    memset(&tm, 0, sizeof(struct tm));

    // Parse the datetime string
    if (strptime(datetime_str, "%Y-%m-%d %H:%M:%S", &tm) == NULL) {
        fprintf(stderr, "Failed to parse datetime string\n");
        return 1;
    }

    // Convert struct tm to time_t (Unix timestamp)
    epoch_time = mktime(&tm);

    if (epoch_time == -1) {
        fprintf(stderr, "Failed to convert to Unix timestamp\n");
        return 1;
    }

    printf("Unix Timestamp: %ld\n", (long)epoch_time);

    return 0;
}