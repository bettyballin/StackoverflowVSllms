#include <stdio.h>

// Function to calculate the power of a number using recursion
int pow(int base, int exp) {
    if (exp == 0) return 1;
    else if (exp % 2 == 0)
        // Even exponent, square the result of 'base' raised to half the power.
        return pow(base * base, exp / 2);
    else
        // Odd exponent, multiply by 'base'.
        return base * pow(base * base, (exp - 1) / 2);
}

int main() {
    // Example usage:
    int base = 2;
    int exponent = 3;
    int result = pow(base, exponent);
    printf("%d raised to the power of %d is %d\n", base, exponent, result);
    return 0;
}