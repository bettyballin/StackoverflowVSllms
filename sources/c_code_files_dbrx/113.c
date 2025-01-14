#include <time.h>

int main() {
    struct tm time = {0};
    // Set values for year, month (0-11), day, hour, minute and second
    time.tm_year = 2038 - 1900;
    time.tm_mon = 6; // July is the seventh month (0 indexed)
    time.tm_mday = 1;

    // Convert to UTC time, you might need this value for future use
    time_t timestamp = mktime(&time);
}