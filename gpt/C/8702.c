#include <stdio.h>\n#include <string.h>\n\n#define MAX_FORMAT_STRINGS 10\n\nstatic const char *testStrings[MAX_FORMAT_STRINGS] = {\n    "Format 1: %d %d %d",\n    "Format 2: %f %f %f",\n    // Add other format strings here\n};\n\nint safe_snprintf(char *str, size_t size, int testID, int arg1, int arg2, int arg3) {\n    // Validate testID is within the bounds of the format strings array\n    if (testID < 0 || testID >= MAX_FORMAT_STRINGS) {\n        return -1; // Invalid testID\n    }\n\n    // Use the validated format string from testStrings\n    return snprintf(str, size, testStrings[testID], arg1, arg2, arg3);\n}\n\nint main() {\n    char tempStr[100];\n    int testID = 0; // Example testID\n    int value = 10, min = 5, max = 15;\n\n    int result = safe_snprintf(tempStr, sizeof(tempStr), testID, value, min, max);\n    if (result < 0) {\n        printf("Error in creating format string\n");\n    } else {\n        printf("Formatted string: %s\n", tempStr);\n    }\n\n    return 0;\n}