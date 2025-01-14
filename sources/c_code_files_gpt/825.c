#include <stdio.h>

int main() {
    char xPosition[20];
    float xPositionValue = 3.14159;

    snprintf(xPosition, 19, "%.2f", xPositionValue);

    printf("%s\n", xPosition);

    return 0;
}