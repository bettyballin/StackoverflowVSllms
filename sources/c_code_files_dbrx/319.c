#include <stdio.h>
#include <string.h>

// Define a structure for test results
typedef struct {
    double value;
    double min;
    double max;
} TestResult;

// Example function to convert double to a specific format
// For this example, it just returns the value as is
double A2DtoV(double value) {
    return value;
}

int main() {
    // Example array of test strings
    char *testStrings[] = {
        "Value: %f, Min: %f, Max: %f\n",
        "Second Value: %f, Min: %f, Max: %f\n"
        // Add more as needed
    };

    // Example array of test results
    TestResult testResults[] = {
        {10.0, 5.0, 15.0},
        {20.0, 15.0, 25.0}
        // Add more as needed
    };

    int testID = 0; // Example test ID
    int size = 100; // Example buffer size
    char tempStr[size];

    if (strlen(testStrings[testID]) > size) {
        printf("Error: Input too long to be printed.\n");
    } else {
        snprintf(tempStr, size, testStrings[testID], A2DtoV(testResults[testID].value),
                 A2DtoV(testResults[testID].min),
                 A2DtoV(testResults[testID].max));
        printf("%s", tempStr); // Print the formatted string
    }

    return 0;
}