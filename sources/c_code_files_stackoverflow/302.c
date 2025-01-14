#include <stdio.h>

// Function to count the number of set bits in an integer
int CountBits(int n) {
    int count = 0;
    while (n) {
        count += n & 1;
        n >>= 1;
    }
    return count;
}

int numTransitions(int a) {
    int b = a >> 1; // sign-extending shift properly counts bits at the ends
    int c = a ^ b;  // xor marks bits that are not the same as their neighbors on the left
    return CountBits(c); // count number of set bits in c
}

int main() {
    int a = 10; // Test value
    printf("Number of transitions: %d\n", numTransitions(a));
    return 0;
}