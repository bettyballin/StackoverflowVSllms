#include <stdio.h>

#define N 16 // Define a value for N

int main() {
    for (int i = 1; i < N; i *= 2) {
        printf("Current value of i: %d\n", i); // Example operation in the loop
    }
    return 0;
}