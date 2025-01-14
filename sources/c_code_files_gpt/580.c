#include <stdio.h>

int sign(int i) {
    if (i > 0) return 1;
    if (i == 0) return 0;
    if (i < 0) return -1;
    return 0; // This line will never be reached, but it satisfies the compiler.
}

int main() {
    printf("%d\n", sign(10));  // Example usage
    printf("%d\n", sign(0));   // Example usage
    printf("%d\n", sign(-10)); // Example usage
    return 0;
}