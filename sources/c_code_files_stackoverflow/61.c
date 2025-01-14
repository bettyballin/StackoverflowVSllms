#include <stdio.h>
#include <stdlib.h>

// Function to calculate the maximum of two numbers
int max(int a, int b) {
    return (a > b) ? a : b;
}

// Function to calculate the minimum of two numbers
int min(int a, int b) {
    return (a < b) ? a : b;
}

int main() {
    int maxVal, minVal, count, sum, secondorder, x;

    // Initialize variables
    maxVal = 0;
    minVal = 0;
    count = 0;
    sum = 0;
    secondorder = 0;

    // Example input
    x = 5;

    // Your code here
    maxVal = max(x, maxVal);
    minVal = min(x, minVal);
    count += 1;
    sum += x;
    secondorder += x * x;

    // Print results
    printf("Max Value: %d\n", maxVal);
    printf("Min Value: %d\n", minVal);
    printf("Count: %d\n", count);
    printf("Sum: %d\n", sum);
    printf("Second Order: %d\n", secondorder);

    return 0;
}