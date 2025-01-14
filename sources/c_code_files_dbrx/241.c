#include <stdio.h>

// Function to calculate the fast power
long int FastPower(int base, long int exponent) {
    long int result = 1;
    while (exponent > 0) {
        if (exponent % 2 == 1) {
            result *= base;
        }
        base *= base;
        exponent /= 2;
    }
    return result;
}

long int TetraTion(int number, int tetrate) {
    long int product = 1;
    if (tetrate == 0) return product;
    product = number;
    while (tetrate > 1) {
        product = FastPower(number, product);
        tetrate--;
    }
    return product;
}

int main() {
    int number = 2;
    int tetrate = 3;
    printf("Tetration of %d to the power of %d is: %ld\n", number, tetrate, TetraTion(number, tetrate));
    return 0;
}