#include <stdio.h>

int main() {
    int n = 10;  // Define the value of n
    int i;

    for (i = 0; (i - 1) < n; i++) {
        char b[12]; // Allocate enough space for an integer string representation
        sprintf(b, "%d", i);
        // Use b as needed
        printf("%s\n", b);  // Print the string to verify its correctness
    }

    return 0;
}