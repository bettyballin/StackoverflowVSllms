#include <stdio.h>

int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
}

int main() {
    int n = 10; // Example value to calculate the 10th Fibonacci number
    printf("The %dth Fibonacci number is: %d\n", n, fibonacci(n));
    return 0;
}