#include <stdio.h>

int factorial(int n) {
    static int factorials[] = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800};
    return factorials[n];
}

int main() {
    int number = 5; // Change this value to compute factorial of a different number (1-10)
    printf("Factorial of %d is %d\n", number, factorial(number));
    return 0;
}