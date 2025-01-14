#include <stdio.h>

int main() {
    char xPosition[20]; // buffer size should be at least 19 + 1 for null terminator
    double xPositionValue = 12.3456; // assuming some value for demonstration

    // Using snprintf instead of sprintf_s for GCC compatibility
    snprintf(xPosition, 19, "%.2f", xPositionValue);

    printf("xPosition: %s\n", xPosition);

    return 0;
}