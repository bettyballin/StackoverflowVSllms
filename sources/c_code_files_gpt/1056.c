#include <stdio.h>
#include <string.h>

#define MAX_FORMAT_STRINGS 10

static const char *testStrings[MAX_FORMAT_STRINGS] = {
    "Format 1: %d %d %d",
    "Format 2: %f %f %f",
    // Add other format strings here
};

int safe_snprintf(char *str, size_t size, int testID, int arg1, int arg2, int arg3) {
    // Validate testID is within the bounds of the format strings array
    if (testID < 0 || testID >= MAX_FORMAT_STRINGS) {
        return -1; // Invalid testID
    }

    // Use the validated format string from testStrings
    return snprintf(str, size, testStrings[testID], arg1, arg2, arg3);
}

int main() {
    char tempStr[100];
    int testID = 0; // Example testID
    int value = 10, min = 5, max = 15;

    int result = safe_snprintf(tempStr, sizeof(tempStr), testID, value, min, max);
    if (result < 0) {
        printf("Error in creating format string\n");
    } else {
        printf("Formatted string: %s\n", tempStr);
    }

    return 0;
}