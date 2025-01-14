#include <stdio.h>
#include <time.h>

int main() {
    struct tm timeinfo = {0};

    // Set the date to 1st July 2038
    timeinfo.tm_year = 138; // Year since 1900
    timeinfo.tm_mon = 6;    // Month (0-based, so 6 means July)
    timeinfo.tm_mday = 1;   // Day of the month
    timeinfo.tm_hour = 0;   // Hour (0-23)
    timeinfo.tm_min = 0;    // Minute (0-59)
    timeinfo.tm_sec = 0;    // Second (0-59)

    // Convert to time_t in UTC
    time_t utc_time = timegm(&timeinfo);

    if (utc_time == -1) {
        perror("timegm");
        return 1;
    }

    printf("UTC time for 1st July 2038: %ld\n", (long)utc_time);
    return 0;
}