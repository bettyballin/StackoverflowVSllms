#include <stdio.h>

// Define a function to convert A2D to V
double A2DtoV(double value) {
    // Assuming a simple conversion, replace with actual implementation
    return value;
}

// Define a struct to hold test results
typedef struct {
    double value;
    double min;
    double max;
} TestResult;

// Define an array of test results
TestResult testResults[10]; // Replace 10 with actual size

int main() {
    int testID = 0; // Replace with actual test ID
    int size = 1024; // Replace with actual buffer size
    char tempStr[size];

    snprintf(tempStr, size, "%f %f %f", A2DtoV(testResults[testID].value),
                                A2DtoV(testResults[testID].min),
                                A2DtoV(testResults[testID].max));

    printf("%s\n", tempStr);

    return 0;
}